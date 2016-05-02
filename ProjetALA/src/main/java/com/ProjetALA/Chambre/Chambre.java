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
import javax.validation.constraints.NotNull;

import com.ProjetALA.Reservation.Reservation;

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
	@NotNull
	private Integer capacité;
	@NotNull
	private Double prix;
	@NotNull
	private String description;
	//Association avec Chambre
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="chambre_resa")
	private List<Reservation> listresa = new ArrayList<Reservation>();
	
	//Getter and setters
	public Long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}
	public Integer getCapacité() {
		return capacité;
	}
	public void setCapacité(Integer capacité) {
		this.capacité = capacité;
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
	public List<Reservation> getListresa() {
		return listresa;
	}
	public void setListresa(List<Reservation> listresa) {
		this.listresa = listresa;
	}

	// Constructeurs : avec paramètres et par défaut
	public Chambre(Integer capacité, Double prix, String description) {
		this.capacité = capacité;
		this.prix = prix;
		this.description = description;
	}
	public Chambre() {
	}
}
