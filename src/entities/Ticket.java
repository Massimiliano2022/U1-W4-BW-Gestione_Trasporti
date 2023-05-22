package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public abstract class Ticket {

	@Id
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	private Long id;
	private LocalDate dataEmissione;
	private PuntoVendita puntoVendita;
	private Tessera tessera;

	// Getters & Setters
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public PuntoVendita getPuntoVendita() {
		return puntoVendita;
	}

	public void setPuntoVendita(PuntoVendita puntoVendita) {
		this.puntoVendita = puntoVendita;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Tessera getTessera() {
		return tessera;
	}

	// Costruttore
	public Ticket() {

	}

	public Ticket(LocalDate dataEmissione) {
		this.dataEmissione = LocalDate.now();
	}

}
