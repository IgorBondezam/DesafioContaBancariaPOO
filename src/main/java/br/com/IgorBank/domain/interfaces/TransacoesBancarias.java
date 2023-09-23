package br.com.IgorBank.domain.interfaces;

import br.com.IgorBank.enums.TipoAcaoBancaria;
import br.com.IgorBank.domain.Cliente;

import java.time.LocalDateTime;

public interface TransacoesBancarias {

    Double deposito(Double valor, LocalDateTime diaDeposito, Cliente cliente);
    Double saque(Double valor, LocalDateTime diaSaque, Cliente cliente);
    void adicionarExtrato(Double valor, LocalDateTime data, TipoAcaoBancaria tipoAcao,
                          Cliente cliente, boolean debitar);

}
