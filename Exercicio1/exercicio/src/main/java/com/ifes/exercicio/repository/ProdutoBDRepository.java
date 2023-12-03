package com.ifes.exercicio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ifes.exercicio.model.Produto;

public interface ProdutoBDRepository extends JpaRepository<Produto, Long> {
   
}
