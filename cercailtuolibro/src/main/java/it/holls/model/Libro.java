package it.holls.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@Entity
@Getter@ToString
public class Libro {

	@Id
	@Column(name = "Libro_id")
	@GeneratedValue
	private Integer id;
	
	@Setter private String titolo;
	@Setter private String titoloOriginale;
	
	@ManyToOne
	@JoinColumn(name="Autore_id")
	@Setter private Autore autore;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Setter private Set<Tag> tags;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="utente_libro", joinColumns=@JoinColumn(name="Libro_id"), inverseJoinColumns=@JoinColumn(name="Utente_id"))
	@Setter private Set<Utente> utentiPref;
	
	@Setter private Integer anno;
	@Setter private String smallTrama;
	@Setter private String trama;
	@Setter private String fonteTrama;
	@Setter private String urlImg;
	@Setter private boolean isValid;
	@Setter private Date inserimentoDB;
	@Setter private Date aggiornamentoDB;
	@Setter private String linkAmazon;
	@Setter private String linkKindle;
	
}
