package com.ProjetALA.Reservation;

/*Auteur: Arnaud MARY
 *nom Projet: ProjetALA
 *date : 02/05/2016
 *Package: com.ProjetALA.Reservation
 *Class: Reservation
 *version:1.0
 *ref-UML: 5
 *sprint:1
 *ref-userStories: 1
 *association: ManytoOne avec Client, ManytoMany avec Chambre, ManyToOne avec Employe
 * 
 * */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Client.Client;
import com.ProjetALA.Employer.Employer;

@SuppressWarnings("serial")
@Entity
public class Reservation implements Serializable{
	/* attributs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReservation;
//	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datedebut;
//	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datefin;
//	@NotNull
	private String etatresa;
	/*association avec client */
//	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Client client;
	/* association avec chambre */
//	@NotNull
	@ManyToMany(mappedBy="listresa",fetch=FetchType.LAZY)
	private List<Chambre> listchambre = new ArrayList<Chambre>();
	/* association avec Employe */
//	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Employer employe;
	
	/* getter et setters */
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getEtatresa() {
		return etatresa;
	}
	public void setEtatresa(String etatresa) {
		this.etatresa = etatresa;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Chambre> getListchambre() {
		return listchambre;
	}
	public void setListchambre(List<Chambre> listchambre) {
		this.listchambre = listchambre;
	}
		
	public Employer getEmploye() {
		return employe;
	}
	public void setEmploye(Employer employe) {
		this.employe = employe;
	}
	/* constructeurs : avec paramètres et par défaut */
	public Reservation(Date datedebut, Date datefin, String etatresa) {
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etatresa = etatresa;
	}
	public Reservation() {
	}
}
