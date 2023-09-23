package br.com.IgorBank.service;

import br.com.IgorBank.domain.Cliente;
import br.com.IgorBank.exceptions.ErrorFindConta;

public class ClienteService {

    private final ContaService contaService = new ContaService();

    public void trocarContaPrincipal(Cliente cliente, Long numeroConta){
        try{
            cliente.setContaPrincipal(contaService.findContaCorrenteByNumeroConta(cliente, numeroConta));
        } catch (ErrorFindConta e) {
            System.out.println(e.getMessage());
        }
    }
}
