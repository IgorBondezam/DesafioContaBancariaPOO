package br.com.IgorBank.domain;

import br.com.IgorBank.enums.TipoAcaoBancaria;
import br.com.IgorBank.enums.TipoBeneficios;

import java.time.LocalDateTime;
import java.util.List;

public class ContaSalario extends Conta{

    private String instituicaoEnsinoVinculada;
    private List<TipoBeneficios> beneficios;

    public ContaSalario() {
    }

    public ContaSalario(Long numeroConta, Banco banco, Double saldo, TipoAcaoBancaria tipoAcao, boolean conjunta, String instituicaoEnsinoVinculada) {
        super(numeroConta, banco, saldo, tipoAcao, conjunta);
        this.instituicaoEnsinoVinculada = instituicaoEnsinoVinculada;
    }

    public ContaSalario(Long numeroConta, Banco banco, Double saldo, TipoAcaoBancaria tipoAcao, LocalDateTime dataCriacao, boolean conjunta, String instituicaoEnsinoVinculada) {
        super(numeroConta, banco, saldo, tipoAcao, dataCriacao, conjunta);
        this.instituicaoEnsinoVinculada = instituicaoEnsinoVinculada;
    }

    @Override
    public Double deposito(Double valor, LocalDateTime diaDeposito, Cliente cliente) {
        super.gerarCalculo(valor, diaDeposito, false, TipoAcaoBancaria.DEPOSITO, cliente);
        return super.getSaldo();
    }

    @Override
    public Double saque(Double valor, LocalDateTime diaSaque, Cliente cliente) {
        super.gerarCalculo(valor, diaSaque,true, TipoAcaoBancaria.SAQUE, cliente);
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
