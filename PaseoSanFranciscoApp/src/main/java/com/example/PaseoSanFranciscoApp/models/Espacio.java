package com.example.PaseoSanFranciscoApp.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "espacios")

public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    private UUID id;
    private String nombre_zona;
    private int aforo;
    private String descripcion;
    private String foto;

    public Espacio() {
    }

    public Espacio(UUID id, String nombre_zona, int aforo, String descripcion, String foto) {
        this.id = id;
        this.nombre_zona = nombre_zona;
        this.aforo = aforo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
