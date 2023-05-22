package entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Ticket {

	@Id
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	private Long id;
	private LocalDate dataEmissione;
	@ManyToOne
	@JoinColumn(name = "puntoVendita_id", referencedColumnName = "id", nullable = false)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private PuntoVendita puntoVendita;
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	@OrderBy(value = "tessera.numeroTessera")
	private List<Tessera> listaTessere;

	// Getters & Setters
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public PuntoVendita getPuntoVendita() {
		return puntoVendita;
	}

	public void setPuntoVendita(PuntoVendita puntoVendita) {
		this.puntoVendita = puntoVendita;
	}

	public void setTessera(List<Tessera> listaTessere) {
		this.listaTessere = listaTessere;
	}

	public List<Tessera> getTessera() {
		return listaTessere;
	}

	// Costruttore
	public Ticket() {

	}

	public Ticket(LocalDate dataEmissione) {
		this.dataEmissione = LocalDate.now();
	}

}
