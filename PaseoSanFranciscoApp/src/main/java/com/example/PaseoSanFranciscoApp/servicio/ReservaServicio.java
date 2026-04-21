package com.example.PaseoSanFranciscoApp.servicio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoSanFranciscoApp.models.Reserva;
import com.example.PaseoSanFranciscoApp.repositorio.IReservaRepositorio;

@Service
public class ReservaServicio {

    @Autowired
    private IReservaRepositorio repositorioReserva;

    public boolean guardarReservaEnBD(Reserva datos){
        
        if (datos.getFecha_reserva().isEmpty() || datos.getFecha_reserva().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "La fecha de reserva es obligatoria"
            ); 
        }

        if (datos.getTiempo() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El tiempo de reserva debe ser mayor a cero"
            ); 
        }

        this.repositorioReserva.save(datos);

        return false;
    }

    public boolean modificarReservaEnBD(Reserva datos, UUID id){
        return false;
    }

    public boolean eliminarReservaEnBD(UUID id){
        return false;
    }

    public boolean buscarReservaEnBD(){
        return false;
    }

}
