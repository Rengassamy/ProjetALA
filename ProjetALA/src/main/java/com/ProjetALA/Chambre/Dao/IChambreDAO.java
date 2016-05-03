package com.ProjetALA.Chambre.Dao;

/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Chambre.Dao
 *Class: IChambreDAO
 *version:1.0
 *ref-UML: 5
 *sprint:1
 *ref-userStories: 1
 *INTERFACE DAO de la classe CHAMBRE
 */
import java.util.List;

import com.ProjetALA.Chambre.Chambre;

public interface IChambreDAO {
	public Chambre addChambre(Chambre c);
	public Chambre mergeChambre(Long idChambre);
	public void deleteChambre(Long idChambre);
	public Chambre getChambre(Long idChambre);
	public List<Chambre> getListChambre();

}
