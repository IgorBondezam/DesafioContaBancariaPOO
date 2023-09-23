package br.com.IgorBank.exceptions;

public class DiferentTypeVinculo extends Exception{

    public DiferentTypeVinculo(){
        super("Clientes de tipos diferentes não podem ser vinculadas!");
    }
}
