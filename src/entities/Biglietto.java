package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Biglietto extends Ticket {

	private boolean timbrato;
	@OneToMany(mappedBy = "puntoVendita", cascade = CascadeType.ALL)
	@OrderBy(value = "puntoVendita.id")
	private List<PuntoVendita> listaPuntoVendita;

	// Getters & Setters

	public boolean isTimbrato() {
		return timbrato;
	}

	public List<PuntoVendita> getListaPuntoVendita() {
		return listaPuntoVendita;
	}

	public void setListaPuntoVendita(List<PuntoVendita> listaPuntoVendita) {
		this.listaPuntoVendita = listaPuntoVendita;
	}

	public void setTimbrato(boolean timbrato) {
		this.timbrato = timbrato;
	}

	// Costruttore
	public Biglietto() {

	}

	public Biglietto(LocalDate dataEmissione, boolean timbrato) {
		super(dataEmissione);
		setTimbrato(timbrato);
	}

	@Override
	public String toString() {
		return "Biglietto [ id=" + getId() + ",dataEmissione=" + getDataEmissione() + ",puntoVendita="
				+ getPuntoVendita() + ",tessera=" + getTessera() + ",timbrato=" + timbrato + "]";
	}

}
