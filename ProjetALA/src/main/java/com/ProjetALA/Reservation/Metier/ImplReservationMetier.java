package com.ProjetALA.Reservation.Metier;

/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Reservation.Metier
 *Class: ImplReservationMetier
 *version:1.0
 *ref-UML: 8
 *sprint:1
 *ref-userStories: 1
 *Classe d'implémentation Metier de Reservation
 * 
 * */

import java.util.List;
import java.util.logging.Logger;


import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Reservation.Reservation;
import com.ProjetALA.Reservation.Dao.IReservationDao;
@Transactional
public class ImplReservationMetier implements IReservationMetier {
	
	private Logger log = Logger.getLogger("ImplReservationMetier");
	
	// DAO Reservation : declaration + seter
	private IReservationDao daoresa;
	
	public void setDaoresa(IReservationDao daoresa) {
		this.daoresa = daoresa;
		log.info("Dao Reservation injected");
	}

	@Override
	public Reservation addReservation(Reservation r, Long idClient,
			Long idEmploye, List<Chambre> listChambre) {
		daoresa.addReservation(r, idClient, idEmploye, listChambre);
		return r;
	}
	
	@Override
	public Reservation mergeReservation(Long idReservation) {
		return daoresa.mergeReservation(idReservation);
	}

	@Override
	public void deleteReservation(Long idReservation) {
		daoresa.deleteReservation(idReservation);
	}

	@Override
	public Reservation getReservation(Long idReservation) {
		return daoresa.getReservation(idReservation);
	}

	@Override
	public List<Reservation> getListReservation() {
		return daoresa.getListReservation();
	}

	@Override
	public List<Reservation> getListReservationChambre(Long idChambre) {
		return daoresa.getListReservationChambre(idChambre);
	}

	@Override
	public List<Reservation> getListReservationClient(Long idClient) {
		return daoresa.getListReservationClient(idClient);
	}

	@Override
	public List<Reservation> getListReservationEmploye(Long idEmploye) {
		return daoresa.getListReservationEmploye(idEmploye);
	}

}
