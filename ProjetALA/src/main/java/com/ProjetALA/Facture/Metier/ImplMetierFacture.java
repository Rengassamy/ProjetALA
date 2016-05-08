package com.ProjetALA.Facture.Metier;

import java.util.List;
import java.util.logging.Logger;








import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Facture.DAO.InterDAOFacture;
import com.ProjetALA.Facture.entity.Facture;

@Transactional
public class ImplMetierFacture implements InterMetierFacture {
	private final Logger Log= Logger.getLogger("Debut du test ");

	private InterDAOFacture daoFacture;
	
	public void setDaoFacture(InterDAOFacture daoFacture) {
		this.daoFacture = daoFacture;
		Log.info("dao Facture injecté");
	}

	@Override
	public Facture addFacture(Facture f, Long idDevis) {
		// TODO Auto-generated method stub
		return daoFacture.addFacture(f, idDevis);
	}

	@Override
	public void deleteFacture(Long idFacture) {
		// TODO Auto-generated method stub
		daoFacture.deleteFacture(idFacture);
	}

	@Override
	public Facture mergeFacture(Long idFacture) {
		// TODO Auto-generated method stub
		return daoFacture.mergeFacture(idFacture);
	}

	@Override
	public Facture getFacture(Long idFacture) {
		// TODO Auto-generated method stub
		return daoFacture.getFacture(idFacture);
	}

	@Override
	public List<Facture> getListFacture() {
		// TODO Auto-generated method stub
		return daoFacture.getListFacture();
	}

}
