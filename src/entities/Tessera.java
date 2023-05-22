package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Tessera {

	@Id
	@SequenceGenerator(name = "tessera_seq", sequenceName = "tessera_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tessera_seq")
	private Long id;
	private UUID numeroTessera;
	private LocalDate dataEmissione;
	private LocalDate dataScadenza;
	private Utente utente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(UUID numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Utente getUtente() {
		return utente;
	}

	public Tessera() {

	}

	public Tessera(UUID numeroTessera, LocalDate dataEmissione, LocalDate dataScadenza) {
		setNumeroTessera(numeroTessera);
		setDataEmissione(dataEmissione);
		setDataScadenza(dataScadenza);
	}

	@Override
	public String toString() {
		return "Tessera [id=" + id + ", numeroTessera=" + numeroTessera + ", dataEmissione=" + dataEmissione
				+ ", dataScadenza=" + dataScadenza + ", utente=" + utente + "]";
	}
}
