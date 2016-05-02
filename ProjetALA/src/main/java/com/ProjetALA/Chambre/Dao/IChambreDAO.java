package com.ProjetALA.Chambre.Dao;

import java.util.List;

import com.ProjetALA.Chambre.Chambre;

public interface IChambreDAO {
	public Chambre addChambre(Chambre C);
	public Chambre mergeChambre(Long idChambre);
	public Chambre deleteChambre(Long idChambre);
	public Chambre getChambre(Long idChambre);
	public List<Chambre> getListChambre();

}
