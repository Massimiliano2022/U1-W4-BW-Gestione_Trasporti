package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public abstract class PuntoVendita {
	@Id
	@SequenceGenerator(name = "puntovendita_seq", sequenceName = "puntovendita_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "puntovendita_seq")
	private Long id;
	private String citta;
	private String indirizzo;
	private List<Biglietto> listaBigliettiVenduti;
	private List<Abbonamento> listaAbbonamentiVenduti;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Biglietto> getListaBigliettiVenduti() {
		return listaBigliettiVenduti;
	}

	public void setListaBigliettiVenduti(List<Biglietto> listaBigliettiVenduti) {
		this.listaBigliettiVenduti = listaBigliettiVenduti;
	}

	public List<Abbonamento> getListaAbbonamentiVenduti() {
		return listaAbbonamentiVenduti;
	}

	public void setListaAbbonamentiVenduti(List<Abbonamento> listaAbbonamentiVenduti) {
		this.listaAbbonamentiVenduti = listaAbbonamentiVenduti;
	}

	public PuntoVendita() {

	}

	public PuntoVendita(String citta, String indirizzo) {
		setCitta(citta);
		setIndirizzo(indirizzo);
	}

}
