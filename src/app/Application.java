package app;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PuntoVenditaDAO;
import dao.TesseraDAO;
import dao.TicketDAO;
import dao.UtenteDAO;
import entities.Tessera;
import entities.Utente;
import util.JpaUtil;

public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();

		UtenteDAO ud = new UtenteDAO(em);
		TesseraDAO td = new TesseraDAO(em);
		TicketDAO tkd = new TicketDAO(em);
		PuntoVenditaDAO pvd = new PuntoVenditaDAO(em);

		Utente utente1 = new Utente("Mario", "Rossi");
		Tessera tesseraU1 = new Tessera(UUID.randomUUID(), LocalDate.now(), LocalDate.now().plusYears(1), utente1);

		utente1.setTessera(tesseraU1);
		logger.info(utente1.toString());

		ud.save(utente1);
		td.save(tesseraU1);

		em.close();
		emf.close();
	}

}
