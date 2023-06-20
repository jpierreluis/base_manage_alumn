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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "t_alumnos")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_t_usuarios", length = 80)
	@JsonProperty("id_t_usuarios")
	private int id;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 4, max = 80, message = "Este campo acepta entre 4 y 80 caracteres.")
	@Column(length = 80, name = "nombre")
	@JsonProperty("nombre")
	private String nombre;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 4, max = 80, message = "Este campo acepta entre 4 y 80 caracteres.")
	@Column(length = 80, name = "ap_paterno")
	@JsonProperty("ap_paterno")
	private String apPaterno;

	@NotEmpty(message = "No puede estar vacio")
	@Size(min = 4, max = 80, message = "Este campo acepta entre 4 y 80 caracteres.")
	@Column(length = 80, name = "ap_materno")
	@JsonProperty("ap_materno")
	private String apMaterno;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "alumno",
			"calificaciones" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alumno", cascade = CascadeType.ALL)
	@JsonProperty("calificaciones")
	private List<Calificacion> calificaciones;

	@Column(length = 1, name = "activo")
	@JsonProperty("activo")
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

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
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
