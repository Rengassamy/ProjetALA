package com.PojetALA.Personne.Metier;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Interface metier personne
 *
 * 
 * */
import java.util.List;

import com.ProjetALA.Personne.Personne;

public interface InterfPersonneMetier {

	/* Ajouter une personne */
	public void AddPersonne(Personne p);

	/* supprimer une personne */
	public void deletePersonne(Personne p);

	/* consulter la liste des personnes */
	public List<Personne> getListofPersonne();

	/* consulter la liste des personnes par mot clé */
	public List<Personne> getListofPersonneParMc(String mc);

	/* modifier une personne */
	public Personne mergePersonne(Long idPersonne);

	public Personne getPersonne(Long idPersonne);
}
