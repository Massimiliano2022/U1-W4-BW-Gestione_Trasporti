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
import entities.Biglietto;
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

		// *********** CREO ENTITA' ***********
		Utente utente1 = new Utente(UUID.randomUUID(), "Mario", "Rossi");
		Abbonamento abbonamentoU1 = new Abbonamento(UUID.randomUUID(), LocalDate.now(), StatoPeriodicita.MENSILE);
		Tessera tesseraU1 = new Tessera(UUID.randomUUID(), LocalDate.now(), LocalDate.now().plusYears(1), utente1);
		DistributoreAutomatico da1 = new DistributoreAutomatico("Milano", "Via Torino", true);

		Utente utente2 = new Utente(UUID.randomUUID(), "Giovanni", "Storti");
		Biglietto bigliettoU2 = new Biglietto(UUID.randomUUID(), LocalDate.now(), false);
		Tessera tesseraU2 = new Tessera(UUID.randomUUID(), LocalDate.now(), LocalDate.now().plusYears(1), utente2);

		Utente utente3 = new Utente(UUID.randomUUID(), "Roberto", "Baggio");
		Biglietto bigliettoU3 = new Biglietto(UUID.randomUUID(), LocalDate.now(), true);
		Tessera tesseraU3 = new Tessera(UUID.randomUUID(), LocalDate.now(), LocalDate.now().plusYears(1), utente3);

		// *********** SETTO GLI ATTRIBUTI ***********
		abbonamentoU1.setPuntoVendita(da1);
		bigliettoU2.setPuntoVendita(da1);
		bigliettoU3.setPuntoVendita(da1);

		abbonamentoU1.setTessera(tesseraU1);
		bigliettoU2.setTessera(tesseraU2);
		bigliettoU3.setTessera(tesseraU3);

		List<Ticket> listaTicketU1 = new ArrayList<>();
		listaTicketU1.add(abbonamentoU1);
		tesseraU1.setTicket(listaTicketU1);

		List<Ticket> listaTicketU2 = new ArrayList<>();
		listaTicketU2.add(bigliettoU2);
		tesseraU2.setTicket(listaTicketU2);

		List<Ticket> listaTicketU3 = new ArrayList<>();
		listaTicketU3.add(bigliettoU3);
		tesseraU3.setTicket(listaTicketU3);

		List<Abbonamento> listaAbbonamentiDistributore1 = new ArrayList<>();
		listaAbbonamentiDistributore1.add(abbonamentoU1);

		List<Biglietto> listaBigliettiDistributore1 = new ArrayList<>();
		listaBigliettiDistributore1.add(bigliettoU2);
		listaBigliettiDistributore1.add(bigliettoU3);

		da1.setListaAbbonamentiVenduti(listaAbbonamentiDistributore1);
		da1.setListaBigliettiVenduti(listaBigliettiDistributore1);

		utente1.setTessera(tesseraU1);
		utente2.setTessera(tesseraU2);
		utente3.setTessera(tesseraU3);
		logger.info(utente1.toString());
		logger.info(utente2.toString());
		logger.info(utente3.toString());

		// *********** SALVO SUL DATABASE ***********
		pvd.save(da1);
		tkd.save(abbonamentoU1);
		tkd.save(bigliettoU2);
		tkd.save(bigliettoU3);
		td.save(tesseraU1);
		td.save(tesseraU2);
		td.save(tesseraU3);
		ud.save(utente1);
		ud.save(utente2);
		ud.save(utente3);

		em.close();
		emf.close();
	}

}
