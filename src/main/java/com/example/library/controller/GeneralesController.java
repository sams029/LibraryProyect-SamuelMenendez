package com.example.library.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Libreria;

@RestController
@RequestMapping("generales")
public class GeneralesController {

    private Libreria libreria;

    public GeneralesController(){
        libreria = new Libreria();
        libreria.setNombre("Libreria Central");
        libreria.setDireccion("Cerca del centro");
        libreria.setTelefono("78941234");
        libreria.setHorario("8:30 - 18:00");
    }

    @GetMapping("/")
    public Libreria info(){

        return libreria;
    }

    @GetMapping("/nombre")
    public String nombre(){

        return libreria.getNombre();
    }

    @GetMapping("/direccion")
    public String direccion(){

        return libreria.getDireccion();
    }
    
}
