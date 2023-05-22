package entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public abstract class Ticket {

	@Id
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	private Long id;
	private LocalDate dataEmissione;
	// private PuntoVendita puntoVendita;
	// private Tessera tessera;

	// Getters & Setters
	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	// Costruttore
	public Ticket(LocalDate dataEmissione) {
		this.dataEmissione = LocalDate.now();
	}

}
