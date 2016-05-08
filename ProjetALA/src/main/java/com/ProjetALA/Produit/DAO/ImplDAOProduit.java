package com.ProjetALA.Produit.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ProjetALA.Devis.entity.Devis;
import com.ProjetALA.Produit.entity.Produit;
import com.ProjetALA.Reservation.Reservation;

public class ImplDAOProduit implements InterDAOProduit{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit addProduit(Produit p,Long idDevis) {
		// TODO Auto-generated method stub
		Devis d = em.find(Devis.class, idDevis);
		d.getListProduit().add(p);
		em.persist(p);
		
		return p;
	}

	@Override
	public void deleteProduit(Long idProduit) {
		// TODO Auto-generated method stub
		Produit p = em.find(Produit.class, idProduit);
		em.remove(p);
	}

	@Override
	public Produit mergeProduit(Long idProduit) {
		// TODO Auto-generated method stub
		Produit p = em.find(Produit.class, idProduit);
		em.merge(p);
		return p;
	}

	@Override
	public Produit getProduit(Long idProduit) {
		// TODO Auto-generated method stub
		Produit p = em.find(Produit.class, idProduit);
		
		return p;
	}

	@Override
	public List<Produit> getListProduit() {
		// TODO Auto-generated method stub
		Query query = (Query) em.createQuery("from Produit");
		
		return query.getResultList();
	}

	@Override
	public List<Produit> getListProduit_Devis(Long idDevis) {
		// TODO Auto-generated method stub
		
		Query query = (Query) em.createQuery("Select d.listProduit from Devis d where d.idDevis =:x");
		query.setParameter("x",idDevis);
		return query.getResultList();
		
	}

	@Override
	public List<Produit> getListProduit_mc(String motcle) {
		// TODO Auto-generated method stub
		Query query = (Query) em.createQuery("Select p from Produit p where p.nomProduit like :x or p.desrcriptionProduit like :x");
		query.setParameter("x", "%" + motcle + "%");
		return query.getResultList();
	}

}
