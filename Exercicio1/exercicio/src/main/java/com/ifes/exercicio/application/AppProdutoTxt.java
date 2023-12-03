package com.ifes.exercicio.application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.ifes.exercicio.exception.ProductNotFoundException;
import com.ifes.exercicio.model.Produto;
import com.ifes.exercicio.repository.ProdutoTxtRepository;
import org.springframework.stereotype.Component;

@Component
public  class AppProdutoTxt{

    private List<Produto> produtos = new ArrayList<Produto>();
    private ProdutoTxtRepository fileRepository;
    private int lastId = 0;

    public AppProdutoTxt(){
      try {
        fileRepository = new ProdutoTxtRepository("produtos.txt");
        
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
      
    }

    public List<Produto> getAll()throws IOException{
      this.produtos = fileRepository.readFile();
      return this.produtos;

    }

    public Produto getById(int id) throws Exception{
      this.produtos = fileRepository.readFile();
      if(this.produtos.size()>00){for(Produto product: this.produtos){if(id == product.getId()){return product;}}}
      throw new ProductNotFoundException();
    }

    public Produto createProduct(Produto produto)throws IOException{
      lastId = this.produtos.size()+1;
      produto.setId(lastId);
      produtos.add(produto);
      this.fileRepository.createNewProduct(produto);
      return produto;
    }

  public void deleteProduct(long id) throws Exception{
      this.produtos = fileRepository.readFile();
      this.produtos.removeIf(produto -> produto.getId() == id);
    }


    public Produto updateProduct(Produto newProduct) throws Exception{

      Produto product = getById(newProduct.getId());
        if(product.getId() == newProduct.getId()){
          product.setNome(newProduct.getNome());
          product.setPreco(newProduct.getPreco());
          this.fileRepository.updateProduct(this.produtos);
          return product;
        }     
        throw new ProductNotFoundException();
    }

}
