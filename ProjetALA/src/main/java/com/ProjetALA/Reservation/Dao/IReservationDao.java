package com.ProjetALA.Reservation.Dao;

import java.util.List;

import com.ProjetALA.Reservation.Reservation;

public interface IReservationDao {
	public Reservation addReservation(Reservation r);
	public Reservation mergeReservation(Long idReservation);
	public Reservation deleteReservation(Long idReservation);
	public Reservation getReservation(Long idReservation);
	public List<Reservation> getListReservation();
}
