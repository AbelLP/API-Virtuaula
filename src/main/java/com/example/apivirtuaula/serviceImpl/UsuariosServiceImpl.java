package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Usuarios;
import com.example.apivirtuaula.repository.UsuariosRepository;
import com.example.apivirtuaula.service.UsuariosService;
import com.password4j.Hash;
import com.password4j.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> findAllUsuarios(){
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> findUsuarioById(String id){
        return usuariosRepository.findById(id);
    }

    @Override
    public boolean ponerCambiarClaveATrue(String dni) {
        int filas= usuariosRepository.ponerCambiarClaveATrue(dni);
        if(filas>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean cambiarClave(String dni, String clave) {
        String salt="$2a$10$M1uxD/7W/18H7uRwOfGkqu";
        clave=BCrypt.hashpw(clave, salt);
        int filas= usuariosRepository.cambiarClave(dni, clave);
        if(filas>0){
            return true;
        }
        return false;
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuario){
        if(usuario!=null){
            String salt="$2a$10$M1uxD/7W/18H7uRwOfGkqu";
            String clave=BCrypt.hashpw(usuario.clave, salt);
            usuario.clave=clave;
            return usuariosRepository.save(usuario);
        }
        return null;
    }

    @Override
    public boolean deleteUsuario(String id){
        Optional<Usuarios> usuario=usuariosRepository.findById(id);
        if(usuario.isPresent()){
            usuariosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Usuarios updateUsuario(Usuarios usuario){
        if(usuariosRepository.findById(usuario.getDni()).isPresent()){
            return usuariosRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Optional <Usuarios> findUsuarioByNombreAndClave(String nombre, String clave){
        String salt="$2a$10$M1uxD/7W/18H7uRwOfGkqu";
        clave=BCrypt.hashpw(clave, salt);
        return usuariosRepository.findUsuarioByNombreAndClave(nombre, clave);
    }

    @Override
    public Optional <Usuarios> findUsuarioByDniAndClave(String dni, String clave) {
        String salt="$2a$10$M1uxD/7W/18H7uRwOfGkqu";
        clave=BCrypt.hashpw(clave, salt);
        return usuariosRepository.findUsuarioByDniAndClave(dni, clave);
    }
}
