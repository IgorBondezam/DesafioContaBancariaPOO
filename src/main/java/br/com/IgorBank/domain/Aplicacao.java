package br.com.IgorBank.domain;

import br.com.IgorBank.enums.AplicacaoCID;

import java.time.LocalDateTime;

public class Aplicacao {

    private Double valorTotalAplicado;
    private LocalDateTime diaInicialAplicado;
    private LocalDateTime diaRecebimentoAplicacao;
    private Double jurosAplicacao;
    private boolean paga;
    private Cliente cliente;
    private Double valorAplicacao;

    public Aplicacao(Double valorTotalAplicado, LocalDateTime diaInicialAplicado,
                     LocalDateTime diaRecebimentoAplicacao, AplicacaoCID jurosAplicacao,
                     boolean paga, Cliente cliente) {
        this.valorTotalAplicado = valorTotalAplicado;
        this.diaInicialAplicado = diaInicialAplicado;
        this.diaRecebimentoAplicacao = diaRecebimentoAplicacao;
        this.jurosAplicacao = jurosAplicacao.getPorcentagemAplicacao();
        this.paga = paga;
        this.cliente = cliente;
    }

    public Double getValorTotalAplicado() {
        return valorTotalAplicado;
    }

    public void setValorTotalAplicado(Double valorTotalAplicado) {
        this.valorTotalAplicado = valorTotalAplicado;
    }

    public LocalDateTime getDiaInicialAplicado() {
        return diaInicialAplicado;
    }

    public void setDiaInicialAplicado(LocalDateTime diaInicialAplicado) {
        this.diaInicialAplicado = diaInicialAplicado;
    }

    public LocalDateTime getDiaRecebimentoAplicacao() {
        return diaRecebimentoAplicacao;
    }

    public void setDiaRecebimentoAplicacao(LocalDateTime diaRecebimentoAplicacao) {
        this.diaRecebimentoAplicacao = diaRecebimentoAplicacao;
    }

    public Double getJurosAplicacao() {
        return jurosAplicacao;
    }

    public void setJurosAplicacao(Double jurosAplicacao) {
        this.jurosAplicacao = jurosAplicacao;
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

    public Double getValorAplicacao() {
        return valorAplicacao;
    }

    public void setValorAplicacao(Double valorAplicacao) {
        this.valorAplicacao = valorAplicacao;
    }
}
