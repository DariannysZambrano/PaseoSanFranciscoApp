package com.example.PaseoSanFranciscoApp.servicio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoSanFranciscoApp.models.Espacio;
import com.example.PaseoSanFranciscoApp.repositorio.IEspacioRepositorio;


@Service
public class EspacioServicio {

    @Autowired
    private IEspacioRepositorio repositorioEspacio;

    public boolean guardarEspacioEnBD(Espacio datos){

        if (datos.getNombre_zona().isEmpty() || datos.getNombre_zona().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El nombre de la zona es obligatorio"
            ); 
        }

        if (datos.getDescripcion().isEmpty() || datos.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "La descripción del espacio es obligatoria"
            );
        }

        if (datos.getAforo() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "El aforo del espacio debe ser mayor a cero"
            ); 
        }

        this.repositorioEspacio.save(datos);
        return false;
    }

    public boolean modificarEspacioEnBD(Espacio datos, UUID id){
        return false;
    }

    public boolean eliminarEspacioEnBD(UUID id){
        return false;
    }

    public boolean buscarEspacioEnBD(){
        return false;
    }

}
