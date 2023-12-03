package com.ifes.exercicio.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ifes.exercicio.model.Produto;
import com.ifes.exercicio.application.*;


//import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("produtos")

public class ProdutoController {

  @Autowired
  private AppProduto appProduto = new AppProduto();
    
  @GetMapping("/")
  public List<Produto>getAll(){
    return appProduto.getAll();
  }

  @GetMapping("/{id}")
  public Produto getById(@PathVariable long id) throws Exception{
    return appProduto.getById(id);
  }

  @PostMapping("/")
  public Produto createProduto (@RequestBody Produto produto) {
      return appProduto.createProduct(produto);

  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id){
    try {
      appProduto.deleteProduct(id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  @PutMapping ("/")
  public Produto updateProduct(@RequestBody Produto product){
    try {
      return appProduto.updateProduct(product);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
  
}