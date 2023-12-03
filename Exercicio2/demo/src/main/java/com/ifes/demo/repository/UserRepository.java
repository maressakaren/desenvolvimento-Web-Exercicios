package com.ifes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ifes.demo.model.Usuario;


public interface UserRepository extends JpaRepository<Usuario, Integer> {
  
}
