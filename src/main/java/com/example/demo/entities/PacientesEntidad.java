package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
public class PacientesEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "NombreU")
	private String NombreU ;
	@Column(name="NombreD")
	private String NombreD;
	@Column(name = "ApellidoU")
	private String ApellidoU;
	@Column(name = "ApellidoD")
	private String ApellidoD;
	@Column(name = "edad")
	private int edad;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombreU() {
		return NombreU;
	}
	public void setNombreU(String nombreU) {
		NombreU = nombreU;
	}
	public String getNombreD() {
		return NombreD;
	}
	public void setNombreD(String nombreD) {
		NombreD = nombreD;
	}
	public String getApellidoU() {
		return ApellidoU;
	}
	public void setApellidoU(String apellidoU) {
		ApellidoU = apellidoU;
	}
	public String getApellidoD() {
		return ApellidoD;
	}
	public void setApellidoD(String apellidoD) {
		ApellidoD = apellidoD;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
