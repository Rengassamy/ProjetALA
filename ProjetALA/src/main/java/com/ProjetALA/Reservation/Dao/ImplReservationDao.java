package com.ProjetALA.Reservation.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Client.Client;
import com.ProjetALA.Employer.Employer;
import com.ProjetALA.Reservation.Reservation;

public class ImplReservationDao implements IReservationDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Reservation addReservation(Reservation r, Long idClient,
			Long idEmploye, ArrayList<Chambre> listChambre) {
		// on récupère le client à partir de son id pour l'association
		Client cl = em.find(Client.class, idClient);
		// on récupère l'employé à partir de son id pour l'association
		Employer e = em.find(Employer.class, idEmploye);
		// Association avec client
		r.setClient(cl);
		cl.getTabReservation().add(r);
		// Association avec employer
		r.setEmploye(e);
		e.getTabReservation().add(r);
		// Association avec chambre
		for (Chambre c : listChambre) {
			r.getListchambre().add(c);
			c.getListresa().add(r);
		}
		// on ajoute l'objet reservation à la base de données
		em.persist(r);
		return r;
	}
	@Override
	public Reservation mergeReservation(Long idReservation) {
		Reservation r = em.find(Reservation.class, idReservation);
		return r;
	}

	@Override
	public void deleteReservation(Long idReservation) {
		em.remove(idReservation);
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
		Query query = em.createQuery("Select e from Reservation r where r.Client ="+idClient);
		return query.getResultList();
	}
	@Override
	public List<Reservation> getListReservationEmploye(Long idEmploye) {
		Query query = em.createQuery("Select r from Reservation r where r.Employe = "+idEmploye);
		return query.getResultList();
	}

}
