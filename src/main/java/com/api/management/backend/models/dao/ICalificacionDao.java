package com.api.management.backend.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.management.backend.models.entity.Calificacion;


public interface ICalificacionDao extends JpaRepository<Calificacion, Integer>{
	
	@Query(value = "select c from Calificacion c where "
			+ "materia.id=:idmateria "
			+ "and alumno.id=:idalumno")
	public Calificacion getCalificacionByMateriaAndAlumn(
			@Param("idalumno")Integer idAlumno,
			@Param("idmateria")Integer idMatteria);
}
