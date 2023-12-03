package com.ifes.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifes.demo.application.UserServico;
import com.ifes.demo.dto.UserDTO;
import com.ifes.demo.model.Usuario;
import com.ifes.demo.repository.UserRepository;


@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired  
    private UserServico servico;


    @PostMapping("/criar")
    private Usuario create(@RequestBody UserDTO dto) {
        return servico.save(dto);
    }

    @GetMapping("/pesquisar/{id}")
    private UserDTO getById(@PathVariable int id)throws Exception{
        return servico.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable int id){
        servico.delete(id);
    }

    @GetMapping("/Listar")
    private List<UserDTO> getAll(){
        return servico.getAll();
    }

    @PostMapping("/Atualizar/{id}")
    private UserDTO update(@PathVariable int id, @RequestBody UserDTO dto){
        return servico.update(dto, id);
    }

    

}
