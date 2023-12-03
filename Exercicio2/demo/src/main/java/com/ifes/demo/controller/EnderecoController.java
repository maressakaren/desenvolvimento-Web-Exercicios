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

import com.ifes.demo.application.EnderecoServico;
import com.ifes.demo.application.UserServico;
import com.ifes.demo.dto.EnderecoDTO;
import com.ifes.demo.dto.UserDTO;
import com.ifes.demo.model.Endereco;
import com.ifes.demo.model.Usuario;

@RestController
@RequestMapping("/Enderecos")
public class EnderecoController {

    @Autowired  
    private EnderecoServico servico;


    @PostMapping("/criar")
    private Endereco create(@RequestBody EnderecoDTO dto) {
        return servico.save(dto);
    }

    @GetMapping("/pesquisar")
    private EnderecoDTO getById(@PathVariable int id)throws Exception{
        return servico.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable int id){
        servico.delete(id);
    }

    @GetMapping("/Listar")
    private List<EnderecoDTO> getAll(){
        return servico.getAll();
    }

    @PostMapping("/Atualizar/{id}")
    private Endereco update(@PathVariable int id, @RequestBody EnderecoDTO dto){
        return servico.update(dto, id);
    }

    
}
