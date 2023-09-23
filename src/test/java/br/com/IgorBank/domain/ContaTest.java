package br.com.IgorBank.domain;

import br.com.IgorBank.enums.AplicacaoCID;
import br.com.IgorBank.enums.TipoBeneficios;
import br.com.IgorBank.exceptions.ErrorFinanciamento;
import br.com.IgorBank.service.ClienteService;
import br.com.IgorBank.service.ContaService;
import br.com.IgorBank.utils.DataUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    static final Endereco enderecoPessoa = new Endereco("","","","","","");
    private final ContaService contaService = new ContaService();
    private final ClienteService clienteService = new ClienteService();

    @Test
    public void deveDepositar70ContaCorrente(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);

        joao.getContaPrincipal().deposito(70D, LocalDateTime.now());
        assertEquals(70D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveDepositar70ContaPoupanca(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0), false);
        joao.adicionarConta(cp);

        joao.getContaPrincipal().deposito(70D, LocalDateTime.now());
        assertEquals(120D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveDepositar70ContaSalario(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false, "Unicesumar");
        joao.adicionarConta(cs);

        joao.getContaPrincipal().deposito(70D, LocalDateTime.now());
        assertEquals(70D, joao.getContaPrincipal().getSaldo());
    }


    @Test
    public void deveSacar40ContaCorrente(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);

        joao.getContaPrincipal().deposito(70D, LocalDateTime.now());
        joao.getContaPrincipal().saque(40D, LocalDateTime.now());
        assertEquals(30D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveSacar50ContaPoupanca(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0), false);
        joao.adicionarConta(cp);

        joao.getContaPrincipal().deposito(70D, LocalDateTime.now());
        joao.getContaPrincipal().saque(50D, LocalDateTime.now());
        assertEquals(67.5D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveSacar60ContaSalario(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false, "Unicesumar");
        joao.adicionarConta(cs);


        joao.getContaPrincipal().deposito(70D, LocalDateTime.now());
        joao.getContaPrincipal().saque(60D, LocalDateTime.now());
        assertEquals(10D, joao.getContaPrincipal().getSaldo());
    }


    @Test
    public void deveFinanciar1000000ContaCorrente() throws ErrorFinanciamento {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);

        ((ContaCorrente) joao.getContaPrincipal())
                .financiar(1000000D, 50L, LocalDateTime.of(2023, 5, 23, 16, 0, 0));
        assertEquals(892000D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveFinanciar100000ContaPoupanca() throws ErrorFinanciamento {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0), false);
        joao.adicionarConta(cp);

        ((ContaPoupanca) joao.getContaPrincipal())
                .financiar(1000000D, 50L, LocalDateTime.of(2023, 5, 23, 16, 0, 0));
        assertEquals(914450D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveAplicar1000000ContaCorrente() {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);

        ((ContaCorrente) joao.getContaPrincipal())
                .aplicacao(1000000D, LocalDateTime.of(2023, 5, 23, 16, 0, 0), AplicacaoCID.TESLA);
        assertEquals(-600000, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveAplicar100000ContaPoupanca() {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0), false);
        joao.adicionarConta(cp);

        ((ContaPoupanca) joao.getContaPrincipal())
                .aplicacao(1000000D, LocalDateTime.of(2023, 5, 23, 16, 0, 0), AplicacaoCID.IGOR_ENTERPRISE);
        assertEquals(7000050D, joao.getContaPrincipal().getSaldo());
    }

    @Test
    public void deveFinanciar1000ContaCorrente() {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);

        try {
            ((ContaCorrente) joao.getContaPrincipal())
                    .financiar(1000D, 50L, LocalDateTime.of(2023, 5, 23, 16, 0, 0));
            assertEquals(892000D, joao.getContaPrincipal().getSaldo());
        }catch (ErrorFinanciamento e){
            assertEquals("Para Conta Corrente - Há um valor mínimo de R$ 60.000,00 como valor de financiamento!",
                    e.getMessage());
        }
    }

    @Test
    public void deveFinanciar1000000ContaCorrente10Meses() {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false);
        joao.adicionarConta(cc);

        try {
            ((ContaCorrente) joao.getContaPrincipal())
                    .financiar(1000000D, 10L, LocalDateTime.of(2023, 5, 23, 16, 0, 0));
            assertEquals(892000D, joao.getContaPrincipal().getSaldo());
        }catch (ErrorFinanciamento e){
            assertEquals("Para Conta Corrente - Há um valor mínimo de 24 parcelas!",
                    e.getMessage());
        }
    }

    @Test
    public void deveFinanciar1000ContaPoupanca5Meses() {
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0), false);
        joao.adicionarConta(cp);

        try {
            ((ContaPoupanca) joao.getContaPrincipal())
                    .financiar(1000D, 5L, LocalDateTime.of(2023, 5, 23, 16, 0, 0));
            assertEquals(914450D, joao.getContaPrincipal().getSaldo());
        } catch (ErrorFinanciamento e) {
            assertEquals("Para Conta Poupança - Há um valor mínimo de 12 parcelas!", e.getMessage());
        }
    }

    @Test
    public void deveAdicionarUmBeneficioNaContaSalario(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.of(2023, 4, 23, 15, 0, 0),false, "Unicesumar");
        cs.adicionarBeneficio(TipoBeneficios.PLANO_SAUDE);
        cs.adicionarBeneficio(TipoBeneficios.VALE_TRANSPORTE);
        joao.adicionarConta(cs);

        assertTrue(!cs.getBeneficios().isEmpty());
    }

}
