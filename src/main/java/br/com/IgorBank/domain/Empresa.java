package br.com.IgorBank.domain;

import java.time.LocalDate;

public class Empresa extends Cliente{

    private String cnpj;
    private LocalDate dataAtuacao;
    private String areaAtuacao;
    private Endereco endereco;

    public Empresa() {
    }

    public Empresa(String nome, String senha, String cnpj, LocalDate dataAtuacao,
                   String areaAtuacao, Endereco endereco) {
        super(nome, senha, endereco);
        this.cnpj = cnpj;
        this.dataAtuacao = dataAtuacao;
        this.areaAtuacao = areaAtuacao;
        this.endereco = endereco;
    }

    public Empresa(String nome, String senha, Cliente vinculo, String cnpj,
                   LocalDate dataAtuacao, String areaAtuacao, Endereco endereco) {
        super(nome, senha, vinculo, endereco);
        this.cnpj = cnpj;
        this.dataAtuacao = dataAtuacao;
        this.areaAtuacao = areaAtuacao;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataAtuacao() {
        return dataAtuacao;
    }

    public void setDataAtuacao(LocalDate dataAtuacao) {
        this.dataAtuacao = dataAtuacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
