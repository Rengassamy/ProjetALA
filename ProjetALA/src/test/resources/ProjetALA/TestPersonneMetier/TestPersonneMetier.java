package ProjetALA.TestPersonneMetier;
/**/
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.PojetALA.Personne.Metier.InterfPersonneMetier;
import com.ProjetALA.Personne.Personne;




public class TestPersonneMetier {
	
	private static ClassPathXmlApplicationContext context;
	private static InterfPersonneMetier metier;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier=(InterfPersonneMetier) context.getBean("PersonneMetier");
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	Personne p3 =new Personne("Rengassamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	Personne p1 =new Personne("Rengassamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	Personne p2 =new Personne("Rengassamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	@Test
	public void testAddPersonne() {
		
		metier.AddPersonne(p2);
		metier.AddPersonne(p1);
		metier.AddPersonne(p3);
		assertNotNull(p1.getIdPersonne());
	}
	
	@Test
	public void testDeletePersonne() {
		
		metier.deletePersonne(p1);
		assertNull(p1.getIdPersonne());
	}

	@Test
	public void testGetListofPersonne() {
		List<Personne> tab=metier.getListofPersonne();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListofPersonneParMc() {
		List<Personne> tab=metier.getListofPersonneParMc("");
		assertTrue(tab.size()>0);
	}

	@Test
	public void testMergePersonne() {	
		metier.mergePersonne(1L);
		assertNull(p3.getIdPersonne());
	}

	@Test
	public void testGetPersonne() {
		fail("Not yet implemented");
	}

}
