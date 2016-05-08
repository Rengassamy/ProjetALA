package com.ProjetALA.Facture.DAO;

import java.util.List;

import com.ProjetALA.Facture.entity.Facture;

public interface InterDAOFacture {

	public Facture addFacture(Facture f, Long idDevis);
	public void deleteFacture(Long idFacture);
	public Facture mergeFacture(Long idFacture);//modifier produit
	public Facture getFacture(Long idFacture);
	public List<Facture> getListFacture();
	
}
