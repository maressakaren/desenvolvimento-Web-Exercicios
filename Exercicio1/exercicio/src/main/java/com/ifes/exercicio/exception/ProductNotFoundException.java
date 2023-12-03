package com.ifes.exercicio.exception;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(){
        super("Produto não encontrado");
    }
    
}
