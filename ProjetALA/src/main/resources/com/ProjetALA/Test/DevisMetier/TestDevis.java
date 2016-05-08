package com.ProjetALA.Test.DevisMetier;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ProjetALA.Devis.Metier.InterMetierDevis;
import com.ProjetALA.Devis.entity.Devis;

public class TestDevis{

	
	private static ClassPathXmlApplicationContext context;
	private static InterMetierDevis metier;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterMetierDevis)context.getBean("DevisMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	
	Devis dev1 = new Devis();
	Devis dev2 = new Devis();
	
	@Test
	public void testAddDevis() {
		
		
		metier.addDevis(dev1, 1L);
		metier.addDevis(dev2, 1L);
		
		assertNotNull(dev1.getIdDevis());
		
	}//OK

	@Test
	public void testDeleteDevis() {
		
		metier.deleteDevis(2L);
		assertNull(metier.getDevis(2L));
		
	}//OK

	@Test
	public void testMergeDevis() {
		dev2.setIdDevis(6L);
		metier.mergeDevis(dev2.getIdDevis());
		assertTrue(dev2.getIdDevis()==6L);
	}

	@Test
	public void testGetDevis() {
		Devis dev5 = metier.getDevis(1L);
		assertNotNull(dev5.getIdDevis());
	}//OK

	@Test
	public void testGetListDevis() {
		List<Devis> ldevis = metier.getListDevis();
		assertTrue(ldevis.size()>0);
	}//OK

	@Test
	public void testMontantTotalReservation() {
		double mts = metier.montantTotalReservation(1L);
		assertNotNull(mts=500);
	}//OK

	@Test
	public void testMontantTotalProduits() {
		double mts = metier.montantTotalProduits(1L);
		assertNotNull(mts==200);
	}//OK

	@Test
	public void testMontantDevis() {
		double mts = metier.montantDevis(1L);
		assertNotNull(mts);
	}//OK

}
