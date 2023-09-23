package br.com.IgorBank.domain.interfaces;

import br.com.IgorBank.domain.Cliente;
import br.com.IgorBank.enums.AplicacaoCID;

import java.time.LocalDateTime;

public interface TransacoesComplexas {

    void financiar(Double valorFinanciado, Long mesesParcelados,
                   Cliente cliente, LocalDateTime diaInicio) throws Exception;

    void aplicacao(Double valorAplicacao, LocalDateTime diaInicio, AplicacaoCID aplicacaoCID, Cliente cliente);


}
