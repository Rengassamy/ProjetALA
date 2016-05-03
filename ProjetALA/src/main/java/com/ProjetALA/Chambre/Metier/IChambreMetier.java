package com.ProjetALA.Chambre.Metier;

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
