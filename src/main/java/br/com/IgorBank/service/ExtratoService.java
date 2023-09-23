package br.com.IgorBank.service;

import br.com.IgorBank.domain.Conta;

import java.time.LocalDate;

public class ExtratoService {

    public void visualizarExtratoPorPeriodo(LocalDate dataInicial, LocalDate dataFim, Conta conta){
        conta.gerarSubTotal();
        conta.getExtratos().stream().filter(extrato -> extrato.getHorario()
                .isBefore(dataFim.atStartOfDay())
                && extrato.getHorario().isAfter(dataInicial.atStartOfDay())).forEach(System.out::println);
    }

    public void visualizarTodoExtrato(Conta conta){
        conta.gerarSubTotal();
        conta.getExtratos().forEach(System.out::println);
    }
}
