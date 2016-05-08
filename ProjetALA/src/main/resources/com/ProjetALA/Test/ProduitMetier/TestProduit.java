package com.ProjetALA.Test.ProduitMetier;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.ProjetALA.Produit.Metier.InterMetierProduit;
import com.ProjetALA.Produit.entity.Produit;



public class TestProduit {

	private static ClassPathXmlApplicationContext context;
	private static InterMetierProduit metier;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier = (InterMetierProduit)context.getBean("ProduitMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	Produit p1 = new Produit("REPAS", 250d, "petit-dejeuner",2L);
	Produit p2 = new Produit("PISCINE", 400d, "nager",1L);
	
	@Test
	public void testAddProduit() {
		metier.addProduit(p1, 1L);
		metier.addProduit(p2, 1L);
		
		assertNotNull(p1.getIdProduit());
		
	}

	@Test
	public void testDeleteProduit() {
		metier.deleteProduit(2L);
		assertNull(metier.getProduit(2L));
	}

	@Test
	public void testMergeProduit() {
		p1.setPrixProduit(300d);
		metier.mergeProduit(p1.getIdProduit());
		assertTrue(p1.getPrixProduit()>0);
	}

	@Test
	public void testGetProduit() {
		Produit p3= metier.getProduit(1L);
		assertNotNull(p3.getIdProduit());
	}

	@Test
	public void testGetListProduit() {
		assertTrue(metier.getListProduit().size()>0);
	}

	@Test
	public void testGetListProduit_Devis() {
		assertTrue(metier.getListProduit_Devis(1L).size()>0);
	}

	@Test
	public void testGetListProduit_mc() {
		assertTrue(metier.getListProduit_mc("R").size()>0);
	}

}
