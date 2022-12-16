package com.lm2a.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		m1();

	}
	
	public static void m1() {
		System.out.println("-OneToOne unidireccional-");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPPRY2");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Course course1 = new Course();
		course1.setName("JPA-ORM");
		course1.setFee(100.00);
		
		Course course2 = new Course();
		course2.setName("Patrones de software");
		course2.setFee(200.00);
		
		Course course3 = new Course();
		course3.setName("HTML5");
		course3.setFee(110.00);
		
		Student s1 = new Student();
		s1.setName("Ana");
		
		Set<Course> courses1 = new HashSet<>();
		courses1.add(course2);
		courses1.add(course1);	
		s1.setCourses(courses1);
		
		Student s2 = new Student();
		s2.setName("Carlos");
		
		Set<Course> courses2 = new HashSet<>();
		courses2.add(course3);
		courses2.add(course2);
		courses2.add(course1);
		s2.setCourses(courses2);
		
		em.persist(s1);
		em.persist(s2);
		
		em.getTransaction().commit();
		factory.close();

	}

}
