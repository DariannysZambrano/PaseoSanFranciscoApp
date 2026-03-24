package com.example.PaseoSanFranciscoApp.servicio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaseoSanFranciscoApp.models.Reserva;
import com.example.PaseoSanFranciscoApp.models.Usuario;
import com.example.PaseoSanFranciscoApp.repositorio.IUsuarioRepositorio;

@Service
public class ReservaServicio {

    @Autowired
    private IUsuarioRepositorio repositorioUsuario;

    public boolean guardarReservaEnBD(Reserva datos){
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
