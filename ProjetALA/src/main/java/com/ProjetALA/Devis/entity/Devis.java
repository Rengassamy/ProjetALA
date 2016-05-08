package com.ProjetALA.Devis.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ProjetALA.Produit.entity.Produit;
import com.ProjetALA.Reservation.Reservation;

/*
AUTEUR: Mfoulou Lory
NOM DU PROJET: ProjetALA
DATE: 02/05/2016
CLASSE: Produit
VERSION: 1
REF UML:4
SPRINT:
REF_USER STORIES:
ASSOSSIATION: ManytoOne (Produits) unidirectionnel / OnetoOne (Facture) unidirectionnel / OnetoOne (Reservation) unidirectionnel
*/
@Entity
public class Devis implements Serializable {
	// ----------- ATTRIBUTS: -----------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDevis;

	// ----------- ASSOCIATION: -----------
	@OneToMany
	private List<Produit> listProduit;
	@OneToOne
	private Reservation reservation;
	
	//onetoone Facture unidirectionnnel
		
	// ----------- GETTERS/SETTERS: -----------
	public Long getIdDevis() {
		return idDevis;
	}

	public void setIdDevis(Long idDevis) {
		this.idDevis = idDevis;
	}

	public List<Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	// ----------- CONSTRUCTEURS: -----------
	public Devis() {
		super();
	}


	
}
