package com.example.PaseoSanFranciscoApp.servicio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaseoSanFranciscoApp.models.Usuario;
import com.example.PaseoSanFranciscoApp.repositorio.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    //Inyectando una dependencia al repositorio 

    @Autowired
    private IUsuarioRepositorio repositorioUsuario;

    public boolean guardarUsuarioEnBD(Usuario datos){
        //validar que datos me envian y si estos umplen las reglas de negocio
        // guardar los datos en bd con ayuda del repositorio
        return false;
    }

    public boolean modificarUsuarioEnBD(Usuario datos, UUID id){
         //validar que datos me envian y si estos umplen las reglas de negocio
        // modificar los datos en bd 
        return false;
    }

    public boolean eliminarUsuarioEnBD(UUID id){
         //buscar y validar que datos me envian existen
        // eliminar los datos en bd 
        return false;
    }

    public boolean buscarUsuarioEnBD(){
            //**** dependiendo del parametro de busqueda, debo emplear varias validaciones  */
            // devolver los usuarios que encuentro en la bd
            return false;
    }
}
