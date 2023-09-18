package org.example.domain;

import java.util.List;

public class Pessoa extends Cliente{


    public Pessoa() {
    }

    public Pessoa(String nome, String senha) {
        super(nome, senha);
    }
    public Pessoa(String nome, String senha, Cliente vinculo) {
        super(nome, senha, vinculo);
    }

}
