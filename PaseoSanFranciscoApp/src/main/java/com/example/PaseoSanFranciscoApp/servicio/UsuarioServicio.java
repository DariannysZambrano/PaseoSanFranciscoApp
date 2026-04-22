package com.example.PaseoSanFranciscoApp.servicio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.PaseoSanFranciscoApp.models.Usuario;
import com.example.PaseoSanFranciscoApp.repositorio.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    // Inyectando una dependencia al repositorio

    @Autowired
    private IUsuarioRepositorio repositorioUsuario;

    public Usuario guardarUsuarioEnBD(Usuario datos) {
        // validar que datos me envian y si estos umplen las reglas de negocio
        // guardar los datos en bd con ayuda del repositorio

        // condiciones logicas para validar los datos de entrada
        // 1. validar que el correo de registrar no se haya guardado previamente

        if (repositorioUsuario.findByCorreo(datos.getCorreo()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "El correo ya se encuentra registrado");
        }

        if (datos.getNombres().isEmpty() || datos.getNombres().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El nombre del usuario es obligatorio");
        }

        if (datos.getContraseña().length() < 6) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "La contraseña debe tener al menos 6 caracteres");
        }


        // si las validaciones se cumplen, entonces guardamos el usuario en el
        // repositorio, ejecuto la query que se necesita
        return this.repositorioUsuario.save(datos);
    }

    public Usuario modificarUsuarioEnBD(Usuario datos, UUID id) {
        // validar que datos me envian y si estos cumplen las reglas del negocio
        // Modificar los datos en BD con ayuda del repositorio

        // 1. Buscar si el usuario existe en base de datos
        Optional<Usuario> usuario_que_estoy_buscando = this.repositorioUsuario.findById(id);
        if (usuario_que_estoy_buscando.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El usuario que quieres editar no existe en BD");
        }

        Usuario usuario_que_encontre = usuario_que_estoy_buscando.get();

        // 2.Validar la informacion nueva que me manda el cliente
        if (datos.getNombres().isEmpty() || datos.getNombres().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Revisa el nombre ingresado");
        }

        // 3.Ejecutar el nuevo guardado y retornar
        usuario_que_encontre.setNombres(datos.getNombres());
        return this.repositorioUsuario.save(usuario_que_encontre);

    }

    public boolean eliminarUsuarioEnBD(UUID id) {
        // buscar y validar que datos me envian existen
        // eliminar los datos en bd
        Optional<Usuario> usuarioExistente = this.repositorioUsuario.findById(id);
        if (usuarioExistente.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "El usuario con el ID proporcionado no existe en bd");
        }

        this.repositorioUsuario.deleteById(id);
        return true;
    }

    public List<Usuario> buscarUsuariosEnBD() {
        // **** Dependiendo del parametro de busqueda debo implementar validaciones
        // devuelvo los usuarios o suario que encuentre eb BD
        List<Usuario> usuariosEncontrados = this.repositorioUsuario.findAll();
        return usuariosEncontrados;
    }
}
