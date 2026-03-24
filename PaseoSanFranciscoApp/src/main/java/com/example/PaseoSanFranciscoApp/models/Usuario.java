package com.example.PaseoSanFranciscoApp.models;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombres;
    private String correo;
    private String documento;
    private String contraseña;
    private String apartamento;
    private String role;


    public Usuario() {
    }


    public Usuario(UUID id, String nombres, String correo, String documento, String contraseña, String apartamento,
            String role) {
        this.id = id;
        this.nombres = nombres;
        this.correo = correo;
        this.documento = documento;
        this.contraseña = contraseña;
        this.apartamento = apartamento;
        this.role = role;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getDocumento() {
        return documento;
    }


    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getContraseña() {
        return contraseña;
    }


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public String getApartamento() {
        return apartamento;
    }


    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    

    
}
