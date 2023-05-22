package entities;

import java.util.Date;

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
	private Long numeroTessera;
	private Date dataEmissione;
	private Date dataScadenza;
	private Utente utente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(Long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Tessera(Long numeroTessera, Date dataEmissione, Date dataScadenza) {
		super();
		this.numeroTessera = numeroTessera;
		this.dataEmissione = dataEmissione;
		this.dataScadenza = dataScadenza;
	}

	@Override
	public String toString() {
		return "Tessera [id=" + id + ", numeroTessera=" + numeroTessera + ", dataEmissione=" + dataEmissione
				+ ", dataScadenza=" + dataScadenza + "]";
	}

}
