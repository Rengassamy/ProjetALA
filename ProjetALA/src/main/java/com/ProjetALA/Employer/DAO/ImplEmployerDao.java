package com.ProjetALA.Employer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ProjetALA.Employer.Employer;


public class ImplEmployerDao implements InterfEmployerDao {
	@PersistenceContext
    private EntityManager em;

	@Override
	public void AddEmployer(Employer e) {
		// TODO Auto-generated method stub
		em.persist(e);
	}

	@Override
	public void deleteEmployer(Employer e) {
		// TODO Auto-generated method stub
		em.remove(e);
	}

	@Override
	public List<Employer> getListofEmployer() {
		// TODO Auto-generated method stub
		Query req=(Query) em.createQuery("from Employer");
		return req.getResultList();
	}

	@Override
	public List<Employer> getListofEmployerParMc(String mc) {
		// TODO Auto-generated method stub
		Query req=(Query) em.createQuery("from Employer e where e.nomEmployer like :x");
		req.setParameter("x", mc+"%");
		return req.getResultList();
	}

	@Override
	public Employer getEmployer(Long idEmployer) {
		Employer e = em.find(Employer.class, idEmployer);
		return e;
	}

	@Override
	public Employer mergeEmployer(Long idEmployer) {
		Employer e =em.find(Employer.class,idEmployer);
	    em.merge(e);
		return e;
	}
	

}
