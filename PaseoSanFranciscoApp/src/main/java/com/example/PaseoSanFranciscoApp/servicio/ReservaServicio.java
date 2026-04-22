package com.example.PaseoSanFranciscoApp.servicio;

import java.util.List;
import java.util.Optional;
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

    public Reserva guardarReservaEnBD(Reserva datos){
        
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

        return this.repositorioReserva.save(datos);

    }


     public Reserva modificarReservaEnBD(Reserva datos, UUID id) {
    Optional<Reserva> reserva_que_estoy_buscando=this.repositorioReserva.findById(id.toString());
    if (reserva_que_estoy_buscando.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "La reserva que quieres editar no existe"
      );
    }

    Reserva reserva_que_encontre=reserva_que_estoy_buscando.get();

    if (datos.getFecha_reserva() == null || datos.getFecha_reserva().isBlank()) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST,
        "Revisa la fecha ingresada"
      );
    }  

    reserva_que_encontre.setFecha_reserva(datos.getFecha_reserva());
    return this.repositorioReserva.save(reserva_que_encontre);
      
  }

public boolean eliminarReservaEnBD(UUID id) {

      if (!repositorioReserva.existsById(id.toString())) {
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Reserva no encontrada con ID: " + id
        );
    }

    repositorioReserva.deleteById(id.toString());
    return true;
  }

  public List<Reserva> buscarReservaEnBD() {
    List<Reserva> reservaEncontrada=this.repositorioReserva.findAll();
    return reservaEncontrada;
  }

}
