package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public int selectNumeroViaggi(UUID idVeicolo, int idTratta) {
		TypedQuery<Veicolo> query = em.createNamedQuery("selectNumeroViaggi", Veicolo.class);
		query.setParameter("idVeicolo", idVeicolo);
		query.setParameter("idTratta", idTratta);
		return query.getResultList().size();
	}

	public List<Veicolo> selectVeicoli() {
		TypedQuery<Veicolo> query = em.createNamedQuery("selectVeicoli", Veicolo.class);
		return query.getResultList();
	}

}
