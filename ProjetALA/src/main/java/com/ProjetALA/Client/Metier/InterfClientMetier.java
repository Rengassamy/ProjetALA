package com.ProjetALA.Client.Metier;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Interface metier client
 *
 * 
 * */
import java.util.List;




import com.ProjetALA.Client.Client;

public interface InterfClientMetier {

	/* Ajouter un client */
	public void AjouterClient(Client c);

	/* supprimer un client */
	public void deleteClient(Long idClient);

	/* consulter la liste de client */
	public List<Client> getListofClient();

	/* consulter la liste de client par mot clé */
	public List<Client> getListofClientParMc(String mc);

	/* modifier une personne */
	public Client mergeClient(Long idClient);

	public Client getClient(Long idClient);

	public Client getClientParReservation(Long idReservation);
}
