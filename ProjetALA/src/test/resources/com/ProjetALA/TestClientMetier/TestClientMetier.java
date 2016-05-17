package com.ProjetALA.TestClientMetier;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**/








import com.ProjetALA.Client.Client;
import com.ProjetALA.Client.Metier.InterfClientMetier;





public class TestClientMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfClientMetier metier;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier=(InterfClientMetier) context.getBean("ClientMetier");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	
	Client c3 =new Client("Renssamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	Client c1 =new Client("Regassamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	Client c2 =new Client("Rengasamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	@Test
	public void testAjouterClient() {
		metier.AjouterClient(c2);
		metier.AjouterClient(c1);
		metier.AjouterClient(c3);
		assertNotNull(c1.getIdPersonne());
	}

	@Test
	public void testDeleteClient() {
		metier.deleteClient(1L);
		assertNull(c1.getIdPersonne());
	}

	@Test
	public void testGetListofClient() {
		List<Client> tab=metier.getListofClient();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListofClientParMc() {
		List<Client> tab=metier.getListofClientParMc("");
		assertTrue(tab.size()>0);
	}

	@Test
	public void testMergeClient() {
		metier.mergeClient(1L);
		assertNull(c3.getIdPersonne());
	}

	@Test
	public void testGetClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClientParReservation() {
		Client c=metier.getClientParReservation(1L);
		assertNotNull(c.getIdPersonne());
	}

}
