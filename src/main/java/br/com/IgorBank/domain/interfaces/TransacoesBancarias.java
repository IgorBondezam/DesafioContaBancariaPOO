package br.com.IgorBank.domain.interfaces;

import br.com.IgorBank.enums.TipoAcaoBancaria;
import br.com.IgorBank.domain.Cliente;

import java.time.LocalDateTime;

public interface TransacoesBancarias {

    Double deposito(Double valor, LocalDateTime diaDeposito);
    Double saque(Double valor, LocalDateTime diaSaque);
    void adicionarExtrato(Double valor, LocalDateTime data, TipoAcaoBancaria tipoAcao,
                          Cliente cliente, boolean debitar);

}
