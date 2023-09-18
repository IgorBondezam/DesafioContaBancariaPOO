package org.example.service;

import org.example.domain.Conta;
import org.example.domain.Extrato;

import java.time.LocalDate;
import java.util.Comparator;

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
