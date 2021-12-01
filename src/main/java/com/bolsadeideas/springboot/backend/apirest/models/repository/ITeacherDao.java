package com.bolsadeideas.springboot.backend.apirest.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Teacher;

public interface ITeacherDao extends CrudRepository<Teacher, Long> {

}
