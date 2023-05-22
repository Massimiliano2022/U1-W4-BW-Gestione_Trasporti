package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Application;
import entities.PuntoVendita;

public class PuntoVenditaDAO {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	private final EntityManager em;

	public PuntoVenditaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(PuntoVendita pv) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(pv);
		t.commit();
		logger.info("Punto vendita salvato!");
	}
}
