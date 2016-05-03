package com.ProjetALA.Chambre.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ProjetALA.Chambre.Chambre;

public class ImplChambreDao implements IChambreDAO {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Chambre addChambre(Chambre c) {
		em.persist(c);
		return c;
	}

	@Override
	public Chambre mergeChambre(Long idChambre) {
		Chambre c = em.find(Chambre.class, idChambre);
		em.merge(c);
		return c;
	}

	@Override
	public void deleteChambre(Long idChambre) {
		em.remove(idChambre);
	}

	@Override
	public Chambre getChambre(Long idChambre) {
		Chambre c = em.find(Chambre.class, idChambre);
		return c;
	}

	@Override
	public List<Chambre> getListChambre() {
		Query query = em.createQuery("from Chambre c");
		return query.getResultList();
	}

}
