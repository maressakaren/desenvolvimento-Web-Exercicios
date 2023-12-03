package com.ifes.exercicio.interfacee;

import java.util.List;

import com.ifes.exercicio.exception.ProductNotFoundException;
import com.ifes.exercicio.model.Produto;
import com.ifes.exercicio.repository.ProdutoBDRepository;

public interface InterfaceProdutoBD {

    List<Produto> getAll();
    Produto getById(int id)throws ProductNotFoundException;
    Produto create(Produto produto);
    Produto update(Produto produto);
    void delete(Long id);
    
}
