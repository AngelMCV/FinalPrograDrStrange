package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.PacientesEntidad;
import com.example.demo.repositories.RepositoryPaciente;

@RestController
@RequestMapping(value = "/Paciente")
public class ControllerDePacientes {

	@Autowired
	RepositoryPaciente repository;

	@GetMapping
	public Collection<PacientesEntidad> getListadoPacientes() {
		Iterable<PacientesEntidad> PacientesList = repository.findAll();
		return (Collection<PacientesEntidad>) PacientesList;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/{id}")
	public PacientesEntidad getPacientes(@PathVariable(name = "id") Long id) {
		Optional<PacientesEntidad> p = repository.findById(id);
		PacientesEntidad result = null;
		if (p.isPresent()) {
			result = p.get();
		}
		return result;
	}

	@PutMapping(value = "/{id}")
	public PacientesEntidad cambiarDatosP(@PathVariable(name = "id") Long id, @RequestBody PacientesEntidad p) {
		Optional<PacientesEntidad> modificar = repository.findById(id);
		if (modificar.isPresent()) {
			PacientesEntidad a = modificar.get();
			a.setId(p.getId());
			a.setEdad(p.getEdad());
			a.setNombreU(p.getNombreU());
			a.setNombreD(p.getNombreD());
			a.setApellidoU(p.getApellidoU());
			a.setApellidoD(p.getApellidoD());
			PacientesEntidad pM = repository.save(a);
			return pM;

		}
		return null;
	}

}
