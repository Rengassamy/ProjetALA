package com.ProjetALA.Facture.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ProjetALA.Devis.entity.Devis;

/*
AUTEUR: Mfoulou Lory
NOM DU PROJET: ProjetALA
DATE: 02/05/2016
CLASSE: Produit
VERSION: 1
REF UML:7
SPRINT:
REF_USER STORIES:
ASSOSSIATION: OnetoOne (Devis) unidirectionnel
*/
@Entity
public class Facture implements Serializable {
	
	
	// ----------- ATTRIBUTS: -----------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture;
	private Date dateFacturation;
	private String typePaiement;

	
	// ----------- ASSOCIATION: -----------
	@OneToOne
	private Devis devis;
	// ----------- GETTERS/SETTERS: -----------
	public Long getIdFacture() {
		return idFacture;
	}


	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}


	public Date getDateFacturation() {
		return dateFacturation;
	}


	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}


	public String getTypePaiement() {
		return typePaiement;
	}


	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}


	public Devis getDevis() {
		return devis;
	}


	public void setDevis(Devis devis) {
		this.devis = devis;
	}



	// ----------- CONSTRUCTEURS: -----------
	public Facture(Date dateFacturation, String typePaiement) {
		super();
		this.dateFacturation = dateFacturation;
		this.typePaiement = typePaiement;
	}
	public Facture() {
		super();
	}



	
}
