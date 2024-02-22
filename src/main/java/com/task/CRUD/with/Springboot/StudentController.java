package com.task.CRUD.with.Springboot;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class StudentController {
	
	@Autowired
	SessionFactory sf;
	
	
	@GetMapping("singleRecord")
	public Student getRecord()
	{
		Session ss = sf.openSession();
		Student s = ss.get(Student.class, 101);
		System.out.println(s);
		return s;
	}
	
	@GetMapping("multipleRecords")
	public List<Student> multipleRecords()
	{
		Session ss = sf.openSession();
		Query query = ss.createQuery("from Student");
		List <Student> li = query.list();
		for(Student s : li)
		{
			System.out.println(s.getId()+" "+s.getName()+" "+s.getNumber()+" "+s.getAddress());
		}
		
		return li;
	}
	
	
	@PostMapping("inserttRecord")
	public Student insertRecord()
	{
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		Student s = new Student(102,"Aniket","987654321","Nagar");
		ss.save(s);
		tx.commit();
		System.out.println("--Student Record Inserted----");
		return s;
		
	}
	
	@PutMapping("updatetRecord")
	public Student updatetRecord()
	{
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		Student s = new Student(102,"Aniket","123456789","Pune");
		ss.update(s);
		tx.commit();
		System.out.println("---Student Record Updated---");
		return s;
		
	}
	
	@DeleteMapping("deleteRecord")
	public Student deleteRecord()
	{
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		Student s = ss.get(Student.class,102 );
		ss.delete(s);
		tx.commit();
		System.out.println("---Student Record Deleted---");
		return s;
		
	}
	
	
	
	

}
