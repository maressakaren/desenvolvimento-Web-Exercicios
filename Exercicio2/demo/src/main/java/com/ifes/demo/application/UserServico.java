package com.ifes.demo.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifes.demo.dto.UserDTO;
import com.ifes.demo.model.Endereco;
import com.ifes.demo.model.Usuario;
import com.ifes.demo.repository.EnderecoRepository;
import com.ifes.demo.repository.UserRepository;

import jakarta.jws.soap.SOAPBinding.Use;



@Service
public class UserServico {
    @Autowired
    private  UserRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EnderecoRepository endRepo;


    
    public Usuario save(UserDTO dto){
        Usuario user = modelMapper.map(dto, Usuario.class);
        return repo.save(user);
    }
    
    public UserDTO getById(int id) throws Exception {

        Optional<Usuario> userOptional = repo.findById(id);

        if (userOptional.isPresent()) {
            Usuario user = userOptional.get();
            return modelMapper.map(user, UserDTO.class);
        } 
        throw new Exception("Usuario Não encontrado");
    }
   
    public List<UserDTO> getAll(){
        List<Usuario> lista = new ArrayList<>();
        lista = repo.findAll();
        return lista.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public UserDTO update(UserDTO dto, int id){

        try {
            Optional<Usuario> op = repo.findById(id);
            if(op.isPresent()){
                Usuario user = op.get();
                user.setDataNasc(dto.getDataNasc());
                user.setNome(dto.getNome());
                return modelMapper.map(repo.save(user), UserDTO.class);
            } 
        } catch (Exception e) {
           e.getMessage();
        }
        return null;
    }

    public void delete(int id){
        List<Endereco> lista = endRepo.findAll();
        Optional<Usuario> op = repo.findById(id);
        if(op.isPresent()){
            for(Endereco end: lista){
                if(end.getUsuario()!= null &&end.getUsuario().equals(op.get())){
                    endRepo.delete(end);
                }
            }
            repo.delete(op.get());
        }
        
    }
    
}
