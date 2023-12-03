package com.ifes.exercicio.interfacee;

import java.util.List;

import com.ifes.exercicio.model.Produto;

public interface InterfaceProdutoTxt {

    List<Produto> getAll();
    Produto getById(int id);
    Produto createProduct(Produto produto);
    Produto updateProduct(Produto produto);
    void deleteProduct(int id);
    
}
