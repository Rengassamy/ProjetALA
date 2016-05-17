package com.ProjetALA.Client.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ProjetALA.Client.Client;


public class ImplClientDao implements InterfClientDao {
	
	@PersistenceContext
    private EntityManager em;
	@Override
	public void AjouterClient(Client c) {
		
		em.persist(c);
	}

	@Override
	public void deleteClient(Long idClient) {
		// TODO Auto-generated method stub
		Client c = em.find(Client.class, idClient);
		em.remove(c);
	}

	@Override
	public List<Client> getListofClient() {
		
		Query req=(Query) em.createQuery("from Client");
		return req.getResultList();
		
	}

	@Override
	public List<Client> getListofClientParMc(String mc) {
		
		Query req=(Query) em.createQuery("from Client c where c.nomClient like :x");
		req.setParameter("x", mc+"%");
		return req.getResultList();
		
		
	}

	@Override
	public Client mergeClient(Long idClient) {
		Client c =em.find(Client.class,idClient);
	    em.merge(c);
		return c;
		
	}

	@Override
	public Client getClient(Long idClient) {
	Client c = em.find(Client.class, idClient);
		return c;
	}

}
