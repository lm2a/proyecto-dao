package com.lm2a.onetomanybi;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.m2();

	}
	
	public void m1() {
		System.out.println("-OneToMany bidireccional-");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPPRY2");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		University university = new University();
		university.setName("ULPGC");
		
		Student s = new Student();
		s.setName("Mario La Menza");
		s.setUniversity(university);
		
		Student s2 = new Student();
		s2.setName("Juan Perez");
		s2.setUniversity(university);
		
		ArrayList<Student> sts = new ArrayList<>();
		sts.add(s);
		sts.add(s2);
		
		university.setStudents(sts);
		
		em.persist(university);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}
	
	
	public void m2() {
		System.out.println("-OneToMany bidireccional-");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPPRY2");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Student s = em.find(Student.class, 1L);
		System.out.println(s.getUniversity().toString());
		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}


}
