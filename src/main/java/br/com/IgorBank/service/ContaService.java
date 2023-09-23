package br.com.IgorBank.service;

import br.com.IgorBank.domain.*;
import br.com.IgorBank.exceptions.ErrorFindConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContaService {

    public ContaCorrente findContaCorrenteByNumeroConta(Cliente cliente, Long numeroConta) throws ErrorFindConta {
        return cliente.getContaCC().stream().filter(conta -> Objects.equals(conta.getNumeroConta(), numeroConta))
                .findFirst().orElseThrow(() -> new ErrorFindConta("Conta não existente!"));
    }

    public ContaPoupanca findContaPoupancaByNumeroConta(Cliente cliente, Long numeroConta) throws ErrorFindConta {
        return cliente.getContaCP().stream().filter(conta -> Objects.equals(conta.getNumeroConta(), numeroConta))
                .findFirst().orElseThrow(() -> new ErrorFindConta("Conta não existente!"));
    }

    public ContaSalario findContaSalarioByNumeroConta(Cliente cliente, Long numeroConta) throws ErrorFindConta {
        return cliente.getContaCS().stream().filter(conta -> Objects.equals(conta.getNumeroConta(), numeroConta))
                .findFirst().orElseThrow(() -> new ErrorFindConta("Conta não existente!"));
    }

    public void trocarContaPrincipal(Cliente cliente, Long numeroConta){
        List<Conta> contas = new ArrayList<>();
        contas.addAll(cliente.getContaCC());
        contas.addAll(cliente.getContaCP());
        contas.addAll(cliente.getContaCS());

        try{
            cliente.setContaPrincipal(findContaCorrenteByNumeroConta(cliente, numeroConta));
        } catch (ErrorFindConta e) {
            System.out.println(e.getMessage());
        }
    }
}
