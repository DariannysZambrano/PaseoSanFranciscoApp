package com.example.PaseoSanFranciscoApp.servicio;

import java.util.List;
import java.util.Optional;
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

    public Espacio guardarEspacioEnBD(Espacio datos) {

        if (datos.getNombre_zona().isEmpty() || datos.getNombre_zona().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El nombre de la zona es obligatorio");
        }

        if (datos.getDescripcion().isEmpty() || datos.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La descripción del espacio es obligatoria");
        }

        if (datos.getAforo() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El aforo del espacio debe ser mayor a cero");
        }

        return this.repositorioEspacio.save(datos);
    }

    public Espacio modificarEspacioEnBD(Espacio datos, UUID id) {
        Optional<Espacio> espacio_que_estoy_buscando = this.repositorioEspacio.findById(id);
        if (espacio_que_estoy_buscando.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El espacio que quieres editar no existe");
        }

        Espacio espacio_que_encontre = espacio_que_estoy_buscando.get();

        if (datos.getNombre_zona().isEmpty() || datos.getNombre_zona().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Revisa el nombre ingresado");
        }

        espacio_que_encontre.setNombre_zona(datos.getNombre_zona());
        return this.repositorioEspacio.save(espacio_que_encontre);
    }

    public boolean eliminarEspacioEnBD(UUID id) {
        if (!repositorioEspacio.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Espacio no encontrado con ID: " + id);
        }

        repositorioEspacio.deleteById(id);
        return true;
    }

    public List<Espacio> buscarEspacioEnBD() {
        List<Espacio> espacioEncontrados = this.repositorioEspacio.findAll();
        return espacioEncontrados;
    }

}
