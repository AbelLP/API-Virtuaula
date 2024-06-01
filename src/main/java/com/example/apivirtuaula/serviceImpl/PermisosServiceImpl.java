package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Permisos;
import com.example.apivirtuaula.repository.PermisosRepository;
import com.example.apivirtuaula.service.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisosServiceImpl implements PermisosService {

    @Autowired
    private PermisosRepository permisosRepository;

    @Override
    public List<Permisos> findAllPermisos() {
        return permisosRepository.findAll();
    }

    @Override
    public Optional<Permisos> findPermisoById(String id){
        return permisosRepository.findById(id);
    }

    @Override
    public Permisos savePermiso(Permisos permiso){
        if(permiso!=null){
            return permisosRepository.save(permiso);
        }
        return null;
    }

    @Override
    public boolean deletePermiso(String id) {
        Optional <Permisos> permiso=findPermisoById(id);
        if(permiso.isPresent()){
            permisosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Permisos updatePermiso(Permisos permiso){
        if(permisosRepository.findById(permiso.getId_permiso()).isPresent()){
            return permisosRepository.save(permiso);
        }
        return null;
    }
}
