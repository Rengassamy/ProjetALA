package com.ProjetALA.Chambre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ProjetALA.Reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 02/05/2016
 *Package: com.ProjetALA.Chambre
 *Class: Chambre
 *version:1.0
 *ref-UML: 8
 *sprint:1
 *ref-userStories: 1
 *association: ManytoMany avec Chambre
 * 
 * */
@Entity
public class Chambre implements Serializable{
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idChambre;
	@NotBlank
	private String numchambre;
	@NotNull(message="La capacité doit être indiquée")
	private Integer capacite;
	@NotNull
	private Double prix;
	@NotBlank
	private String description;
	//Association avec Chambre
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="chambre_resa")
	private List<Reservation> listresa = new ArrayList<Reservation>();
	//Pour les exceptions
	@Transient
	private String exception;
	
	//Getter and setters
	public Long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}
	public String getNumchambre() {
		return numchambre;
	}
	public void setNumchambre(String numchambre) {
		this.numchambre = numchambre;
	}
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public List<Reservation> getListresa() {
		return listresa;
	}
	@JsonSetter
	public void setListresa(List<Reservation> listresa) {
		this.listresa = listresa;
	}

	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	// Constructeurs : avec paramètres et par défaut
	public Chambre(String numchambre, Integer capacite, Double prix,
			String description) {
		this.numchambre = numchambre;
		this.capacite = capacite;
		this.prix = prix;
		this.description = description;
	}

	public Chambre() {
	}
}
