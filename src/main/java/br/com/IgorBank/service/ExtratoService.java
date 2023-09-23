package br.com.IgorBank.service;

import br.com.IgorBank.domain.Conta;
import br.com.IgorBank.domain.Extrato;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ExtratoService {

    public String  visualizarExtratoPorPeriodo(LocalDate dataInicial, LocalDate dataFim, Conta conta){
        conta.gerarSubTotal();
        return conta.getExtratos().stream().filter(extrato -> extrato.getHorario()
                .isBefore(dataFim.atStartOfDay())
                && extrato.getHorario().isAfter(dataInicial.atStartOfDay()))
                        .map(Extrato::toString).collect(Collectors.joining());
    }

    public String visualizarTodoExtrato(Conta conta){
        conta.gerarSubTotal();
        return conta.getExtratos().stream().map(Extrato::toString).collect(Collectors.joining());
    }
}
