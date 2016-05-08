package com.ProjetALA.Test.ReservationMetier;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Client.Client;
import com.ProjetALA.Employer.Employer;
import com.ProjetALA.Reservation.Reservation;
import com.ProjetALA.Reservation.Metier.IReservationMetier;

public class TestReservationMetier {
	
	private static ClassPathXmlApplicationContext context;
	private static IReservationMetier ReservationMetier;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReservationMetier = (IReservationMetier) context.getBean("ReservationMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddReservation() {
		Reservation r = new Reservation(new Date(), new Date(), "validee");
		Chambre c = new Chambre("124", 4, 15.1, "Chambre double king size avec vue sur poubelles");
		List<Chambre> tabC = new ArrayList<Chambre>();
		tabC.add(c);
		ReservationMetier.addReservation(r, 1L, 2L, tabC);
		assertNotNull(r.getIdReservation());
	}

	@Test
	public void testMergeReservation() {
		Reservation r = new Reservation(new Date(), new Date(), "validee");
		Chambre c = new Chambre("12", 2, 151.25, "Suite avec vue sur Monaco");
		List<Chambre> tabC = new ArrayList<Chambre>();
		tabC.add(c);
		ReservationMetier.addReservation(r, 1L, 2L, tabC);
		Client client = new Client("Test", "Test", "F", new Date(), "Test", "Test", "truc@bidule.fr");
		r.setClient(client);
		assertTrue(r.getClient().getMail().equals("truc@bidule.fr"));
		;
	}

	@Test
	public void testDeleteReservation() {
		List<Reservation> tabr = ReservationMetier.getListReservation();
		Integer taille1 = tabr.size();
		ReservationMetier.deleteReservation(6L);
		List<Reservation> tabr2 = ReservationMetier.getListReservation();
		Integer taille2 = tabr2.size();
		assertTrue(taille1 == (taille2 +1));
		
	}

	@Test
	public void testGetReservation() {
		Reservation r = ReservationMetier.getReservation(5L);
		assertNotNull(r.getIdReservation());
	}

	@Test
	public void testGetListReservation() {
		List<Reservation> tabR = ReservationMetier.getListReservation();
		assertTrue(tabR.size()>0);
	}

	@Test
	public void testGetListReservationChambre() {
		List<Reservation> tab = ReservationMetier.getListReservationChambre(1L);
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListReservationClient() {
		List<Reservation> tab = ReservationMetier.getListReservationClient(1L);
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListReservationEmploye() {
		List<Reservation> tab = ReservationMetier.getListReservationEmploye(2L);
		assertTrue(tab.size()>0);
	}

}
