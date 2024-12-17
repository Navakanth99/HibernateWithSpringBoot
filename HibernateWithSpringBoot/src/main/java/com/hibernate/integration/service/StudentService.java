package com.hibernate.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.integration.dao.StudentDao;
import com.hibernate.integration.entity.Student;

@Service
public class StudentService {
    
	@Autowired
	StudentDao dao;
	
	public String insert(Student student) {
		
		return dao.inserted(student);
	}
	
	public String inserMultiple(List<Student> student) {
		
		return dao.insertMultiple(student);
	}
	
	public String updateData(Student student) {
		return dao.updateData(student);
	}
	
	public String deleteData(int id) {
		return dao.deleteData(id);
	}
	
	public List<Student> getData(){
		
		return dao.getAllData();
	}
}
