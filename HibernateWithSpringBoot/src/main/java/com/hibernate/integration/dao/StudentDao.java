package com.hibernate.integration.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.integration.entity.Student;

@Repository
public class StudentDao {
    
	@Autowired
	SessionFactory sf;
	
	public String inserted(Student student) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		
		session.save(student);
		tr.commit();
		session.close();
		
		return "inserted";
	}
	
	public String insertMultiple(List<Student> students) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		
		for(Student student: students) {
			session.save(student);
			
		}
		tr.commit();
		session.close();
		return "inserted";
	}
	public String updateData(Student student) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		
		Student ss = session.get(Student.class, student.getId());
		
		ss.setName(student.getName());
		ss.setMarks(student.getId());
		session.update(ss);
		
		tr.commit();
		session.close();
		return "updated";
	}
	
	public String deleteData(int id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		
		Student ss = session.get(Student.class, id);
		session.delete(ss);
		
		tr.commit();
		session.close();
		return "delted";
	}
	
	public List<Student> getAllData(){
		Session session = sf.openSession();
		List<Student> list = session.createQuery("from Student").list();
		
		return list;
	}

}
