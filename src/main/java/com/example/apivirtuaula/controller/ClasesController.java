package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Clases;
import com.example.apivirtuaula.service.ClasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClasesController {

    @Autowired
    private ClasesService clasesService;

    @GetMapping("/clases")
    public List<Clases> getAllClases(){
        return clasesService.findAllClases();
    }

    @GetMapping("/clases/{id}")
    public Optional<Clases> getClasesById(@PathVariable int id){
        return clasesService.findClasesById(id);
    }

    @PostMapping("/clases")
    public Clases saveClases(@RequestBody Clases clase){
        return clasesService.saveClase(clase);
    }

    @DeleteMapping("/clases/{id}")
    public String deleteClases(@PathVariable int id){
        if(clasesService.deleteClase(id)){
            return "Clase eliminada";
        }else {
            return "Error";
        }
    }

    @PutMapping("/clases")
    public Clases updateClases(@RequestBody Clases clase){
        return clasesService.updateClase(clase);
    }

}
