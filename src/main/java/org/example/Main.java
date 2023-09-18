package org.example;

import org.example.domain.*;
import org.example.enums.AplicacaoCID;
import org.example.enums.TipoAcaoBancaria;
import org.example.exceptions.ErrorCreateConta;
import org.example.exceptions.ErrorFinanciamento;
import org.example.service.ExtratoService;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {

        ExtratoService extratoService = new ExtratoService();

        Pessoa maria = new Pessoa("Maria", "855");
        Pessoa joao = new Pessoa("Joao", "1234");
        joao.setVinculo(maria);

        ContaCorrente cc = new ContaCorrente(2L, new Banco(), 0D, false);
        ContaPoupanca pp = new ContaPoupanca(3L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5),false);

        cc.setTeste(1000000L);

        joao.relacionarContaCliente(pp);

//        joao.getContaCP().get(0).deposito(5800000D, LocalDateTime.now(), joao);
//        joao.getContaCP().get(0).saque(6800000D, LocalDateTime.now().plusDays(9), joao);
////        maria.getContaCC().get(0).deposito(10000D, LocalDateTime.now(), maria);
//        extratoService.visualizarTodoExtrato(joao.getContaCP().get(0));
//        System.out.println("\n\n----------------------------\n\n");
//        extratoService.visualizarExtratoPorPeriodo(LocalDate.now().plusDays(3),
//                LocalDate.now().plusDays(12), joao.getContaCP().get(0));

        joao.getContaCP().get(0).financiar(10D,
                16L, joao, LocalDateTime.now().minusMonths(2));
        joao.getContaCP().get(0).aplicacao(10D,
                LocalDateTime.now().minusMonths(3), AplicacaoCID.IGOR_ENTERPRISE, joao);


        extratoService.visualizarExtratoPorPeriodo(LocalDate.now().minusMonths(10), LocalDate.now().plusMonths(8), joao.getContaCP().get(0));
        System.out.println("----------------------------");
        extratoService.visualizarTodoExtrato(joao.getContaCP().get(0));
    }
}