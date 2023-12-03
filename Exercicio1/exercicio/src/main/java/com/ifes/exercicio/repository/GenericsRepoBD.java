package com.ifes.exercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericsRepoBD<T,ID> extends JpaRepository<T, ID> {
}
