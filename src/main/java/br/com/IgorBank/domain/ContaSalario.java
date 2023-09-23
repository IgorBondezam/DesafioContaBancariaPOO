package br.com.IgorBank.domain;

import br.com.IgorBank.enums.TipoAcaoBancaria;
import br.com.IgorBank.enums.TipoBeneficios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContaSalario extends Conta{

    private String instituicaoEnsinoVinculada;
    private List<TipoBeneficios> beneficios = new ArrayList<>();

    public ContaSalario() {
    }

    public ContaSalario(Long numeroConta, Banco banco, Double saldo, boolean conjunta, String instituicaoEnsinoVinculada) {
        super(numeroConta, banco, saldo, TipoAcaoBancaria.CRIACAO_CONTA, conjunta);
        this.instituicaoEnsinoVinculada = instituicaoEnsinoVinculada;
    }

    public ContaSalario(Long numeroConta, Banco banco, Double saldo, LocalDateTime dataCriacao, boolean conjunta, String instituicaoEnsinoVinculada) {
        super(numeroConta, banco, saldo, TipoAcaoBancaria.CRIACAO_CONTA, dataCriacao, conjunta);
        this.instituicaoEnsinoVinculada = instituicaoEnsinoVinculada;
    }

    @Override
    public Double deposito(Double valor, LocalDateTime diaDeposito) {
        super.gerarCalculo(valor, diaDeposito, false, TipoAcaoBancaria.DEPOSITO, super.getCliente());
        return super.getSaldo();
    }

    @Override
    public Double saque(Double valor, LocalDateTime diaSaque) {
        super.gerarCalculo(valor, diaSaque,true, TipoAcaoBancaria.SAQUE, super.getCliente());
        return super.getSaldo();
    }

    public List<TipoBeneficios> getBeneficios() {
        return beneficios;
    }

    public String getInstituicaoEnsinoVinculada() {
        return instituicaoEnsinoVinculada;
    }

    public void setInstituicaoEnsinoVinculada(String instituicaoEnsinoVinculada) {
        this.instituicaoEnsinoVinculada = instituicaoEnsinoVinculada;
    }

    public void adicionarBeneficio(TipoBeneficios tipoBeneficio){
        //Se tivesse alguma regra
        beneficios.add(tipoBeneficio);
    }
}
