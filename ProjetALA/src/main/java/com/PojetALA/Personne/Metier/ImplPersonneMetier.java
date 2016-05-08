package com.PojetALA.Personne.Metier;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Implémentation metier personne
 *
 * 
 * */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Personne.Personne;
import com.ProjetALA.Personne.DAO.InterfPersonneDao;

@Transactional
public class ImplPersonneMetier implements InterfPersonneMetier {

	private final Logger LOG = Logger.getLogger("ImplPersonneMetier");
	private InterfPersonneDao daopersonne;


	public void setDaopersonne(InterfPersonneDao daopersonne) {
		this.daopersonne = daopersonne;
		LOG.info("daopersonne Personne injected");
	}

	@Override
	public void AddPersonne(Personne p) {
		// TODO Auto-generated method stub
		daopersonne.AddPersonne(p);
	}

	@Override
	public void deletePersonne(Personne p) {
		// TODO Auto-generated method stub
		daopersonne.deletePersonne(p);
	}

	@Override
	public List<Personne> getListofPersonne() {
		// TODO Auto-generated method stub
		return daopersonne.getListofPersonne();
	}

	@Override
	public List<Personne> getListofPersonneParMc(String mc) {
		// TODO Auto-generated method stub
		return daopersonne.getListofPersonneParMc(mc);
	}

	@Override
	public Personne mergePersonne(Long idPersonne) {
		return daopersonne.getPersonne(idPersonne);
	}

	@Override
	public Personne getPersonne(Long idPersonne) {
		return daopersonne.getPersonne(idPersonne);
	}

}
