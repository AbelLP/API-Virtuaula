package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Reservas;
import com.example.apivirtuaula.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @GetMapping("/reservas")
    public List<Reservas> getReservas(){
        return reservasService.findAllReservas();
    }

    @GetMapping("/reservas/{id}")
    public Optional<Reservas> findReservaById(@PathVariable Long id){
        return reservasService.findReservasById(id);
    }

    @GetMapping("/reservas/dni/{dni}")
    public List<Reservas> findReservaByDni(@PathVariable String dni){
        return reservasService.findReservaByDni(dni);
    }

    @GetMapping("/reservas/clase/{nombre}")
    public List<Reservas> findReservasByEquipoClaseNombre(@PathVariable String nombre){
        return reservasService.findReservasByEquipoClaseNombre(nombre);
    }

    @GetMapping("/reservas/hora/{hora}")
    public List<Reservas> findReservasByHora(@PathVariable String hora){
        return reservasService.findReservasByHora(hora);
    }

    @GetMapping("/reservas/noCaducas")
    public List<Reservas> getReservasByNoCaducadas(){
        return reservasService.findReservasByNoCaducadas();
    }

    @GetMapping("/reservas/noCaducas/dni/{dni}")
    public List<Reservas> getReservasByDniAndNoCaducadas(@PathVariable String dni){
        return reservasService.findReservasByDniAndNoCaducadas(dni);
    }

    @GetMapping("/reservas/clase/noCaducas/{nombre}")
    public List<Reservas> getReservasByEquipoClaseNombreAndNoCaducadas(@PathVariable String nombre){
        return reservasService.findReservasByEquipoClaseNombreAndNoCaducadas(nombre);
    }

    @GetMapping("/reservas/noCaducas/hora/{hora}")
    public List<Reservas> getReservasByHoraAndNoCaducadas(@PathVariable String hora){
        return reservasService.findReservasByHoraAndNoCaducada(hora);
    }

    @GetMapping("/reservas/equipo/{codEquipo}")
    public Reservas getReservasByCodEquipo(@PathVariable int codEquipo){
        System.out.println("LLAMADOOOOOOO");
        return reservasService.findReservaByCodEquipo(codEquipo);
    }

    @PostMapping("/reservas")
    public Reservas addReserva(@RequestBody Reservas reserva){
        return reservasService.saveReserva(reserva);
    }

    @DeleteMapping("/reservas/{id}")
    public String deleteReserva(@PathVariable Long id){
        if(reservasService.deleteReserva(id)){
            return "Reserva eliminada";
        }else{
            return "La reserva no existe";
        }
    }

    @PutMapping("/reservas")
    public Reservas updateReserva(@RequestBody Reservas reserva){
        return reservasService.updateReservas(reserva);
    }

}
