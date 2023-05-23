package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Veicolo {

	// Attributi
	@Id
	@GeneratedValue
	private UUID id;
	private TipoVeicolo tipoVeicolo;
	private int capienza;
	private boolean statoServizio;
	private LocalDate dataInizioServizio;
	private LocalDate dataFineServizio;

	// Getters & Setters
	public TipoVeicolo getTipoVeicolo() {
		return tipoVeicolo;
	}

	public void setTipoVeicolo(TipoVeicolo tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public boolean isStatoServizio() {
		return statoServizio;
	}

	public void setStatoServizio(boolean statoServizio) {
		this.statoServizio = statoServizio;
	}

	public LocalDate getDataInizioServizio() {
		return dataInizioServizio;
	}

	public void setDataInizioServizio(LocalDate dataInizioServizio) {
		this.dataInizioServizio = dataInizioServizio;
	}

	public LocalDate getDataFineServizio() {
		return dataFineServizio;
	}

	public void setDataFineServizio(LocalDate dataFineServizio) {
		this.dataFineServizio = dataFineServizio;
	}

	// Costruttore
	public Veicolo() {

	}

	public Veicolo(TipoVeicolo tipoVeicolo, boolean statoServizio) {
		setTipoVeicolo(tipoVeicolo);
		//		if (tipoVeicolo.toString().equals("TRAM")) {
		//			setCapienza(25);
		//		} else {
		//			setCapienza(50);
		//		}
		setCapienza(tipoVeicolo.toString().equals("TRAM") ? 25 : 50);
		setStatoServizio(statoServizio);
		if (statoServizio) {
			setDataInizioServizio(LocalDate.now());
		} else {
			setDataInizioServizio(null);
		}

	}

}
