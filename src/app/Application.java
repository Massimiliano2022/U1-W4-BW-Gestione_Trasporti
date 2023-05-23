package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PuntoVenditaDAO;
import dao.TesseraDAO;
import dao.TicketDAO;
import dao.UtenteDAO;
import entities.Abbonamento;
import entities.DistributoreAutomatico;
import entities.StatoPeriodicita;
import entities.Tessera;
import entities.Ticket;
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

		Utente utente1 = new Utente(UUID.randomUUID(), "Mario", "Rossi");
		Abbonamento abbonamentoU1 = new Abbonamento(UUID.randomUUID(), LocalDate.now(), StatoPeriodicita.MENSILE);
		Tessera tesseraU1 = new Tessera(UUID.randomUUID(), LocalDate.now(), LocalDate.now().plusYears(1), utente1);
		DistributoreAutomatico da1 = new DistributoreAutomatico("Milano", "Via Torino", true);

		abbonamentoU1.setPuntoVendita(da1);

		abbonamentoU1.setTessera(tesseraU1);

		List<Ticket> listaTicketU1 = new ArrayList<>();
		listaTicketU1.add(abbonamentoU1);
		tesseraU1.setTicket(listaTicketU1);

		List<Abbonamento> listaAbbonamentiDistributore1 = new ArrayList<>();
		listaAbbonamentiDistributore1.add(abbonamentoU1);

		da1.setListaAbbonamentiVenduti(listaAbbonamentiDistributore1);

		utente1.setTessera(tesseraU1);
		logger.info(utente1.toString());

		ud.save(utente1);
		tkd.save(abbonamentoU1);
		td.save(tesseraU1);
		pvd.save(da1);

		em.close();
		emf.close();
	}

}
