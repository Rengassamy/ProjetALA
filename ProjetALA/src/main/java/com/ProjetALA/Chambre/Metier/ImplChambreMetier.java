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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Chambre.Dao.IChambreDAO;
import com.ProjetALA.Reservation.Reservation;

@Transactional
public class ImplChambreMetier implements IChambreMetier {

	@PersistenceContext
	private EntityManager em;
	
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
	/*	List<Chambre> listchambreokcapa = new ArrayList<Chambre>();
		List<Chambre> listchambreokdate = new ArrayList<Chambre>();
		
		for (Chambre c : daochambre.getListChambre()) {
			if (c.getCapacite()>= nbrepers){
				listchambreokcapa.add(c);
			}
		}
		if (listchambreokcapa.size()==0){
			throw new Exception("Il n'existe aucune chambre avec la capacité demandée");
		}
		for (Chambre ch : listchambreokcapa) {
			for (Reservation	r : ch.getListresa()) {
				if (r.getDatefin().getTime() < fin.getTime() || r.getDatedebut().getTime() > deb.getTime()){
					
				}
			}
			listchambreokdate.add(ch);
		} */
		return null;
	}

}
