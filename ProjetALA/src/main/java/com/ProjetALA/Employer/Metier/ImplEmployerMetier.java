package com.ProjetALA.Employer.Metier;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Implementation metier employer
 *
 * 
 * */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Employer.Employer;
import com.ProjetALA.Employer.DAO.InterfEmployerDao;

@Transactional
public class ImplEmployerMetier implements InterfEmployerMetier {
	private final Logger LOG = Logger.getLogger("ImplEmployerMetier");
	private InterfEmployerDao daoemployer;

	public void setDaoemployer(InterfEmployerDao daoemployer) {
		this.daoemployer = daoemployer;
		LOG.info("daoemployer employer injected");
	}

	@Override
	public void AddEmployer(Employer e) {
		daoemployer.AddEmployer(e);
	}

	@Override
	public void deleteEmployer(Employer e) {
		daoemployer.deleteEmployer(e);
	}

	@Override
	public List<Employer> getListofEmployer() {
		return daoemployer.getListofEmployer();
	}

	@Override
	public List<Employer> getListofEmployerParMc(String mc) {
		return daoemployer.getListofEmployerParMc(mc);
	}

	@Override
	public Employer getEmployer(Long idEmployer) {
		return daoemployer.getEmployer(idEmployer);
	}

	@Override
	public Employer mergeEmployer(Long idEmployer) {
		return daoemployer.getEmployer(idEmployer);
	}

}
