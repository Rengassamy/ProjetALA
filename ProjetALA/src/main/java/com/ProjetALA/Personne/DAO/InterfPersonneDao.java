package com.ProjetALA.Personne.DAO;

import java.util.List;





import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.ProjetALA.Personne.Personne;

public interface InterfPersonneDao {


	/*Ajouter une personne*/
	public void AddPersonne(Personne p);
	
	/*supprimer une personne */
	public void deletePersonne(Personne p);
	
	/*consulter la liste des personnes */
	public List<Personne>getListofPersonne();
	
	/*consulter la liste des personnes par mot clé*/
	public List<Personne>getListofPersonneParMc(String mc);
	
	/*modifier une personne*/
	public Personne mergePersonne(Long idPersonne);
	
	
	public Personne getPersonne(Long idPersonne);
	
}
