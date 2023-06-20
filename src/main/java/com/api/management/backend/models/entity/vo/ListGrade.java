package com.api.management.backend.models.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListGrade {
	@JsonProperty("id_t_usuario")
	private int id;
	@JsonProperty("nombre")
	private String name;
	@JsonProperty("apellido")
	private String lastname;
	@JsonProperty("materia")
	private String matter;
	@JsonProperty("id_t_calificaciones")
	private int idcalificacion;
	@JsonProperty("calificacion")
	private double grade;
	@JsonProperty("fecha_registro")	
	private String registrationDate;
	
	public ListGrade() {
		
	}
	
	public ListGrade(String name, String lastname, String matter, double grade) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.matter = matter;
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public void setIdCalificacion(int idcalificacion) {
		this.idcalificacion = idcalificacion;
	}
	public int getIdCalificacion() {
		return this.idcalificacion;
	}
	
}
