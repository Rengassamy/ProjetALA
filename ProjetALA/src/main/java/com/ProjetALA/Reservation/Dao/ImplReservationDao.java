package com.ProjetALA.Reservation.Dao;
/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Reservation.Dao
 *Class: ImplReservationDao
 *version:1.0
 *ref-UML: 8
 *sprint:1
 *ref-userStories: 1
 *Classe implementation DAO de la classe RESERVATION
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Client.Client;
import com.ProjetALA.Employer.Employer;
import com.ProjetALA.Personne.Personne;
import com.ProjetALA.Reservation.Reservation;
@Transactional
public class ImplReservationDao implements IReservationDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Reservation addReservation(Reservation r, Long idClient,
			Long idEmploye, List<Chambre> listChambre) {
		// on récupère le client à partir de son id pour l'association
		Client c = em.find(Client.class, idClient);
		// on récupère l'employé à partir de son id pour l'association
		Employer e = em.find(Employer.class, idEmploye);
		// Association avec client
		r.setClient(c);
		// Association avec employer
		r.setEmploye(e);
		// Association avec chambre
		for (Chambre ch : listChambre) {
			r.getListchambre().add(ch);
		}
		// on ajoute l'objet reservation à la base de données
		em.persist(r);
		e.getTabReservation().add(r);
		c.getTabReservation().add(r);
		for (Chambre cha : listChambre) {
			cha.getListresa().add(r);
		}
		return r;
	}
	@Override
	public Reservation mergeReservation(Long idReservation) {
		Reservation r = em.find(Reservation.class, idReservation);
		return r;
	}

	@Override
	public void deleteReservation(Long idReservation) {
		Reservation r = em.find(Reservation.class, idReservation);
		em.remove(r);
	}

	@Override
	public Reservation getReservation(Long idReservation) {
		Reservation r = em.find(Reservation.class, idReservation);
		return r;
	}

	@Override
	public List<Reservation> getListReservation() {
		Query query= em.createQuery("from Reservation r");
		return query.getResultList();
	}
	@Override
	public List<Reservation> getListReservationChambre(Long idChambre) {
		Query query = em.createQuery("Select c.listresa from Chambre c where c.idChambre = "+idChambre);
		return query.getResultList();
	}
	@Override
	public List<Reservation> getListReservationClient(Long idClient) {
		Query query = em.createQuery("Select r from Reservation r where r.client ="+idClient);
		return query.getResultList();
	}
	@Override
	public List<Reservation> getListReservationEmploye(Long idEmploye) {
		Query query = em.createQuery("Select r from Reservation r where r.employe = "+idEmploye);
		return query.getResultList();
	}

}
