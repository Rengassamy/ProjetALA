package com.ProjetALA.Client;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.com.ProjetALA
 *Class:Client
 *association:one to many
 * 
 * */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ProjetALA.Personne.Personne;
import com.ProjetALA.Reservation.Reservation;

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne {

	/***************** Association *****************/
	@OneToMany(mappedBy = "client")
	private List<Reservation> tabReservation = new ArrayList<Reservation>();

	/******************* constructor ***************/
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nomPersonne, String prenom, String sex,
			Date dateNaissance, String adresse, String tel, String mail) {
		super(nomPersonne, prenom, sex, dateNaissance, adresse, tel, mail);
		// TODO Auto-generated constructor stub
	}

	/*************** getterETsetter **************/
	public List<Reservation> getTabReservation() {
		return tabReservation;
	}

	public void setTabReservation(List<Reservation> tabReservation) {
		this.tabReservation = tabReservation;
	}

}
