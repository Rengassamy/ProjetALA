package com.ProjetALA.Reservation.Metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Reservation.Reservation;

public interface IReservationMetier {
	public Reservation addReservation(Reservation r, Long idClient, Long idEmploye, ArrayList<Chambre> listChambre);
	public Reservation mergeReservation(Long idReservation);
	public void deleteReservation(Long idReservation);
	public Reservation getReservation(Long idReservation);
	public List<Reservation> getListReservation();
	public List<Reservation> getListReservationChambre(Long idChambre);
	public List<Reservation> getListReservationClient(Long idClient);
	public List<Reservation> getListReservationEmploye(Long idEmploye);
}
