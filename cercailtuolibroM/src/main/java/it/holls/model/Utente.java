package it.holls.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter@ToString
public class Utente {

	@Id
	@Column(name = "Utente_id")
	@GeneratedValue
	private Integer id;
	
	@Setter private String username;
	@Setter private String password;
	@Setter private String email;
	@Setter private Ruolo ruolo;
	@Setter private String urlAvatar;
	@Setter private String ip;
	@Setter private Date dataRegistrazione;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="utentiPref")
	@Setter private Set<Libro> libriPreferiti;
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="utentiPref")
	@Setter private Set<Tag> tagPreferiti;
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="utentiPref")
	@Setter private Set<Autore> autoriPreferiti;
	
}
