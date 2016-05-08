package com.ProjetALA.Client.Metier;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Implementation metier client
 *
 * 
 * */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.ProjetALA.Client.Client;
import com.ProjetALA.Client.DAO.InterfClientDao;

;
@Transactional
public class ImplClientMetier implements InterfClientMetier {
	private final Logger LOG = Logger.getLogger("ImplClientMetier");
	private InterfClientDao daoclient;

	public void setDaoclient(InterfClientDao daoclient) {
		this.daoclient = daoclient;
		LOG.info("dao client injected");
	}

	@Override
	public void AjouterClient(Client c) {
		// TODO Auto-generated method stub
		daoclient.AjouterClient(c);
	}

	@Override
	public void deleteClient(Client c) {
		// TODO Auto-generated method stub
		daoclient.deleteClient(c);
	}

	@Override
	public List<Client> getListofClient() {
		// TODO Auto-generated method stub
		return daoclient.getListofClient();
	}

	@Override
	public List<Client> getListofClientParMc(String mc) {
		// TODO Auto-generated method stub
		return daoclient.getListofClientParMc(mc);

	}

	@Override
	public Client mergeClient(Long idClient) {
		return daoclient.getClient(idClient);
	}

	@Override
	public Client getClient(Long idClient) {
		return daoclient.getClient(idClient);
	}

	@Override
	public Client getClientParReservation(Long idReservation) {
		return getClientParReservation(idReservation);
	}

}
