package entities;

import javax.persistence.Entity;

@Entity
public class DistributoreAutomatico extends PuntoVendita {
	private boolean attivo;

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public DistributoreAutomatico() {
	}

	public DistributoreAutomatico(String citta, String indirizzo, boolean attivo) {
		super(citta, indirizzo);
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return "DistributoreAutomatio [ id=" + getId() + ",citta=" + getCitta() + ",indirizzo=" + getIndirizzo()
				+ ",listaBigliettiVenduti=" + getListaBigliettiVenduti() + ",listaAbbonamentiVenduti="
				+ getListaAbbonamentiVenduti() + "attivo=" + attivo + "]";
	}

}
