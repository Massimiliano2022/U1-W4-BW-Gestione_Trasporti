package entities;

import java.time.LocalDate;

public class Abbonamento extends Ticket {

	private StatoPeriodicita periodicita;

	// Costruttore
	public Abbonamento(LocalDate dataEmissione, StatoPeriodicita periodicita) {
		super(dataEmissione);
		this.periodicita = periodicita;
	}

	// Getters & Setters
	public StatoPeriodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(StatoPeriodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Abbonamento [periodicita=" + periodicita + "]";
	}

}
