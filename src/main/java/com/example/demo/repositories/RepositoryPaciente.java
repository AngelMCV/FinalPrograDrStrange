package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.PacientesEntidad;

public interface RepositoryPaciente extends CrudRepository<PacientesEntidad, Long> {

}
