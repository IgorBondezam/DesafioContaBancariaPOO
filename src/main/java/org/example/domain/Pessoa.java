package org.example.domain;

import java.time.LocalDate;
import java.util.List;

public class Pessoa extends Cliente{

    private String cpf;
    private Long idade;
    private LocalDate dataAniversario;
    private boolean sexo;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String senha, String cpf, Long idade,
                  LocalDate dataAniversario, boolean sexo, Endereco endereco) {
        super(nome, senha);
        this.cpf = cpf;
        this.idade = idade;
        this.dataAniversario = dataAniversario;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public Pessoa(String nome, String senha, Cliente vinculo, String cpf,
                  Long idade, LocalDate dataAniversario, boolean sexo, Endereco endereco) {
        super(nome, senha, vinculo);
        this.cpf = cpf;
        this.idade = idade;
        this.dataAniversario = dataAniversario;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public LocalDate getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(LocalDate dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
