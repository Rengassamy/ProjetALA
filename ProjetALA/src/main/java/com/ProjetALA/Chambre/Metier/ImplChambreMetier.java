package com.ProjetALA.Chambre.Metier;
/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Chambre.Metier
 *Class: ImplChambreMetier
 *version:1.0
 *ref-UML: 5
 *sprint:1
 *ref-userStories: 1
 *Classe d'implémentation Metier de Chambre
 * 
 * */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Chambre.Dao.IChambreDAO;
import com.ProjetALA.Reservation.Reservation;

@Transactional
public class ImplChambreMetier implements IChambreMetier {

	
	private final Logger LOG=Logger.getLogger("ImplChambreMetier");
	// DAO Chambre : declaration + setter
	private IChambreDAO daochambre;

	public void setDaochambre(IChambreDAO daochambre) {
		this.daochambre = daochambre;
		LOG.info("DAO Chambre injected");
	}

	@Override
	public Chambre addChambre(Chambre c) {
		daochambre.addChambre(c);
		return c;
	}

	@Override
	public Chambre mergeChambre(Long idChambre) {
		return daochambre.mergeChambre(idChambre);
	}

	@Override
	public void deleteChambre(Long idChambre) {
		daochambre.deleteChambre(idChambre);
	}

	@Override
	public Chambre getChambre(Long idChambre) {
		return daochambre.getChambre(idChambre);
	}

	@Override
	public List<Chambre> getListChambre() {
		return daochambre.getListChambre();
	}

	@Override
	public List<Chambre> getdispo(Date deb, Date fin, Integer nbrepers) throws Exception{
		if (deb.getTime()>fin.getTime()) throw new Exception("La date de fin doit être supérieure à la date de début");
		List<Chambre> listchambreok = new ArrayList<Chambre>();
		
		for (Chambre ch : daochambre.getListChambre()) {
			String Chevauchement ="Non";
			for (Reservation	r : ch.getListresa()) {
				if ((r.getDatedebut().getTime() < deb.getTime() && r.getDatefin().getTime()> deb.getTime())
						|| (r.getDatedebut().getTime() <fin.getTime() && r.getDatefin().getTime()>fin.getTime())){
						Chevauchement = "Oui";
						break;
				}
			}
			if (Chevauchement == "Non"){
			listchambreok.add(ch);
			}
		} 
		
		Integer capacitehotel = 0;
		for (Chambre c : listchambreok) {
			capacitehotel = capacitehotel + c.getCapacite();
		}
		if (capacitehotel < nbrepers){
			throw new Exception("L'hotel ne peut accueillir le nombre de personnes demandé");
		}
		return listchambreok;
	}

}
