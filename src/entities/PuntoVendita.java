package entities;

import javax.persistence.*;

@Entity
public class PuntoVendita {
	@Id
	@SequenceGenerator(name = "puntovendita_seq", sequenceName = "puntovendita_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "puntovendita_seq")
	private Long id;
	private String citta, indirizzo;
	private int bigliettiVenduti;
	private int abbonamentiVenduti;
	
	//Getters and Setters
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
	public int getBigliettiVenduti() {
		return bigliettiVenduti;
	}
	public void setBigliettiVenduti(int bigliettiVenduti) {
		this.bigliettiVenduti = bigliettiVenduti;
	}
	public int getAbbonamentiVenduti() {
		return abbonamentiVenduti;
	}
	public void setAbbonamentiVenduti(int abbonamentiVenduti) {
		this.abbonamentiVenduti = abbonamentiVenduti;
	}

}
