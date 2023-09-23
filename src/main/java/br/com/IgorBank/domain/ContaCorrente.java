package br.com.IgorBank.domain;

import br.com.IgorBank.enums.TipoAcaoBancaria;
import br.com.IgorBank.domain.interfaces.TransacoesComplexas;
import br.com.IgorBank.enums.AplicacaoCID;
import br.com.IgorBank.exceptions.ErrorFinanciamento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta implements TransacoesComplexas {

    public ContaCorrente() {
    }

    public ContaCorrente(Long numeroConta, Banco banco, Double saldo, boolean contaConjunta) {
        super(numeroConta, banco, saldo, TipoAcaoBancaria.CRIACAO_CONTA, contaConjunta);
    }

    public ContaCorrente(Long numeroConta, Banco banco, Double saldo,
                         LocalDateTime dataCriacao, boolean conjunta) {
        super(numeroConta, banco, saldo, TipoAcaoBancaria.CRIACAO_CONTA, dataCriacao, conjunta);
    }

    @Override
    public Double deposito(Double valor, LocalDateTime diaDeposito) {
        super.gerarCalculo(valor, diaDeposito, false, TipoAcaoBancaria.DEPOSITO, super.getCliente());
        return super.getSaldo();
    }

    @Override
    public Double saque(Double valor, LocalDateTime diaSaque) {
        super.gerarCalculo(valor, diaSaque, true,TipoAcaoBancaria.SAQUE, super.getCliente());
        return super.getSaldo();
    }


    @Override
    public void financiar(Double valorFinanciado, Long mesesParcelados, LocalDateTime diaInicio) throws ErrorFinanciamento {
        if(mesesParcelados < 24){
            throw new ErrorFinanciamento("Para Conta Corrente - Há um valor mínimo de 24 parcelas!");
        }
        if(valorFinanciado < 60000){
            throw new ErrorFinanciamento("Para Conta Corrente - Há um valor mínimo de R$ 60.000,00 como valor de financiamento!");
        }
        super.getFinanciamentos().addAll(gerarFinanciamentos(valorFinanciado, diaInicio, mesesParcelados, super.getCliente()));

        validarMesesPagos(super.getFinanciamentos(), super.getCliente());
    }

    private List<Financiamento> gerarFinanciamentos(Double valorFinanciado, LocalDateTime diaInicio,
                                                    Long mesesParcelados, Cliente cliente){
        super.gerarCalculo(valorFinanciado, diaInicio,false, TipoAcaoBancaria.FINANCIAMENTO, cliente);
        Double jurosContaCorrente = 1.1;
        List<Financiamento> financiamentos = new ArrayList<>();
        for (int i = 1; i<=mesesParcelados; i++){
            Financiamento financiamento = new Financiamento(valorFinanciado, diaInicio,
                    diaInicio.plusMonths(i), i,jurosContaCorrente+(i*(jurosContaCorrente-1)),
                    false, cliente);
            financiamento.setValorParcela(valorFinanciado/mesesParcelados * financiamento.getJurosParcela());
            financiamentos.add(financiamento);
        }
        return financiamentos;
    }

    private void validarMesesPagos(List<Financiamento> financiamentos, Cliente cliente){
        List<Financiamento> financiamentosVencidos = financiamentos.stream().filter(financiamento ->
                financiamento.getDiaPagamentoParcela().isBefore(LocalDateTime.now())
        ).toList();
        pagarFinanciamentosVencidos(financiamentosVencidos, cliente);
    }
    private void pagarFinanciamentosVencidos(List<Financiamento> financiamentos, Cliente cliente){
        financiamentos.forEach(pagar -> {
            pagar.setPaga(true);
            super.gerarCalculo(pagar.getValorParcela(), pagar.getDiaPagamentoParcela(), true,
                    TipoAcaoBancaria.FINANCIAMENTO, cliente);
        });
    }

    @Override
    public void aplicacao(Double valorAplicacao, LocalDateTime diaInicio, AplicacaoCID aplicacaoCID) {
        super.getAplicacaos().addAll(gerarAplicacoes(valorAplicacao, diaInicio, super.getCliente(), aplicacaoCID));
        validarMesesRecebidos(super.getAplicacaos(), super.getCliente());
    }

    private List<Aplicacao> gerarAplicacoes(Double valorAplicado, LocalDateTime diaInicio,
                                            Cliente cliente, AplicacaoCID aplicacaoCID){
        super.gerarCalculo(valorAplicado, diaInicio, true,
                TipoAcaoBancaria.APLICACAO, cliente);
        List<Aplicacao> aplicacaos = new ArrayList<>();
        for (int i = 1; i<= LocalDate.now().getMonthValue(); i++){
            Aplicacao aplicacao = new Aplicacao(valorAplicado, diaInicio,
                    diaInicio.plusMonths(i), aplicacaoCID,
                    false, cliente);
            aplicacao.setValorAplicacao(valorAplicado * aplicacao.getJurosAplicacao());
            aplicacaos.add(aplicacao);
        }
        return aplicacaos;
    }

    private void validarMesesRecebidos(List<Aplicacao> aplicacaos, Cliente cliente){
        List<Aplicacao> AplicacaoVencidos = aplicacaos.stream().filter(financiamento ->
                financiamento.getDiaRecebimentoAplicacao().isBefore(LocalDateTime.now())
        ).toList();
        pagarAplicacoesVencidos(AplicacaoVencidos, cliente);
    }
    private void pagarAplicacoesVencidos(List<Aplicacao> aplicacaos, Cliente cliente){
        aplicacaos.forEach(receber -> {
            receber.setPaga(true);
            super.gerarCalculo(receber.getValorAplicacao(), receber.getDiaRecebimentoAplicacao(), false,
                    TipoAcaoBancaria.APLICACAO, cliente);
        });
    }
}
