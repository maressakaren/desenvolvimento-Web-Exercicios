package com.ifes.exercicio.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ifes.exercicio.exception.ProductNotFoundException;
import com.ifes.exercicio.interfacee.InterfaceProdutoBD;
import com.ifes.exercicio.model.Produto;
import com.ifes.exercicio.repository.ProdutoBDRepository;


@Component
public class AppProdutoBD implements InterfaceProdutoBD{

    private ProdutoBDRepository repoBD;
    private int lastId = 0;
    private List<Produto> produtos = new ArrayList<Produto>();

    public AppProdutoBD(ProdutoBDRepository repo){
        this.repoBD = repo;
    }

    @Override
    public Produto create(Produto product){
        Produto produto = new Produto();
        this.lastId = this.produtos.size() +1 ;
        produto.setId(lastId);
        produto.setNome(product.getNome());
        produto.setPreco(product.getPreco());

        return this.repoBD.save(produto);

    }

    @Override
    public List<Produto> getAll(){ return repoBD.findAll();}

    @Override
    public void delete (Long id){ repoBD.deleteById(id);}


    @Override
    public Produto getById(int id) throws ProductNotFoundException {
        Optional<Produto> product = (repoBD.findById((long) id));
        if(product.isPresent()) return product.get();
        else{ 
            throw new ProductNotFoundException();
        }
    }


    @Override
    public Produto update(Produto product) {
      try {
            Produto produto = this.getById(product.getId());

            produto.setNome(product.getNome());
            produto.setPreco(product.getPreco());
        } catch (ProductNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    
}
