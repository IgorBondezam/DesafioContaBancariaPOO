package br.com.IgorBank.domain;

import br.com.IgorBank.enums.TipoAcaoBancaria;
import br.com.IgorBank.utils.DataUtils;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Operação realizada: " + tipoAcao.getAcao()
                +(Objects.nonNull(cliente) ? cliente.getNome() : "\nRealizou a operação: Sistema")
                +"\nValor da operação: " + String.format("%.2f", valor)
                +"\nHorário: " + DataUtils.formatterDateTime(horario)
                +"\nSaldo Total: " + String.format("%.2f", valorTotal)
                +"\n\n";
    }
}
