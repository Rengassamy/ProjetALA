package com.ProjetALA.Test.FactureMetier;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.ProjetALA.Facture.Metier.InterMetierFacture;
import com.ProjetALA.Facture.entity.Facture;



public class TestFacture {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierFacture metier;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterMetierFacture)context.getBean("FactureMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	Facture f1 = new Facture(new Date(), "Carte bleu");
	Facture f2 = new Facture(new Date(), "Cheque");
	Facture f3 = new Facture(new Date(), "Espèce");
	
	@Test
	public void testAddFacture() {
		metier.addFacture(f1, 1L);
		metier.addFacture(f2, 1L);
		metier.addFacture(f3, 1L);
	
		assertNotNull(f1.getIdFacture());
		
	}

	@Test
	public void testDeleteFacture() {

		metier.deleteFacture(2L);
		assertNull(metier.getFacture(2L));
	}

	@Test
	public void testMergeFacture() {
		f2.setTypePaiement("Chèque");
		metier.mergeFacture(1L);
		assertTrue(f2.getTypePaiement() == "Chèque" );
	}

	@Test
	public void testGetFacture() {
		assertNotNull(metier.getFacture(1L).getIdFacture());
	}

	@Test
	public void testGetListFacture() {
		assertTrue(metier.getListFacture().size()>0);
	}

}
