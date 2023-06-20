package com.api.management.backend.models.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "t_calificaciones")
public class Calificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_t_calificaciones", length = 80)
	@JsonProperty("id_t_calificaciones")
	private int id;
	

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_t_materias")
	@JsonProperty("materia")
	private Materia materia;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","alumno" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_t_usuarios")
	@JsonProperty("alumno")
	private Alumno alumno;
	
	@Column(name = "calificacion")
	@JsonProperty("calificacion")
	private double calificacion;
	
	@Column(name = "fecha_registro")
	@JsonIgnore
	private Date fechaRegistro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	@JsonProperty("fecha_registro")
	public String getFechaRegistroFormateada() {
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("dd/MM/yyyy");
		return formateadorFecha.format(fechaRegistro);
	}
	
	
	
	
	

}
