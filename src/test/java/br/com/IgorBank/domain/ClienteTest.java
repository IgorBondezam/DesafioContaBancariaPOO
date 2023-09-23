package br.com.IgorBank.domain;

import br.com.IgorBank.exceptions.DiferentTypeVinculo;
import br.com.IgorBank.exceptions.ErrorCreateConta;
import br.com.IgorBank.utils.DataUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    Endereco enderecoPessoa = new Endereco("","","","","","");
    Endereco enderecoEmpresa = new Endereco("","","","","","");


    @Test
    public void deveAdicionarUmaContaCorrenteEmPessoa(){

        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaCorrente cc = new ContaCorrente(6558L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false);

        joao.adicionarConta(cc);
        assertEquals(6558L, joao.getContaCC().get(0).getNumeroConta());
    }

    @Test
    public void deveAdicionarUmaContaPoupancaEmPessoa(){

        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5), false);

        joao.adicionarConta(cp);
        assertEquals(7977L, joao.getContaCP().get(0).getNumeroConta());
        assertTrue(joao.getContaCC().isEmpty());
        assertTrue(joao.getContaCS().isEmpty());
    }

    @Test
    public void deveAdicionarUmaContaSalarioEmPessoa(){

        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        ContaSalario cs = new ContaSalario(8236L, new Banco(), 0D,
                LocalDateTime.now().minusMonths(5),false, "Unicesumar");

        joao.adicionarConta(cs);
        assertEquals(8236L, joao.getContaCS().get(0).getNumeroConta());
        assertTrue(joao.getContaCC().isEmpty());
        assertTrue(joao.getContaCP().isEmpty());
    }

    @Test
    public void deveAdicionarUmaContaConjuntaEmPessoa() throws DiferentTypeVinculo, ErrorCreateConta {

        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        Pessoa maria = new Pessoa("Maria Souza Garcia", "688957", "98765432101", 20L,
                DataUtils.fromStringToLocalDate("26/07/2003"), false, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5), true);
        joao.setVinculo(maria);
        joao.criarContaConjunta(cp);
        assertEquals(7977L, maria.getContaCP().get(0).getNumeroConta());
    }

    @Test
    public void deveAdicionarUmaContaConjuntaSemUmVinculoEmPessoa() throws ErrorCreateConta {

        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);

        Pessoa maria = new Pessoa("Maria Souza Garcia", "688957", "98765432101", 20L,
                DataUtils.fromStringToLocalDate("26/07/2003"), false, enderecoPessoa);

        ContaPoupanca cp = new ContaPoupanca(7977L, new Banco(), 50D,
                LocalDateTime.now().minusMonths(5), true);
        assertThrows(ErrorCreateConta.class, () -> joao.criarContaConjunta(cp));
    }

    @Test
    public void deveFalharAoVincularUmaEmpresaAPessoa(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
        Empresa sebrae = new Empresa("Sebrae", "Sebrae123",  "122322265598",
                DataUtils.fromStringToLocalDate("26/07/2000"), "Empreendedorismo", enderecoEmpresa);
        Pessoa maria = new Pessoa("Maria Souza Garcia", "688957", "98765432101", 20L,
                DataUtils.fromStringToLocalDate("26/07/2003"), false, enderecoPessoa);

        assertThrows(DiferentTypeVinculo.class,  () ->joao.setVinculo(sebrae));
        assertDoesNotThrow(() ->joao.setVinculo(maria));
    }

    @Test
    public void deveVincularUmaPessoaAPessoa(){
        Pessoa joao = new Pessoa("João Garcia", "123ab123", "12345678912", 23L,
                DataUtils.fromStringToLocalDate("26/07/2000"), true, enderecoPessoa);
        Pessoa maria = new Pessoa("Maria Souza Garcia", "688957", "98765432101", 20L,
                DataUtils.fromStringToLocalDate("26/07/2003"), false, enderecoPessoa);

        assertDoesNotThrow(() ->joao.setVinculo(maria));
    }
}
