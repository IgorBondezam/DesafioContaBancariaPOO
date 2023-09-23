package br.com.IgorBank.service;

import br.com.IgorBank.domain.*;
import br.com.IgorBank.enums.AplicacaoCID;
import br.com.IgorBank.exceptions.ErrorFinanciamento;
import br.com.IgorBank.utils.DataUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtratoServiceTest {

    private final ExtratoService extratoService = new ExtratoService();

    static final Endereco enderecoPessoa = new Endereco("","","","","","");

    @Test
    public void gerarExtratosDeTodosOsLancamentos() throws ErrorFinanciamento {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        String result = "Operação realizada: Criação de conta\n" +
                "Realizou a operação: Sistema\n" +
                "Valor da operação: 0,00\n" +
                "Horário: 23/04/2023 - 15:00:00\n" +
                "Saldo Total: 0,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: 120000,00\n" +
                "Horário: 23/04/2023 - 15:00:00\n" +
                "Saldo Total: 120000,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: -2000,00\n" +
                "Horário: 23/04/2023 - 15:00:00\n" +
                "Saldo Total: 118000,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -4800,00\n" +
                "Horário: 23/05/2023 - 15:00:00\n" +
                "Saldo Total: 113200,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/05/2023 - 15:00:00\n" +
                "Saldo Total: 113320,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -5200,00\n" +
                "Horário: 23/06/2023 - 15:00:00\n" +
                "Saldo Total: 108120,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/06/2023 - 15:00:00\n" +
                "Saldo Total: 108240,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -5600,00\n" +
                "Horário: 23/07/2023 - 15:00:00\n" +
                "Saldo Total: 102640,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/07/2023 - 15:00:00\n" +
                "Saldo Total: 102760,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -6000,00\n" +
                "Horário: 23/08/2023 - 15:00:00\n" +
                "Saldo Total: 96760,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/08/2023 - 15:00:00\n" +
                "Saldo Total: 96880,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -6400,00\n" +
                "Horário: 23/09/2023 - 15:00:00\n" +
                "Saldo Total: 90480,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/09/2023 - 15:00:00\n" +
                "Saldo Total: 90600,00\n" +
                "\n" +
                "Operação realizada: DepositoJoão Garcia\n" +
                "Valor da operação: 5000,00\n" +
                "Horário: 23/09/2023 - 16:29:59\n" +
                "Saldo Total: 95600,00\n" +
                "\n" +
                "Operação realizada: SaqueJoão Garcia\n" +
                "Valor da operação: -1000,00\n" +
                "Horário: 23/09/2023 - 16:29:59\n" +
                "Saldo Total: 94600,00\n" +
                "\n" +
                "Operação realizada: DepositoJoão Garcia\n" +
                "Valor da operação: 3000,00\n" +
                "Horário: 23/09/2023 - 16:29:59\n" +
                "Saldo Total: 97600,00\n\n";

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);
        joao.getContaPrincipal().deposito(5000D, LocalDateTime.of(2023, 9, 23, 16, 29, 59));
        joao.getContaPrincipal().saque(1000D, LocalDateTime.of(2023, 9, 23, 16, 29, 59));
        ((ContaCorrente)joao.getContaPrincipal()).financiar(120000D,
                30L, LocalDateTime.of(2023, 4, 23, 15, 0, 0));
        joao.getContaPrincipal().deposito(3000D, LocalDateTime.of(2023, 9, 23, 16, 29, 59));
        ((ContaCorrente) joao.getContaPrincipal()).aplicacao(2000D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),
                AplicacaoCID.PETROBRAS);
        System.out.println(extratoService.visualizarTodoExtrato(joao.getContaPrincipal()));
        assertEquals(result, extratoService.visualizarTodoExtrato(joao.getContaPrincipal()));
    }

    @Test
    public void gerarExtratosDeTodosOsLancamentosPorPeriodo() throws ErrorFinanciamento {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        String result = "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -5600,00\n" +
                "Horário: 23/07/2023 - 15:00:00\n" +
                "Saldo Total: 102640,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/07/2023 - 15:00:00\n" +
                "Saldo Total: 102760,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -6000,00\n" +
                "Horário: 23/08/2023 - 15:00:00\n" +
                "Saldo Total: 96760,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/08/2023 - 15:00:00\n" +
                "Saldo Total: 96880,00\n" +
                "\n" +
                "Operação realizada: FinanciamentoJoão Garcia\n" +
                "Valor da operação: -6400,00\n" +
                "Horário: 23/09/2023 - 15:00:00\n" +
                "Saldo Total: 90480,00\n" +
                "\n" +
                "Operação realizada: AplicaçãoJoão Garcia\n" +
                "Valor da operação: 120,00\n" +
                "Horário: 23/09/2023 - 15:00:00\n" +
                "Saldo Total: 90600,00\n" +
                "\n" +
                "Operação realizada: DepositoJoão Garcia\n" +
                "Valor da operação: 5000,00\n" +
                "Horário: 23/09/2023 - 16:29:59\n" +
                "Saldo Total: 95600,00\n" +
                "\n" +
                "Operação realizada: SaqueJoão Garcia\n" +
                "Valor da operação: -1000,00\n" +
                "Horário: 23/09/2023 - 16:29:59\n" +
                "Saldo Total: 94600,00\n" +
                "\n" +
                "Operação realizada: DepositoJoão Garcia\n" +
                "Valor da operação: 3000,00\n" +
                "Horário: 23/09/2023 - 16:29:59\n" +
                "Saldo Total: 97600,00\n\n";

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);
        joao.getContaPrincipal().deposito(5000D, LocalDateTime.of(2023, 9, 23, 16, 29, 59));
        joao.getContaPrincipal().saque(1000D, LocalDateTime.of(2023, 9, 23, 16, 29, 59));
        ((ContaCorrente)joao.getContaPrincipal()).financiar(120000D,
                30L, LocalDateTime.of(2023, 4, 23, 15, 0, 0));
        joao.getContaPrincipal().deposito(3000D, LocalDateTime.of(2023, 9, 23, 16, 29, 59));
        ((ContaCorrente) joao.getContaPrincipal()).aplicacao(2000D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),
                AplicacaoCID.PETROBRAS);
        System.out.println(extratoService.visualizarExtratoPorPeriodo(
                LocalDate.of(2023, 6, 24),
                LocalDate.of(2023, 10, 24),
                joao.getContaPrincipal()));
        assertEquals(result,extratoService.visualizarExtratoPorPeriodo(
                                LocalDate.of(2023, 6, 24),
                                LocalDate.of(2023, 10, 24),
                                joao.getContaPrincipal()));
    }

}
