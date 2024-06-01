package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Administrador;
import com.example.apivirtuaula.repository.AdministradorRepository;
import com.example.apivirtuaula.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> findAllAdministradores(){
        return administradorRepository.findAll();
    }

    @Override
    public Optional<Administrador> findAdministradorById(String id){
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador saveAdministrador(Administrador administrador){
        if(administrador!=null){
            return administradorRepository.save(administrador);
        }
        return null;
    }

    @Override
    public boolean deleteAdministrador(String id){
        Optional<Administrador> administrador=findAdministradorById(id);
        if(administrador.isPresent()){
            administradorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Administrador updateAdministrador(Administrador administrador){
        if(administradorRepository.findById(administrador.getCod_administrador()).isPresent()){
            return administradorRepository.save(administrador);
        }
        return null;
    }


}
