package org.example.domain;

import org.example.exceptions.ErrorCreateConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private String nome;
    private Cliente vinculo;
    private String senha;

    private List<ContaCorrente> contaCC = new ArrayList<>();
    private List<ContaPoupanca> contaCP = new ArrayList<>();
    private List<ContaSalario> contaCS = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Cliente(String nome, String senha, Cliente vinculo) {
        this.nome = nome;
        this.senha = senha;
        this.vinculo = vinculo;
    }

    public List<ContaCorrente> getContaCC() {
        return contaCC;
    }

    public List<ContaPoupanca> getContaCP() {
        return contaCP;
    }

    public List<ContaSalario> getContaCS() {
        return contaCS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getVinculo() {
        return vinculo;
    }

    public void setVinculo(Cliente vinculo) {
        this.vinculo = vinculo;
    }

    public void relacionarContaCliente(Conta conta) throws ErrorCreateConta {
        adicionarConta(conta);
        validarContaConjunta(conta);
    }

    protected void adicionarConta(Conta conta) {
        if (conta instanceof ContaCorrente) {
            this.contaCC.add((ContaCorrente) conta);
        } else if (conta instanceof ContaPoupanca) {
            this.contaCP.add((ContaPoupanca) conta);
        } else if (conta instanceof ContaSalario) {
            this.contaCS.add((ContaSalario) conta);
        }

    }

    private void validarContaConjunta(Conta conta) throws ErrorCreateConta {
        if (conta.isConjunta()) {
            if (Objects.isNull(vinculo)) {
                throw new ErrorCreateConta("Conta do tipo conjunta: não há ninguém vinculado");
            }
            vinculo.adicionarConta(conta);
        }
    }
}
