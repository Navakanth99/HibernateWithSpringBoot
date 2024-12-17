package com.hibernate.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.integration.entity.Student;
import com.hibernate.integration.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/insert")
	public String insertData(@RequestBody Student student) {
		
		System.out.println(student);
		return service.insert(student);
	}
	
	@PostMapping("/insertMultiple")
	public String insertMultiple(@RequestBody List<Student> student) {
		
		return service.inserMultiple(student);
	}
	@PutMapping("/updation")
	public String updateData(@RequestBody Student student) {
		return service.updateData(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		return service.deleteData(id);
	}
	
	@GetMapping("allinfo")
	public List<Student> getData(){
		return service.getData();
	}
 
}
