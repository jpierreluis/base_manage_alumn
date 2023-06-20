package com.api.management.backend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "t_materias")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_t_materias", length = 80)
	private int id;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 4, max = 80, message = "Este campo acepta entre 4 y 80 caracteres.")
	@Column(length = 80, name = "nombre")
	private String nombre;

	@JsonIgnore
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "alumno",
			"calificaciones","materia" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "materia", cascade = CascadeType.ALL)
	private List<Calificacion> calificaciones;

	@Column(length = 1, name = "activo")
	private int activo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
}
