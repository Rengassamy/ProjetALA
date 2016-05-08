package com.ProjetALA.Personne.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import com.ProjetALA.Personne.Personne;

public class ImplPersonneDao implements InterfPersonneDao{
	@PersistenceContext
    private EntityManager em;

	@Override
	public void AddPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.persist(p);
	}

	@Override
	public void deletePersonne(Personne p) {
		// TODO Auto-generated method stub
		em.remove(p);
	}

	@Override
	public List<Personne> getListofPersonne() {
		Query req=(Query) em.createQuery("from Personne");
		return req.getResultList();
	}

	@Override
	public List<Personne> getListofPersonneParMc(String mc) {
		// TODO Auto-generated method stub
		Query req=(Query) em.createQuery("from Personne e where e.nomPersonne like :x");
		req.setParameter("x", mc+"%");
		return req.getResultList();
	}

	@Override
	public Personne mergePersonne(Long idPersonne) {
		Personne p =em.find(Personne.class,idPersonne);
	    em.merge(p);
		return p;
	}

	@Override
	public Personne getPersonne(Long idPersonne) {
    Personne p = em.find(Personne.class, idPersonne);
		return p;
		
	}

}
