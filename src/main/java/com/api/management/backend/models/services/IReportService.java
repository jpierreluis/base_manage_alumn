package com.api.management.backend.models.services;

import org.springframework.http.ResponseEntity;

public interface IReportService {
	public ResponseEntity<byte[]> generatePdf();
}
