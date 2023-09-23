package br.com.IgorBank;

import br.com.IgorBank.domain.Banco;
import br.com.IgorBank.service.ContaService;
import br.com.IgorBank.service.ExtratoService;
import br.com.IgorBank.domain.ContaCorrente;
import br.com.IgorBank.domain.ContaPoupanca;
import br.com.IgorBank.domain.Pessoa;
import br.com.IgorBank.enums.AplicacaoCID;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {

        ExtratoService extratoService = new ExtratoService();
        ContaService contaService = new ContaService();

        Pessoa joao = new Pessoa();
        joao.setNome("Joao");
        Pessoa maria = new Pessoa();
        maria.setNome("maria");

        joao.setVinculo(maria);

        ContaCorrente cc = new ContaCorrente(2L, new Banco(), 0D, false);
        ContaPoupanca pp = new ContaPoupanca(3L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5),true);

        joao.relacionarContaCliente(pp);
//        joao.getContaCP().get(0).financiar(10D,
//                16L, joao, LocalDateTime.now().minusMonths(2));
//        extratoService.visualizarTodoExtrato(joao.getContaCP().get(0));

        System.out.println("----------------------------------------------------\n\n\n\n");

        joao.getContaPrincipal().deposito(5800000D, LocalDateTime.now(), joao);
//        joao.getContaCP().get(0).saque(6800000D, LocalDateTime.now().plusDays(9), joao);
////        maria.getContaCC().get(0).deposito(10000D, LocalDateTime.now(), maria);
//        extratoService.visualizarTodoExtrato(joao.getContaCP().get(0));
//        System.out.println("\n\n----------------------------\n\n");
//        extratoService.visualizarExtratoPorPeriodo(LocalDate.now().plusDays(3),
//                LocalDate.now().plusDays(12), joao.getContaCP().get(0));


        contaService.findContaPoupancaByNumeroConta(maria, 9L).aplicacao(10D,
                LocalDateTime.now().minusMonths(3), AplicacaoCID.IGOR_ENTERPRISE, maria);


        extratoService.visualizarExtratoPorPeriodo(LocalDate.now().minusMonths(10), LocalDate.now().plusMonths(8), joao.getContaCP().get(0));
        System.out.println("----------------------------");
        extratoService.visualizarTodoExtrato(joao.getContaCP().get(0));
    }
}