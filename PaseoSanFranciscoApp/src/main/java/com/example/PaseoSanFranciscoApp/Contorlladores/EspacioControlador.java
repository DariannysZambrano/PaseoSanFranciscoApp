package com.example.PaseoSanFranciscoApp.Contorlladores;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PaseoSanFranciscoApp.models.Espacio;
import com.example.PaseoSanFranciscoApp.servicio.EspacioServicio;

@RestController
@RequestMapping("/paseoapi/v1/Espacios")
public class EspacioControlador {

    @Autowired
    EspacioServicio servicio;

    // funcion para controlar el guardado
    @PostMapping
    public ResponseEntity<Espacio> controlarGuardado(@RequestBody Espacio datos) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.servicio.guardarEspacioEnBD(datos));
    }

    // funcion para controlar las modificaciones
    @PutMapping("/{id}")
    public ResponseEntity<Espacio> controlarModificado(@RequestBody Espacio datos, @PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.modificarEspacioEnBD(datos, id));
    }

    // funcion para controlar el borrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controlarBorrado(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.eliminarEspacioEnBD(id));
    }

    // funcion para controlar el listar
    @GetMapping
    public ResponseEntity<?> controlarListado() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.buscarEspacioEnBD());
    }
}
