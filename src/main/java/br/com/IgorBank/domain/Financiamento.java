package br.com.IgorBank.domain;

import java.time.LocalDateTime;

public class Financiamento {

    private Double valorTotalFinanciado;
    private LocalDateTime diaInicialFinanciamento;
    private LocalDateTime diaPagamentoParcela;
    private Integer numeroParcelas;
    private Double jurosParcela;
    private boolean paga;
    private Cliente cliente;
    private Double valorParcela;

    public Financiamento(Double valorTotalFinanciado, LocalDateTime diaInicialFinanciamento,
                         LocalDateTime diaPagamentoParcela, Integer numeroParcelas,
                         Double jurosParcela, boolean paga, Cliente cliente) {
        this.valorTotalFinanciado = valorTotalFinanciado;
        this.diaInicialFinanciamento = diaInicialFinanciamento;
        this.diaPagamentoParcela = diaPagamentoParcela;
        this.numeroParcelas = numeroParcelas;
        this.jurosParcela = jurosParcela;
        this.paga = paga;
        this.cliente = cliente;
    }

    public Double getValorTotalFinanciado() {
        return valorTotalFinanciado;
    }

    public void setValorTotalFinanciado(Double valorTotalFinanciado) {
        this.valorTotalFinanciado = valorTotalFinanciado;
    }

    public LocalDateTime getDiaInicialFinanciamento() {
        return diaInicialFinanciamento;
    }

    public void setDiaInicialFinanciamento(LocalDateTime diaInicialFinanciamento) {
        this.diaInicialFinanciamento = diaInicialFinanciamento;
    }

    public LocalDateTime getDiaPagamentoParcela() {
        return diaPagamentoParcela;
    }

    public void setDiaPagamentoParcela(LocalDateTime diaPagamentoParcela) {
        this.diaPagamentoParcela = diaPagamentoParcela;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Double getJurosParcela() {
        return jurosParcela;
    }

    public void setJurosParcela(Double jurosParcela) {
        this.jurosParcela = jurosParcela;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(Double valorParcela) {
        this.valorParcela = valorParcela;
    }
}
