package com.ProjetALA.Client.DAO;

import java.util.List;

import com.ProjetALA.Client.Client;


public interface InterfClientDao {

	/*Ajouter un client*/
	public void AjouterClient(Client c);
	
	/*supprimer un client*/
	public void deleteClient(Client c);
	
	/*consulter la liste de client*/
	public List<Client>getListofClient();
	
	/*consulter la liste de client par mot clé*/
	public List<Client>getListofClientParMc(String mc);
	
	
    public Client mergeClient(Long idClient);
	
	
	public Client getClient(Long idClient);
	
}
