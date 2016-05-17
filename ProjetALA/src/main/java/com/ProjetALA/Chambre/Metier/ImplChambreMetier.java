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

	private final Logger LOG = Logger.getLogger("ImplChambreMetier");
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
		if (deb.getTime() > fin.getTime())
			throw new Exception("La date de fin doit être supérieure à la date de début");
		List<Chambre> listchok = new ArrayList<Chambre>();
		Long ddeb = deb.getTime();
		Long dfin = fin.getTime();
		System.out.println("Date deb : "+ddeb);
		System.out.println("Date fin : "+dfin);
		for (Chambre ch : daochambre.getListChambre()) {
			Boolean chevauchement = false;
			for (Reservation r : ch.getListresa()) {
				Long rdeb = r.getDatedebut().getTime();
				Long rfin = r.getDatefin().getTime();
				System.out.println("Date deb resa : "+rdeb);
				System.out.println("Date fin resa : "+rfin);
				if ((rdeb <= ddeb && rfin >= ddeb)
						|| (rdeb <= dfin && rfin >= dfin)){
					System.out.println("Chevauchement trouvé");
					chevauchement = true;
							break;	
						}
			}
			System.out.println("Valeur booléen : "+chevauchement);
			if (chevauchement.booleanValue()==false) {
				listchok.add(ch);
			}	
		}
		Integer capa =0;
		for (Chambre c : listchok) {
			capa =capa + c.getCapacite();
		}
		if (nbrepers > capa){
			throw new Exception("L'hotel ne peut pas accueilir ce nombre de personnes aux dates demandées");
		} 
		System.out.println("Nbre chambres : "+listchok.size());
		return listchok;
	}
}
