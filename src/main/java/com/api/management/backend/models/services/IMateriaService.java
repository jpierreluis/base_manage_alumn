package com.api.management.backend.models.services;

import org.springframework.http.ResponseEntity;

import com.api.management.backend.models.entity.Materia;

public interface IMateriaService {
	
	public ResponseEntity<?> getAll();
	
	public ResponseEntity<?> save(Materia materia);

	public ResponseEntity<?> delete(int id);

	public ResponseEntity<?> getById(int id);
}
