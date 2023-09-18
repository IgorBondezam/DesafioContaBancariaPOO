package org.example.domain;

import org.example.enums.TipoAcaoBancaria;
import org.example.utils.DataUtils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Extrato {

    private Double valor;
    private Cliente cliente;
    private LocalDateTime horario;
    private TipoAcaoBancaria tipoAcao;
    private Double valorTotal = 0D;
    private boolean debitar;

    public Extrato(Double valor, Cliente cliente, LocalDateTime horario,
                   TipoAcaoBancaria tipoAcao, boolean debitar) {
        this.cliente = cliente;
        this.horario = horario;
        this.tipoAcao = tipoAcao;
        this.debitar = debitar;
        this.valor = debitar ? valor*-1 : valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public TipoAcaoBancaria getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(TipoAcaoBancaria tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isDebitar() {
        return debitar;
    }

    public void setDebitar(boolean debitar) {
        this.debitar = debitar;
    }

    @Override
    public String toString() {
        return "Operação realizada: " + tipoAcao.getAcao()
                +"\nRealizou a operação: " + (Objects.nonNull(cliente) ? cliente.getNome() : "Sistema")
                +"\nValor da operação: " + String.format("%.2f", valor)
                +"\nHorário: " + DataUtils.formatterDateTime(horario)
                +"\nSaldo Total: " + String.format("%.2f", valorTotal)
                +"\n\n";
    }
}
