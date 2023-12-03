package com.ifes.demo.dto;

import org.hibernate.annotations.ManyToAny;

import com.ifes.demo.model.Usuario;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EnderecoDTO {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private int numero;
    private int user;
    
}
