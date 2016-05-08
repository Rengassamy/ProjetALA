package com.ProjetALA.Produit.Metier;

import java.util.List;

import com.ProjetALA.Produit.entity.Produit;

public interface InterMetierProduit {
	
	public Produit addProduit(Produit p, Long idDevis);
	public void deleteProduit(Long idProduit);
	public Produit mergeProduit(Long idProduit);//modifier produit
	public Produit getProduit(Long idProduit);
	public List<Produit> getListProduit();
	public List<Produit> getListProduit_Devis(Long idDevis);
	public List<Produit> getListProduit_mc(String motcle);
	
}
