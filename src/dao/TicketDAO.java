package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Application;
import entities.Ticket;

public class TicketDAO {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	private final EntityManager em;

	public TicketDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Ticket ticket) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(ticket);
		t.commit();
		logger.info(ticket.toString() + " salvato!");
	}

	public int selectAllTickets(LocalDate dataInizio, LocalDate dataFine, Long id) {
		TypedQuery<Ticket> query = em.createNamedQuery("selectAllTickets", Ticket.class);
		query.setParameter("dataInizio", dataInizio);
		query.setParameter("dataFine", dataFine);
		query.setParameter("idPuntoVendita", id);
		return query.getResultList().size();
	}
}
