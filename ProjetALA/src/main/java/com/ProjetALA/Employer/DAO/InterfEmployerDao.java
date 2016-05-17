package com.ProjetALA.Employer.DAO;

import java.util.List;


import com.ProjetALA.Employer.Employer;


public interface InterfEmployerDao {

	/*Ajouter un employer*/
	public void AddEmployer(Employer e);
	
	/*supprimer un employer*/
	public void deleteEmployer(Long idEmployer);
	
	/*consulter la liste d'employer */
	public List<Employer>getListofEmployer();
	
	/*consulter la liste d'employer par mot clé*/
	public List<Employer>getListofEmployerParMc(String mc);
	
	
	public Employer getEmployer(Long idEmployer);
	
	public Employer mergeEmployer(Long idEmployer);
}
