package com.ProjetALA.Reservation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetALA.Reservation.Reservation;
import com.ProjetALA.Reservation.Metier.IReservationMetier;

@RestController
public class ServiceResa {
	@Autowired
	private IReservationMetier ResaMetier;
	@RequestMapping(value="/getlistresa", method=RequestMethod.GET)
	public List<Reservation> getlistresa(){
		return ResaMetier.getListReservation();
	}

}
