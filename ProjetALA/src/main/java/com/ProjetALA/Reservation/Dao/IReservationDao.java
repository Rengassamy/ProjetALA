package com.ProjetALA.Reservation.Dao;
/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Reservation.Dao
 *Class: IReservationDao
 *version:1.0
 *ref-UML: 8
 *sprint:1
 *ref-userStories: 1
 *INTERFACE DAO de la classe RESERVATION
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Reservation.Reservation;

public interface IReservationDao {
	public Reservation addReservation(Reservation r, Long idClient, Long idEmploye, ArrayList<Chambre> listChambre);
	public Reservation mergeReservation(Long idReservation);
	public void deleteReservation(Long idReservation);
	public Reservation getReservation(Long idReservation);
	public List<Reservation> getListReservation();
	public List<Reservation> getListReservationChambre(Long idChambre);
	public List<Reservation> getListReservationClient(Long idClient);
	public List<Reservation> getListReservationEmploye(Long idEmploye);
}
