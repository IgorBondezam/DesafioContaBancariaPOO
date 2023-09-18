package org.example.domain.interfaces;

import org.example.domain.Cliente;
import org.example.domain.Extrato;
import org.example.enums.TipoAcaoBancaria;

import java.time.LocalDateTime;

public interface TransacoesBancarias {

    Double deposito(Double valor, LocalDateTime diaDeposito, Cliente cliente);
    Double saque(Double valor, LocalDateTime diaSaque, Cliente cliente);
    void adicionarExtrato(Double valor, LocalDateTime data, TipoAcaoBancaria tipoAcao,
                          Cliente cliente, boolean debitar);

}
