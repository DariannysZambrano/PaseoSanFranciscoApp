package com.example.PaseoSanFranciscoApp.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaseoSanFranciscoApp.models.Usuario;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, UUID> {

}
