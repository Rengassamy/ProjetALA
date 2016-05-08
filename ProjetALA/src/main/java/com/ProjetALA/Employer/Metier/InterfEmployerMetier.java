package com.ProjetALA.Employer.Metier;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Interface metier employer
 *
 * 
 * */
import java.util.List;

import com.ProjetALA.Employer.Employer;

public interface InterfEmployerMetier {
	/* Ajouter un employer */
	public void AddEmployer(Employer e);

	/* supprimer un employer */
	public void deleteEmployer(Employer e);

	/* consulter la liste d'employer */
	public List<Employer> getListofEmployer();

	/* consulter la liste d'employer par mot clé */
	public List<Employer> getListofEmployerParMc(String mc);

	public Employer getEmployer(Long idEmployer);

	/* modifier une personne */
	public Employer mergeEmployer(Long idEmployer);

}
