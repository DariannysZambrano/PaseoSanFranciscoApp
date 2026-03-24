package com.example.PaseoSanFranciscoApp.servicio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaseoSanFranciscoApp.models.Espacio;
import com.example.PaseoSanFranciscoApp.models.Usuario;
import com.example.PaseoSanFranciscoApp.repositorio.IUsuarioRepositorio;


@Service
public class EspacioServicio {

    @Autowired
    private IUsuarioRepositorio repositorioUsuario;

    public boolean guardarEspacioEnBD(Espacio datos){
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
