package com.api.projeto1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public void teste(){
        System.out.println("teste ok");
        System.out.println("teste ok2");
    }
}
