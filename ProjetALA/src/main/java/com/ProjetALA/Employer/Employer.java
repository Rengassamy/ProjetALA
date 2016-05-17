
package com.ProjetALA.Employer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.ProjetALA.Personne.Personne;
import com.ProjetALA.Reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/*Auteur:Rengassamy Alex
 * nom Projet :ProjetALA
 *date:02/05/2016
 *Package:com.ProjetALA
 *Class:Employer
 *association:List<Reservation>
 * 
 * */
@Entity
@DiscriminatorValue("Employer")
public class Employer extends Personne {

	/************* Association ***********/
	
	@OneToMany(mappedBy = "employe")
	private List<Reservation> tabReservation = new ArrayList<Reservation>();
	

	/******** getterETsetter *********************/
	@JsonIgnore
	public List<Reservation> getTabReservation() {
		return tabReservation;
	}
	@JsonSetter
	public void setTabReservation(List<Reservation> tabReservation) {
		this.tabReservation = tabReservation;
	}

	/************** Constructor issu de la classe mère *********************/
	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employer(String nomPersonne, String prenom, String sex,
			Date dateNaissance, String adresse, String tel, String mail) {
		super(nomPersonne, prenom, sex, dateNaissance, adresse, tel, mail);
		// TODO Auto-generated constructor stub
	}


}
