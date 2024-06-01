package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Clases;
import com.example.apivirtuaula.repository.ClasesRepository;
import com.example.apivirtuaula.service.ClasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasesServiceImpl implements ClasesService {

    @Autowired
    private ClasesRepository clasesRepository;

    @Override
    public List<Clases> findAllClases(){
        return clasesRepository.findAll();
    }

    @Override
    public Optional<Clases> findClasesById(int id){
        return clasesRepository.findById(id);
    }

    @Override
    public Clases saveClase(Clases clase){
        if(clase!=null){
            return clasesRepository.save(clase);
        }
        return null;
    }

    @Override
    public boolean deleteClase(int id){
        Optional<Clases> clase=clasesRepository.findById(id);
        if(clase.isPresent()){
            clasesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Clases updateClase(Clases clase){
        if(clasesRepository.findById(clase.getCodClase()).isPresent()){
            return clasesRepository.save(clase);
        }
        return null;
    }

}
