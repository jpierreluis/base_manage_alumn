package com.api.management.backend.models.services.imp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.management.backend.models.dao.IAlumnoDao;
import com.api.management.backend.models.entity.Alumno;
import com.api.management.backend.models.entity.Calificacion;
import com.api.management.backend.models.entity.vo.ListGrade;
import com.api.management.backend.models.entity.vo.Promedio;
import com.api.management.backend.models.services.IReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ReportServiceImpl implements IReportService {

	@Autowired
	private IAlumnoDao alumnoDao;

	
	@Override
	public ResponseEntity<byte[]> generatePdf() {
		List<ListGrade> calificaciones = new ArrayList<ListGrade>();
		byte data[] = null;
		List<Alumno> list = alumnoDao.findAll();
		for (Alumno alumno : list) {
			for (Calificacion item : alumno.getCalificaciones()) {
				ListGrade calificacion = new ListGrade();
				calificacion.setId(alumno.getId());
				calificacion.setName(alumno.getNombre());
				calificacion.setLastname(alumno.getApPaterno() + " " + alumno.getApPaterno());
				calificacion.setMatter(item.getMateria().getNombre());
				calificacion.setGrade(item.getCalificacion());
				calificacion.setIdCalificacion(item.getId());
				calificacion.setRegistrationDate(item.getFechaRegistroFormateada());
				calificaciones.add(calificacion);
			}
		}
		HttpHeaders headers = new HttpHeaders();
		try {
			JasperPrint jasp = generateJasper("src/main/resources/reports/report1.jrxml", "calificaciones.pdf", calificaciones);
			data = JasperExportManager.exportReportToPdf(jasp);
			headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=calificaciones.pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(JRException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	
	
	private JasperPrint generateJasper(String pathLayout,String nameFile,List<?> list) throws FileNotFoundException, JRException {
		Map<String, Object> parameters = new HashMap<>();
		JasperReport compileReport = JasperCompileManager	
				.compileReport(new FileInputStream("src/main/resources/reports/report1.jrxml"));
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
		return JasperFillManager.fillReport(compileReport, parameters,beanCollectionDataSource);
	}
	
}