package com.ProjetALA.Produit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
AUTEUR: Mfoulou Lory
NOM DU PROJET: ProjetALA
DATE: 02/05/2016
CLASSE: Produit
VERSION: 1
REF UML:1
SPRINT:
REF_USER STORIES:
ASSOSSIATION: ManytoOne (Devis) unidirectionnel
*/

@Entity
public class Produit implements Serializable {
	// ----------- ATTRIBUTS: -----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String nomProduit;
	private Double prixProduit;
	private String desrcriptionProduit;
	private Long quantit�Produit;
	// ----------- ASSOCIATION: -----------

		//(unidirectionnel : voir Devis)
	
	// ----------- GETTERS/SETTERS: -----------
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}
	public String getDesrcriptionProduit() {
		return desrcriptionProduit;
	}
	public void setDesrcriptionProduit(String desrcriptionProduit) {
		this.desrcriptionProduit = desrcriptionProduit;
	}
	
	public Long getQuantit�Produit() {
		return quantit�Produit;
	}
	public void setQuantit�Produit(Long quantit�Produit) {
		this.quantit�Produit = quantit�Produit;
	}
	// ----------- CONSTRUCTEURS: -----------

	public Produit(String nomProduit, Double prixProduit,
			String desrcriptionProduit, Long quantit�Produit) {
		super();
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.desrcriptionProduit = desrcriptionProduit;
		this.quantit�Produit = quantit�Produit;
	}
	public Produit() {
		super();
	}

	
	
}
