package com.ifes.exercicio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ifes.exercicio.application.AppProdutoTxt;
import com.ifes.exercicio.model.Produto;


@RestController
@RequestMapping("/ArquivoProdutos.txt")


public class ProdutoTxtController {

    @Autowired

    AppProdutoTxt appProduto = new AppProdutoTxt();
    
    @GetMapping("/")
    public List<Produto> getAllProducts() throws IOException{
       return appProduto.getAll();

    }

    @PostMapping("/")
    public Produto createProduto (@RequestBody Produto produto) throws IOException {
        return appProduto.createProduct(produto);

    }
    
    @GetMapping("/{id}")
    public Produto getById(@PathVariable int id) throws Exception{
        return appProduto.getById(id);
    }

    @PutMapping("/")
    public Produto updateProduto(@RequestBody Produto upProduto) throws Exception{

        try {
            return appProduto.updateProduct(upProduto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
}
