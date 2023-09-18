package org.example.service;

import org.example.domain.*;
import org.example.exceptions.ErrorFindConta;

import java.lang.invoke.ConstantCallSite;
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
}
