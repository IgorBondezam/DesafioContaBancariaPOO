package br.com.IgorBank.service;

import br.com.IgorBank.domain.*;
import br.com.IgorBank.service.ClienteService;
import br.com.IgorBank.service.ContaService;
import br.com.IgorBank.utils.DataUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ClienteServiceTest {

    Endereco enderecoPessoa = new Endereco("","","","","","");

    private final ContaService contaService = new ContaService();
    private final ClienteService clienteService = new ClienteService();


    @Test
    public void deveTrocarContaPrincipal(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false);
        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5), false);
        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false, "Unicesumar");
        joao.adicionarConta(cc);
        assertEquals(cc, joao.getContaPrincipal());
        joao.adicionarConta(cp);
        assertEquals(cp, joao.getContaPrincipal());
        joao.adicionarConta(cs);
        assertEquals(cs, joao.getContaPrincipal());
        assertNotEquals(cc, joao.getContaPrincipal());
        clienteService.trocarContaPrincipal(joao, 6558L);
        assertEquals(cc, joao.getContaPrincipal());
    }
}
