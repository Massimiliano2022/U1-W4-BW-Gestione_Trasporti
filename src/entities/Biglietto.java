package entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Biglietto extends Ticket {

	private boolean timbrato;

	// Costruttore
	public Biglietto() {

	}

	public Biglietto(LocalDate dataEmissione, boolean timbrato) {
		super(dataEmissione);
		this.timbrato = timbrato;
	}

	// Getters & Setters
	public boolean isTimbrato() {
		return timbrato;
	}

	public void setTimbrato(boolean timbrato) {
		this.timbrato = timbrato;
	}

	@Override
	public String toString() {
		return "Biglietto [timbrato=" + timbrato + "]";
	}

}
