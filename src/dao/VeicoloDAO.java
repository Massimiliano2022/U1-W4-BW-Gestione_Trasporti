package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Application;
import entities.Veicolo;

public class VeicoloDAO {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	private final EntityManager em;

	public VeicoloDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Veicolo v) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(v);
		t.commit();
		logger.info(v.toString() + " salvato!");
	}
}
