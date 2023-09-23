package br.com.IgorBank.service;

import br.com.IgorBank.domain.*;
import br.com.IgorBank.exceptions.ErrorFindConta;
import br.com.IgorBank.utils.DataUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaServiceTest {

    private final ContaService service = new ContaService();

    Endereco enderecoPessoa = new Endereco("","","","","","");
    @Test
    public void deveAcharUmaContaCorrenteEspecificaEmPessoa() throws ErrorFindConta {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                            LocalDateTime.now().minusMonths(5),false);
        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false, "Unicesumar");
        joao.adicionarConta(cc);
        joao.adicionarConta(cs);

        assertEquals(6558L, service.findContaCorrenteByNumeroConta(joao, 6558L).getNumeroConta());
    }

    @Test
    public void deveAcharUmaContaPoupancaEspecificaEmPessoa() throws ErrorFindConta {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
            ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                    LocalDateTime.now().minusMonths(5), false);
        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                            LocalDateTime.now().minusMonths(5),false);
        joao.adicionarConta(cp);
        joao.adicionarConta(cc);

        assertEquals(7977L, service.findContaPoupancaByNumeroConta(joao, 7977L).getNumeroConta());
    }

    @Test
    public void deveAcharUmaContaSalarioEspecificaEmPessoa() throws ErrorFindConta {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false, "Unicesumar");
        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                            LocalDateTime.now().minusMonths(5),false);

        joao.adicionarConta(cs);

        assertEquals(8236L, service.findContaSalarioByNumeroConta(joao, 8236L).getNumeroConta());
    }

    @Test
    public void deveAcharUmaContaEspecificaEmPessoa() throws ErrorFindConta {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false, "Unicesumar");
            ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                    LocalDateTime.now().minusMonths(5), false);
        joao.adicionarConta(cs);
        joao.adicionarConta(cp);

        assertEquals(8236L, service.findConta(joao, 8236L).getNumeroConta());
    }

    @Test
    public void deveAcharNenhumaContaEmPessoa() throws ErrorFindConta {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false, "Unicesumar");
        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5), false);
        joao.adicionarConta(cs);
        joao.adicionarConta(cp);

        assertThrows(ErrorFindConta.class, () -> service.findConta(joao, 9999L));
    }
}
