package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Teacher;
import com.bolsadeideas.springboot.backend.apirest.models.repository.ITeacherDao;

@Service
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private ITeacherDao teacherDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Teacher> findAll() {
		return (List<Teacher>) teacherDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Teacher findById(Long id) {
		// TODO Auto-generated method stub
		return teacherDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Teacher Save(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.save(teacher);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		teacherDao.deleteById(id);
	}
}
