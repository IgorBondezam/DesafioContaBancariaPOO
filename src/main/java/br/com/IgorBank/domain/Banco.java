package br.com.IgorBank.domain;

public class Banco {

    private String nome;
    private Endereco endereco;
    private String agencia;

    public Banco() {
    }

    public Banco(String nome, Endereco endereco, String agencia) {
        this.nome = nome;
        this.endereco = endereco;
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
