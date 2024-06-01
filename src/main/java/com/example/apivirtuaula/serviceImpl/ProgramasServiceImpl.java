package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Programas;
import com.example.apivirtuaula.repository.ProgramasRepository;
import com.example.apivirtuaula.service.ProgramasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramasServiceImpl implements ProgramasService {

    @Autowired
    private ProgramasRepository programasRepository;

    @Override
    public List<Programas> findAllProgramas() {
        return programasRepository.findAll();
    }

    @Override
    public Optional<Programas> findProgramaById(String id){
        return programasRepository.findById(id);
    }

    @Override
    public Programas savePrograma(Programas programa){
        if(programa!=null){
            return programasRepository.save(programa);
        }
        return null;
    }

    @Override
    public boolean deletePrograma(String id) {
        Optional<Programas> programa=findProgramaById(id);
        if(programa.isPresent()){
            programasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Programas updatePrograma(Programas programa){
        if(programasRepository.findById(programa.getCod_programa()).isPresent()){
            return programasRepository.save(programa);
        }
        return null;
    }


}
