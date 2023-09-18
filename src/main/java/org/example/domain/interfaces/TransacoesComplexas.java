package org.example.domain.interfaces;

import org.example.domain.Cliente;
import org.example.enums.AplicacaoCID;
import org.example.exceptions.ErrorFinanciamento;

import java.time.LocalDateTime;

public interface TransacoesComplexas {

    void financiar(Double valorFinanciado, Long mesesParcelados,
                   Cliente cliente, LocalDateTime diaInicio) throws Exception;

    void aplicacao(Double valorAplicacao, LocalDateTime diaInicio, AplicacaoCID aplicacaoCID, Cliente cliente);


}
