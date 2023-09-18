package org.example.domain;

import org.example.enums.TipoAcaoBancaria;

import java.time.LocalDateTime;

public class ContaSalario extends Conta{
    @Override
    public Double deposito(Double valor, LocalDateTime diaDeposito, Cliente cliente) {
        super.gerarCalculo(valor, diaDeposito, false, TipoAcaoBancaria.DEPOSITO, cliente);
        return super.getSaldo();
    }

    @Override
    public Double saque(Double valor, LocalDateTime diaSaque, Cliente cliente) {
        super.gerarCalculo(valor, diaSaque,true, TipoAcaoBancaria.SAQUE, cliente);
        return super.getSaldo();
    }
}
