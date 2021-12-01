package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Teacher;
import com.bolsadeideas.springboot.backend.apirest.models.services.ITeacherService;

@CrossOrigin(origins = {"localhost:4200"})
@RestController
@RequestMapping("/api")
public class TeacherRestController {

	@Autowired
	private ITeacherService teacherService;
	
	@GetMapping("/teacher")
	public List<Teacher> index() {
		return teacherService.findAll();
	}
	

	@GetMapping("/teacher/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Teacher teacher = null;
		Map<String, Object> response = new HashMap<>();
		
		try {			
			teacher = teacherService.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta en la base ded atos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if (teacher == null) {
			response.put("Mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}
}
