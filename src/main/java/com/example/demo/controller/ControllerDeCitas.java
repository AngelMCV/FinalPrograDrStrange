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

import com.example.demo.entities.CitasEntidad;
import com.example.demo.repositories.CitasRepository;

@RestController
@RequestMapping("/Cita")
public class ControllerDeCitas {

	@Autowired
	CitasRepository repository;

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);

	}

	@PutMapping(value = "/{id}")
	public CitasEntidad cambiarCita(@PathVariable(name = "id") Long id, @RequestBody CitasEntidad c) {
		Optional<CitasEntidad> cM = repository.findById(id);
		if (cM.isPresent()) {
			CitasEntidad Ac = cM.get();
			Ac.setCondition(c.getCondition());
			Ac.setPatient(c.getPatient());
			Ac.setDate(c.getDate());
			Ac.setHour(c.getHour());
			Ac.setObservations(c.getObservations());
			Ac.setId(c.getId());
			CitasEntidad citaN = repository.save(Ac);
			return citaN;

		}
		return null;
	}

	@GetMapping
	public Collection<CitasEntidad> getListadoCitas() {
		Iterable<CitasEntidad> ListCitas = repository.findAll();
		return (Collection<CitasEntidad>) ListCitas;
	}

	@GetMapping(value = "/{id}")
	public CitasEntidad getCitas(@PathVariable(name = "id") Long id) {
		Optional<CitasEntidad> c = repository.findById(id);
		CitasEntidad busqueda = null;
		if (c.isPresent()) {
			busqueda = c.get();

		}
		return busqueda;

	}
}
