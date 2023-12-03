package com.ifes.exercicio.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")

public class HelloWorldController {
  
  @GetMapping("/")
  public String helloWord(){
    return "Agora vai? foi";
  }

  @GetMapping("/xyz")
  public String helloWord2(@RequestParam String nome){
    return "Preneme netre: " + nome;
  }
  
}