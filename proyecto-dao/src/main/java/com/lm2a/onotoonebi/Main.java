package com.lm2a.onotoonebi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Main {

	public static final String PERSISTENCE_UNIT_NAME = "UPPRY2";
	static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		m4();


		factory.close();
	}

	public static void m1() {
		EntityManager em = factory.createEntityManager();

		try {
			em.getTransaction().begin();
			
			Student s = new Student();
			s.setName("Mario La Menza");
			Tuition t = new Tuition();
			t.setFee(1000L);
			s.setTuition(t);
			t.setStudent(s);
			em.persist(s);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			em.getTransaction().rollback();
		}

		em.close();
	}

	public void m2() {
		EntityManager em = factory.createEntityManager();

		try {
			em.getTransaction().begin();
			Student s2 = new Student();
			s2.setName("Juan Hesse");
			Tuition t2 = new Tuition();
			t2.setFee(1000L);
			s2.setTuition(t2);
			em.persist(s2);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			em.getTransaction().rollback();
		}

		em.close();
	}

	public void m3() {
		EntityManager em = factory.createEntityManager();

		try {
			em.getTransaction().begin();

			Tuition t3 = em.find(Tuition.class, 2L);
			p("Recuperado: " + t3.toString());

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			em.getTransaction().rollback();
		}

		em.close();
	}
	
	public static void m4() {
		EntityManager em = factory.createEntityManager();

		Student s = em.find(Student.class, 1L);
	    Tuition t = s.getTuition();
			
	    p(s.toString());
	    p(t.toString());



		em.close();
	}
	

	public static void p(String s) {
		System.out.println(s);
	}

}
