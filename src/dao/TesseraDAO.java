package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Application;
import entities.Tessera;

public class TesseraDAO {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	private final EntityManager em;

	public TesseraDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Tessera tessera) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(tessera);
		t.commit();
		logger.info("Tessera salvato!");
	}
}
