package entities;

import javax.persistence.*;

@Entity
public class DistributoreAutomatico extends PuntoVendita {
	private boolean attivo;
	
	//Constructor
	public DistributoreAutomatico() {}
	public DistributoreAutomatico(boolean attivo) {
		super();
		this.attivo = attivo;
	}
	
	//Getters and Setters
	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	//ToString
	@Override
	public String toString() {
		return "DistributoreAutomatico [attivo=" + attivo + "]";
	}

}
