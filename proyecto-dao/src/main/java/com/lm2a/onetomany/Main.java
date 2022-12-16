package com.lm2a.onetomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.m1();

	}
	
	public void m1() {
		System.out.println("-OneToOne unidireccional-");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPPRY2");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		University university = new University();
		university.setName("ULPGC");
		
		Student s = new Student();
		s.setName("Mario La Menza");
		
		Student s2 = new Student();
		s2.setName("Juan Perez");
		
		ArrayList<Student> sts = new ArrayList<>();
		sts.add(s);
		sts.add(s2);
		
		university.setStudents(sts);
		
		em.persist(university);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}
	


}
