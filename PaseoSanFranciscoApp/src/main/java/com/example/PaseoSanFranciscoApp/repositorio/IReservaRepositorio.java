package com.example.PaseoSanFranciscoApp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PaseoSanFranciscoApp.models.Reserva;

@Repository
public interface IReservaRepositorio extends JpaRepository<Reserva, String> {

}
