package com.ifes.demo.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifes.demo.dto.EnderecoDTO;
import com.ifes.demo.model.Endereco;
import com.ifes.demo.model.Usuario;
import com.ifes.demo.repository.EnderecoRepository;
import com.ifes.demo.repository.UserRepository;

@Service
public class EnderecoServico {
    
    @Autowired
    private EnderecoRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserServico userServico;
    @Autowired
    private UserRepository userRepo;

    public Endereco save( EnderecoDTO dto){
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        try {
            endereco.setUsuario(modelMapper.map(userServico.getById(dto.getUser()), Usuario.class));
            return repo.save(endereco);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public EnderecoDTO getById(int id) throws Exception{
        Optional<Endereco> op = repo.findById(id);
        if(op.isPresent()){
            return modelMapper.map(op.get(), EnderecoDTO.class);
        }
        throw new Exception("Endereco não encontrado");
    }

    public List<EnderecoDTO> getAll(){

        List<Endereco> listaEnd = new ArrayList<>();
        listaEnd = repo.findAll();
        return listaEnd.stream().map(endereco-> modelMapper.map(endereco, EnderecoDTO.class)).collect(Collectors.toList());

    }

    public Endereco update(EnderecoDTO dto,int id){
        try {
            Optional<Endereco> op = repo.findById(id);
            Optional<Usuario> op2 = userRepo.findById(dto.getUser());
            if(op.isPresent() && op.isPresent()){
                Endereco ender = op.get();
                Usuario user = op2.get();
                ender.setBairro(dto.getBairro());
                ender.setCidade(dto.getCidade());
                ender.setEstado(dto.getEstado());
                ender.setLogradouro(dto.getLogradouro());
                ender.setNumero(dto.getNumero());
                ender.setUsuario(user);
                System.out.println(ender);
                return repo.save(ender);
            } 
        } catch (Exception e) {
           e.getMessage();
        }
        return null;
    }

    public void delete(int id){
        repo.deleteById(id);
    }


}
