package com.ProjetALA.Facture.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ProjetALA.Devis.entity.Devis;
import com.ProjetALA.Facture.entity.Facture;

public class ImplDAOFacture implements InterDAOFacture{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Facture addFacture(Facture f, Long idDevis) {
		// TODO Auto-generated method stub
		
		Devis d = em.find(Devis.class, idDevis);
		f.setDevis(d);
		em.persist(f);
		return f;
	}

	@Override
	public void deleteFacture(Long idFacture) {
		// TODO Auto-generated method stub
		Facture f = em.find(Facture.class, idFacture);
		em.remove(f);
	}

	@Override
	public Facture mergeFacture(Long idFacture) {
		// TODO Auto-generated method stub
		Facture f = em.find(Facture.class, idFacture);
		em.merge(f);
		return f;
	}

	@Override
	public Facture getFacture(Long idFacture) {
		// TODO Auto-generated method stub
		Facture f = em.find(Facture.class, idFacture);
		
		return f;
	}

	@Override
	public List<Facture> getListFacture() {
		// TODO Auto-generated method stub
		Query query = (Query) em.createQuery("from Facture");
		
		return query.getResultList();
	}

}
