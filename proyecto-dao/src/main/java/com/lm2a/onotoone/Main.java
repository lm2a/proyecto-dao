package com.lm2a.onotoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.m2();

	}
	
	public void m1() {
		System.out.println("-OneToOne unidireccional-");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPPRY2");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Student s = new Student();
		s.setName("Mario La Menza");
		Tuition t = new Tuition();
		t.setFee(1000L);
		s.setTuition(t);
		em.persist(s);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}
	
	public void m2() {
		System.out.println("-OneToOne unidireccional 2-");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPPRY2");
		
		EntityManager em = factory.createEntityManager();
		

		
		Student s = em.find(Student.class, 1L);
		//s.setName("Mario La Menza");
		Tuition t = s.getTuition();

		System.out.println("Student: "+s);		
		
		System.out.println("Tuition: "+t);	
		em.close();
		factory.close();
		
	}

}
