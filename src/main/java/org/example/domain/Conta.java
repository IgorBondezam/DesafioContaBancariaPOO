package org.example.domain;

import org.example.domain.interfaces.TransacoesBancarias;
import org.example.enums.TipoAcaoBancaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Conta implements TransacoesBancarias {

    private Long numeroConta;
    private Banco banco;
    private Double saldo = 0D;
    private List<Extrato> extratos = new ArrayList<>();
    private List<Financiamento> financiamentos = new ArrayList<>();
    private List<Aplicacao> aplicacaos = new ArrayList<>();
    private boolean conjunta = false;

    public Conta() {
    }

    public Conta(Long numeroConta, Banco banco, Double saldo,
                 TipoAcaoBancaria tipoAcao, boolean conjunta) {
        this.numeroConta = numeroConta;
        this.banco = banco;
        this.conjunta = conjunta;
        gerarCalculo(saldo, LocalDateTime.now(), false, tipoAcao, null);
    }

    public Conta(Long numeroConta, Banco banco, Double saldo, TipoAcaoBancaria tipoAcao,
                 LocalDateTime dataCriacao, boolean conjunta) {
        this.numeroConta = numeroConta;
        this.banco = banco;
        this.conjunta = conjunta;
        gerarCalculo(saldo, dataCriacao, false, tipoAcao, null);
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public List<Extrato> getExtratos() {
        return extratos;
    }

    public List<Financiamento> getFinanciamentos() {
        return financiamentos;
    }

    public List<Aplicacao> getAplicacaos() {
        return aplicacaos;
    }

    public boolean isConjunta() {
        return conjunta;
    }

    @Override
    public void adicionarExtrato(Double valor, LocalDateTime data,
                                 TipoAcaoBancaria tipoAcao, Cliente cliente, boolean debitar) {
        Extrato extrato = new Extrato(valor, cliente, data, tipoAcao, debitar);
        this.extratos.add(extrato);
    }

    public void gerarCalculo(Double saldo, LocalDateTime data, boolean debitar,
                             TipoAcaoBancaria tipoAcao, Cliente cliente) {
        adicionarExtrato(saldo, data, tipoAcao, cliente, debitar);
        this.extratos.sort(Comparator.comparing(Extrato::getHorario));
        this.saldo = this.extratos.stream().mapToDouble(Extrato::getValor).sum();

    }

    public void gerarSubTotal(){
        Double subTotal = 0D;
        for (Extrato extrato : this.extratos) {
            subTotal += extrato.getValor();
            extrato.setValorTotal(subTotal);
        }
    }
}
