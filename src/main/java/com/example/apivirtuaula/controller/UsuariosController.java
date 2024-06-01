package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Usuarios;
import com.example.apivirtuaula.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.apivirtuaula.configuration.EncoderConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/usuarios")
    public List<Usuarios> getUsuarios(){
        return usuariosService.findAllUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public Optional<Usuarios> getUsuariosById(@PathVariable String id){
        return usuariosService.findUsuarioById(id);
    }

    /*@GetMapping("/usuarios/{nombre}/clave/{clave}")
    public Optional<Usuarios> getUsuarioByNombreAndClave(@PathVariable String nombre, @PathVariable String clave){
        return usuariosService.findUsuarioByNombreAndClave(nombre, clave);
    }*/

    @GetMapping("/usuarios/{dni}/clave/{clave}")
    public Optional<Usuarios> getUsuarioByDniAndClave(@PathVariable String dni, @PathVariable String clave){
        return usuariosService.findUsuarioByDniAndClave(dni, clave);
    }

    @GetMapping("/usuarios/cambioClaveTrue/{dni}")
    public String cambiarClaveATrue(@PathVariable String dni){
        if(usuariosService.ponerCambiarClaveATrue(dni)){
            return "Cambiar clave es ahora true";
        }else{
            return "Error al actualizar";
        }
    }

    @GetMapping("/usuarios/cambiarClave/usuario/{dni}/clave/{clave}")
    public String cambiarClave(@PathVariable String dni, @PathVariable String clave){
        if(usuariosService.cambiarClave(dni, clave)){
            return "Clave cambiada";
        }else{
            return "Error al cambiar la clave";
        }
    }

    @PostMapping("/usuarios")
    public Usuarios addUsuario(@RequestBody Usuarios usuario){
        return usuariosService.saveUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public String deleteUsuario(@PathVariable String id){
        if(usuariosService.deleteUsuario(id)){
            return "El  usuario ha sido eliminado correctamente";
        }else{
            return "El usuario no existe";
        }
    }

    @PutMapping("/usuarios")
    public Usuarios updateUsuario(@RequestBody Usuarios usuario){
        return usuariosService.updateUsuario(usuario);
    }

}
