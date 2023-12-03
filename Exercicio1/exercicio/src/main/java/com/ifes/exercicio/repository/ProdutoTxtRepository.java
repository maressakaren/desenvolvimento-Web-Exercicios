package com.ifes.exercicio.repository;
import com.ifes.exercicio.application.AppProduto;
import com.ifes.exercicio.model.Produto;

import java.io.*;
import java.util.*;

public class ProdutoTxtRepository {
    private String filename;

    public ProdutoTxtRepository(String fileName) throws IOException{
        this.filename = fileName;
        createFile();
    }
    
      public void createFile()throws IOException{
        File file = new File(this.filename);
        if(!file.exists()){
            file.createNewFile();
        }
            
    }

    public List<Produto> readFile()throws IOException{
        FileReader file = new FileReader(this.filename);
        BufferedReader buffer = new BufferedReader(file);
        String line = "";
        List<Produto> listProduct = new ArrayList<Produto>();

        while((line = buffer.readLine())!= null ){
            if(!line.isEmpty()){
                System.out.println(line);
                String[] aux = line.split(",");
                Produto product = new Produto();
                product.setId(Integer.parseInt(aux[0]));
                product.setNome(aux[1]);
                product.setPreco(Double.parseDouble(aux[2]));
            
                listProduct.add(product);
            }
            
        }
        file.close();
        buffer.close();

        return listProduct;

    }

    public void updateProduct(List<Produto> product_list)throws IOException{
        FileWriter file = new FileWriter(this.filename,true);
        PrintWriter buffer = new PrintWriter(file);
        for(Produto product: product_list){
            String line = String.format("%d,%s,%f", product.getId(), product.getNome(), product.getPreco());
            buffer.println(line);
        }
        buffer.flush();
        buffer.close();

    }

    public void createNewProduct(Produto product)throws IOException{
        FileWriter file = new FileWriter(this.filename,true);
        PrintWriter buffer = new PrintWriter(file);
        String line = product.getId() + "," + product.getNome() + "," + product.getPreco();
        buffer.println(line);
        buffer.flush();
        buffer.close();
    }


}