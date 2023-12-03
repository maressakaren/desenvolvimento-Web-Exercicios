package com.ifes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifes.demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
}
