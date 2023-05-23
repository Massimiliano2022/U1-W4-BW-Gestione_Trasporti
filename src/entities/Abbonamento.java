package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class Abbonamento extends Ticket {

	private StatoPeriodicita periodicita;
	private LocalDate dataScadenza;

	// Getters & Setters
	public StatoPeriodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(StatoPeriodicita periodicita) {
		this.periodicita = periodicita;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public LocalDate dataScadenza() {
		return dataScadenza;
	}

	// Costruttore
	public Abbonamento() {

	}

	public Abbonamento(UUID id, LocalDate dataEmissione, StatoPeriodicita periodicita) {
		super(id, dataEmissione);
		setPeriodicita(periodicita);
		if (periodicita == StatoPeriodicita.SETTIMANALE) {
			setDataScadenza(dataEmissione.plusDays(7));
		} else {
			setDataScadenza(dataEmissione.plusMonths(1));
		}
	}

	@Override
	public String toString() {
		return "Biglietto [ id=" + getId() + ",dataEmissione=" + getDataEmissione() + ",puntoVendita="
				+ getPuntoVendita() + ",tessera=" + getTessera() + ",periodicita=" + periodicita + "]";
	}

}
