package com.ifes.exercicio.application;
import java.util.ArrayList;
import java.util.List;

import com.ifes.exercicio.exception.ProductNotFoundException;

import com.ifes.exercicio.model.Produto;

import org.springframework.stereotype.Component;

@Component
public  class AppProduto{

    private List<Produto> produtos = new ArrayList<Produto>();
    
    private int lastId = 0;
    public AppProduto(){
      
    }
    public List<Produto> getAll(){
      return this.produtos;
    }

    public Produto getById(long id)throws Exception{
      for(Produto product: this.produtos){
        if(product.getId() == id){return product;}
      }
      throw new ProductNotFoundException();

    }

    public Produto createProduct(Produto produto){
      lastId++;
      produto.setId(lastId);
      produtos.add(produto);
      return produto;
    }

    public void deleteProduct (long id)throws Exception {
      this.produtos.removeIf(produto -> produto.getId() == id);
    }
    public Produto updateProduct(Produto newProduto) throws Exception{
        Produto product = getById(newProduto.getId());
        if(product.getId() == newProduto.getId()){
          product.setNome(newProduto.getNome());
          product.setPreco(newProduto.getPreco());
          return product;
        }
      throw new ProductNotFoundException();
    }
  }
