package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Utente {

	@Id
	@SequenceGenerator(name = "utente_seq", sequenceName = "utente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_seq")
	private Long id;
	private String nome;
	private String cognome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tessera_id", referencedColumnName = "id")
	private Tessera tessera;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public Utente() {

	}

	public Utente(String nome, String cognome) {
		setNome(nome);
		setCognome(cognome);
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", tessera=" + tessera + "]";
	}

}
