package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Teacher;

public interface ITeacherService {

	
	public List<Teacher> findAll();
	
	public Teacher findById(Long id);
	
	public Teacher Save(Teacher teacher);
	
	public void delete(Long id);
}
