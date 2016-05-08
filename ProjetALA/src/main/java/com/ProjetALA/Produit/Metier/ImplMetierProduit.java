package com.ProjetALA.Produit.Metier;

import java.util.List;
import java.util.logging.Logger;






import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Produit.DAO.InterDAOProduit;
import com.ProjetALA.Produit.entity.Produit;

@Transactional
public class ImplMetierProduit implements InterMetierProduit {
	private final Logger Log= Logger.getLogger("Debut du test ");
	
	private InterDAOProduit daoProduit;

	public void setDaoProduit(InterDAOProduit daoProduit) {
		this.daoProduit = daoProduit;
		Log.info("dao Produit injecté");
	}

	@Override
	public Produit addProduit(Produit p, Long idDevis) {
		// TODO Auto-generated method stub
		return daoProduit.addProduit(p, idDevis);
	}

	@Override
	public void deleteProduit(Long idProduit) {
		// TODO Auto-generated method stub
		daoProduit.deleteProduit(idProduit);
	}

	@Override
	public Produit mergeProduit(Long idProduit) {
		// TODO Auto-generated method stub
		return daoProduit.mergeProduit(idProduit);
	}

	@Override
	public Produit getProduit(Long idProduit) {
		// TODO Auto-generated method stub
		return daoProduit.getProduit(idProduit);
	}

	@Override
	public List<Produit> getListProduit() {
		// TODO Auto-generated method stub
		return daoProduit.getListProduit();
	}

	@Override
	public List<Produit> getListProduit_Devis(Long idDevis) {
		// TODO Auto-generated method stub
		return daoProduit.getListProduit_Devis(idDevis);
	}

	@Override
	public List<Produit> getListProduit_mc(String motcle) {
		// TODO Auto-generated method stub
		return daoProduit.getListProduit_mc(motcle);
	}

}
