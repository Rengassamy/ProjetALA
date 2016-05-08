package com.ProjetALA.Devis.Metier;

import java.util.List;

import com.ProjetALA.Devis.entity.Devis;


public interface InterMetierDevis {

	public Devis addDevis(Devis d,Long idReservation);
	public void deleteDevis(Long idDevis);
	public Devis mergeDevis(Long idDevis);//modifier produit
	public Devis getDevis(Long idDevis);
	public List<Devis> getListDevis();
	
	public double montantTotalReservation(Long idDevis);
	public double montantTotalProduits(Long idDevis);
	public double montantDevis(Long idDevis);
	
}
