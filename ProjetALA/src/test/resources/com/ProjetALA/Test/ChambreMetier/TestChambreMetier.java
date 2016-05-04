package com.ProjetALA.Test.ChambreMetier;
/*Auteur: Arnaud MARY
 * nom Projet: ProjetALA
 *date : 03/05/2016
 *Package: com.ProjetALA.Test.ChambreMetier
 *Class: TestChambreMetier
 *version:1.0
 *ref-UML: 5
 *sprint:1
 *ref-userStories: 2
 * JUNIT de Test du metier Chambre
 * 
 * */

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Chambre.Metier.IChambreMetier;

public class TestChambreMetier {
	
	private static ClassPathXmlApplicationContext context;
	private static IChambreMetier ChambreMetier;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ChambreMetier = (IChambreMetier) context.getBean("ChambreMetier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddChambre() {
		Chambre c = new Chambre("145", 4, 15.5, "Chambre avec 2 lits King size avec vue directe sur le parking");
		ChambreMetier.addChambre(c);
		assertNotNull(c.getIdChambre());
	}

	@Test
	public void testMergeChambre() {
		Chambre c = new Chambre("2FE", 2, 150.0, "Suite princière de 80m² avec vue sur l'Estérel");
		ChambreMetier.addChambre(c);
		c.setCapacite(12);
		c.setNumchambre("XXXX");
		ChambreMetier.mergeChambre(c.getIdChambre());
		assertTrue(c.getCapacite()==12);
		assertTrue(c.getNumchambre()=="XXXX");
	}

	@Test
	public void testDeleteChambre() {
	    List<Chambre> listChamb = ChambreMetier.getListChambre();
		Integer taille = listChamb.size();
		ChambreMetier.deleteChambre(2L);
		List<Chambre> listChambre = ChambreMetier.getListChambre();
		Integer taille2 = listChambre.size();
		assertTrue(taille == (taille2 +1));
	}

	@Test
	public void testGetChambre() {
	    Chambre C =ChambreMetier.getChambre(3L);
		assertNotNull(C.getDescription());
	}

	@Test
	public void testGetListChambre() {
	    List<Chambre> tab =ChambreMetier.getListChambre();
		assertTrue(tab.size()>0);
	}

}
