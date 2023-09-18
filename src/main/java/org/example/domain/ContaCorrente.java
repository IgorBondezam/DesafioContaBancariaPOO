package org.example.domain;

import org.example.domain.interfaces.TransacoesComplexas;
import org.example.enums.AplicacaoCID;
import org.example.enums.TipoAcaoBancaria;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta implements TransacoesComplexas {

    private Long teste;

    public Long getTeste() {
        return teste;
    }

    public void setTeste(Long teste) {
        this.teste = teste;
    }

    public ContaCorrente() {
    }

    public ContaCorrente(Long numeroConta, Banco banco, Double saldo, boolean contaConjunta) {
        super(numeroConta, banco, saldo, TipoAcaoBancaria.CRIACAO_CONTA, contaConjunta);
    }

    @Override
    public Double deposito(Double valor, LocalDateTime diaDeposito, Cliente cliente) {
        super.gerarCalculo(valor, diaDeposito, false, TipoAcaoBancaria.DEPOSITO, cliente);
        return super.getSaldo();
    }

    @Override
    public Double saque(Double valor, LocalDateTime diaSaque, Cliente cliente) {
        super.gerarCalculo(valor, diaSaque, true,TipoAcaoBancaria.SAQUE, cliente);
        return super.getSaldo();
    }


    @Override
    public void financiar(Double valorFinanciado, Long mesesParcelados, Cliente cliente, LocalDateTime diaInicio) throws Exception {

    }

    @Override
    public void aplicacao(Double valorAplicacao, LocalDateTime diaInicio, AplicacaoCID aplicacaoCID, Cliente cliente) {

    }
}
