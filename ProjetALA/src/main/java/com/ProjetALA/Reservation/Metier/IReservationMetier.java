package com.ProjetALA.Reservation.Metier;

/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Reservation.Metier
 *Class: IReservationMetier
 *version:1.0
 *ref-UML: 8
 *sprint:1
 *ref-userStories: 1
 *INTERFACE METIER de la classe RESERVATION
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Reservation.Reservation;

public interface IReservationMetier {
	public Reservation addReservation(Reservation r, Long idClient, Long idEmploye, List<Chambre> tabC);
	public Reservation mergeReservation(Long idReservation);
	public void deleteReservation(Long idReservation);
	public Reservation getReservation(Long idReservation);
	public List<Reservation> getListReservation();
	public List<Reservation> getListReservationChambre(Long idChambre);
	public List<Reservation> getListReservationClient(Long idClient);
	public List<Reservation> getListReservationEmploye(Long idEmploye);
}
