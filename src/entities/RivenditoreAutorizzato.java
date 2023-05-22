package entities;

import javax.persistence.Entity;

@Entity
public class RivenditoreAutorizzato extends PuntoVendita {
	private String nomeAttivita;
	private TipoAttivita tipoAttivita;
	
	//Constructor
	public RivenditoreAutorizzato() {}
	public RivenditoreAutorizzato(String nomeAttivita, TipoAttivita tipoAttivita) {
		super();
		this.nomeAttivita = nomeAttivita;
		this.tipoAttivita = tipoAttivita;
	}
	
	public String getNomeAttivita() {
		return nomeAttivita;
	}
	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}
	public TipoAttivita getTipoAttivita() {
		return tipoAttivita;
	}
	public void setTipoAttivita(TipoAttivita tipoAttivita) {
		this.tipoAttivita = tipoAttivita;
	}
	
	//To String
	@Override
	public String toString() {
		return "RivenditoreAutorizzato [nomeAttivita=" + nomeAttivita + ", tipoAttivita=" + tipoAttivita + "]";
	}
}
