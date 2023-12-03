package com.ifes.demo.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class UserDTO {

    private String nome;
    private LocalDate dataNasc;

}
