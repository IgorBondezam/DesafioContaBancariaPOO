package br.com.IgorBank.domain;

import br.com.IgorBank.exceptions.DiferentTypeVinculo;
import br.com.IgorBank.exceptions.ErrorCreateConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private String nome;
    private Cliente vinculo;
    private String senha;
    private Endereco endereco;

    private List<ContaCorrente> contaCC = new ArrayList<>();
    private List<ContaPoupanca> contaCP = new ArrayList<>();
    private List<ContaSalario> contaCS = new ArrayList<>();

    private Conta contaPrincipal;

    public Cliente() {
    }

    public Cliente(String nome, String senha, Endereco endereco) {
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(String nome, String senha, Cliente vinculo, Endereco endereco) {
        this.nome = nome;
        this.senha = senha;
        this.vinculo = vinculo;
        this.endereco = endereco;
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

    public void setVinculo(Cliente vinculo) throws DiferentTypeVinculo {
        if(this.getClass() == vinculo.getClass()){
            this.vinculo = vinculo;
        }
        throw new DiferentTypeVinculo();
    }

    public void relacionarContaCliente(Conta conta) throws ErrorCreateConta {
        adicionarConta(conta);
        adicionarContaConjunta(conta);
    }

    public Conta getContaPrincipal() {
        return contaPrincipal;
    }

    public void setContaPrincipal(Conta contaPrincipal) {
        this.contaPrincipal = contaPrincipal;
    }

    protected void adicionarConta(Conta conta) {
        conta.setCliente(this);
        if (conta instanceof ContaCorrente) {
            this.contaCC.add((ContaCorrente) conta);
        } else if (conta instanceof ContaPoupanca) {
            this.contaCP.add((ContaPoupanca) conta);
        } else if (conta instanceof ContaSalario) {
            this.contaCS.add((ContaSalario) conta);
        }
        contaPrincipal = conta;
    }

    private void adicionarContaConjunta(Conta conta) throws ErrorCreateConta {
        if (conta.isConjunta()) {
            if (Objects.isNull(vinculo)) {
                throw new ErrorCreateConta("Conta do tipo conjunta: não há ninguém vinculado");
            }
            vinculo.adicionarConta(conta);
        }
    }
}
