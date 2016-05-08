package com.ProjetALA.Devis.Metier;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Devis.DAO.InterDAODevis;
import com.ProjetALA.Devis.entity.Devis;

@Transactional
public class ImplMetierDevis implements InterMetierDevis{
	private final Logger Log= Logger.getLogger("Debut du test ");
	
	private InterDAODevis daoDevis;

	public void setDaoDevis(InterDAODevis daoDevis) {
		this.daoDevis = daoDevis;
		Log.info("dao Devis injecté");
	}

	@Override
	public Devis addDevis(Devis d,Long idReservation) {
		// TODO Auto-generated method stub
		return daoDevis.addDevis(d,idReservation);
	}

	@Override
	public void deleteDevis(Long idDevis) {
		// TODO Auto-generated method stub
		daoDevis.deleteDevis(idDevis);
	}

	@Override
	public Devis mergeDevis(Long idDevis) {
		// TODO Auto-generated method stub
		return daoDevis.mergeDevis(idDevis);
	}

	@Override
	public Devis getDevis(Long idDevis) {
		// TODO Auto-generated method stub
		return daoDevis.getDevis(idDevis);
	}

	@Override
	public List<Devis> getListDevis() {
		// TODO Auto-generated method stub
		return daoDevis.getListDevis();
	}

	@Override
	public double montantTotalReservation(Long idDevis) {
		// TODO Auto-generated method stub
		return daoDevis.montantTotalReservation(idDevis);
	}

	@Override
	public double montantTotalProduits(Long idDevis) {
		// TODO Auto-generated method stub
		return daoDevis.montantTotalProduits(idDevis);
	}

	@Override
	public double montantDevis(Long idDevis) {
		// TODO Auto-generated method stub
		return daoDevis.montantDevis(idDevis);
	}

}
