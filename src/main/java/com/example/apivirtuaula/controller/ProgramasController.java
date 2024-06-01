package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Programas;
import com.example.apivirtuaula.service.ProgramasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProgramasController {

    @Autowired
    private ProgramasService programasService;

    @GetMapping("/programas")
    public List<Programas> getProgramas(){
        return programasService.findAllProgramas();
    }

    @GetMapping("/programas/{id}")
    public Optional<Programas> getProgramaById(@PathVariable String id){
        return programasService.findProgramaById(id);
    }

    @PostMapping("/programas")
    public Programas addPrograma(@RequestBody Programas programa){
        return programasService.savePrograma(programa);
    }

    @DeleteMapping("/programas/{id}")
    public String deletePrograma(@PathVariable String id){
        if(programasService.deletePrograma(id)){
            return "El programa ha sido eliminado correctamente";
        }else {
            return "El programa a eliminar no existe.";
        }
    }

    @PutMapping("/programas")
    public Programas updatePrograma(@RequestBody Programas programa){
        return programasService.updatePrograma(programa);
    }





}
