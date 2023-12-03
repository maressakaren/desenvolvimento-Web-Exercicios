package com.ifes.exercicio.repository;

import java.io.IOException;
import java.util.List;

import com.ifes.exercicio.model.Produto;

public interface GenericRepoTxt<T> {
    List<Produto> getAll()throws IOException;
    Produto getById(int id) throws Exception;
    Produto createProduct(Produto produto)throws IOException;
    void deleteProduct(long id) throws Exception;
    Produto updateProduct(Produto newProduct) throws Exception;


    
}
