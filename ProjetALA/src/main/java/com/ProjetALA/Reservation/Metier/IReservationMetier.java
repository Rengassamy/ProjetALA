package com.ProjetALA.Reservation.Metier;

import java.util.List;

import com.ProjetALA.Reservation.Reservation;

public interface IReservationMetier {
	public Reservation addReservation(Reservation r);
	public Reservation mergeReservation(Long idReservation);
	public Reservation deleteReservation(Long idReservation);
	public Reservation getReservation(Long idReservation);
	public List<Reservation> getListReservation();
}
