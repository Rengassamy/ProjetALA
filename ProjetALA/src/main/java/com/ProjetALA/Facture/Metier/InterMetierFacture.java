package com.ProjetALA.Facture.Metier;

import java.util.List;

import com.ProjetALA.Facture.entity.Facture;

public interface InterMetierFacture {

	public Facture addFacture(Facture f, Long idDevis);
	public void deleteFacture(Long idFacture);
	public Facture mergeFacture(Long idFacture);//modifier produit
	public Facture getFacture(Long idFacture);
	public List<Facture> getListFacture();
}
