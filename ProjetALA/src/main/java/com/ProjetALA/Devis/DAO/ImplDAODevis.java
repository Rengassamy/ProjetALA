package com.ProjetALA.Devis.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Devis.entity.Devis;
import com.ProjetALA.Produit.entity.Produit;
import com.ProjetALA.Reservation.Reservation;


public class ImplDAODevis implements InterDAODevis{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Devis addDevis(Devis d,Long idReservation) {
		// TODO Auto-generated method stub
		Reservation r = em.find(Reservation.class, idReservation);
		d.setReservation(r);
		em.persist(d);
		return d;
	}

	@Override
	public void deleteDevis(Long idDevis) {
		// TODO Auto-generated method stub
		Devis d = em.find(Devis.class, idDevis);
		em.remove(d);
	}

	@Override
	public Devis mergeDevis(Long idDevis) {
		// TODO Auto-generated method stub
		Devis d = em.find(Devis.class, idDevis);
		em.merge(d);
		return d;
	}

	@Override
	public Devis getDevis(Long idDevis) {
		// TODO Auto-generated method stub
		Devis d = em.find(Devis.class, idDevis);
		
		return d;
	}

	@Override
	public List<Devis> getListDevis() {
		// TODO Auto-generated method stub
		Query query = (Query) em.createQuery("from Devis");
		
		return query.getResultList();
		
	}

	@Override
	public double montantTotalReservation(Long idDevis) {
		// TODO Auto-generated method stub
		
		//intialisation:
		double prixReservation =0;
		Devis d = em.find(Devis.class, idDevis);
		Reservation r = d.getReservation();
		//calcul du prix total de la reservation:
		for (Chambre c: r.getListchambre()){
			prixReservation = prixReservation + c.getPrix();			
		}
		//calcul du nbr de jour:
		Date d1 = r.getDatedebut();
		Date d2 =r.getDatefin();
		Long nbrJours = (d2.getTime()-d1.getTime())/(86400000);
		
		//calcul du prix final:
		prixReservation=prixReservation*nbrJours;
		
		return prixReservation;
	}

	@Override
	public double montantTotalProduits(Long idDevis) {
		// TODO Auto-generated method stub
		
		//intialisation:
		Devis d = em.find(Devis.class, idDevis);
		double prixProduits =0;

		//calcul du prix total des produits:
				for (Produit p: d.getListProduit()){
					prixProduits = prixProduits + p.getPrixProduit()*p.getQuantitéProduit();			
				}
			
		return prixProduits;
	}

	@Override
	public double montantDevis(Long idDevis) {
		// TODO Auto-generated method stub
		return montantTotalReservation(idDevis)+montantTotalProduits(idDevis);
	}

}
