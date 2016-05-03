package com.ProjetALA.Chambre.Metier;

/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Chambre.Metier
 *Class: IChambreMetier
 *version:1.0
 *ref-UML: 5
 *sprint:1
 *ref-userStories: 1
 *INTERFACE METIER de la classe CHAMBRE
 * 
 * */
import java.util.Date;
import java.util.List;

import com.ProjetALA.Chambre.Chambre;

public interface IChambreMetier {
	public Chambre addChambre(Chambre c);
	public Chambre mergeChambre(Long idChambre);
	public void deleteChambre(Long idChambre);
	public Chambre getChambre(Long idChambre);
	public List<Chambre> getListChambre();
	public List<Chambre> getdispo(Date deb, Date fin, Integer nbrepers) throws Exception;
}
