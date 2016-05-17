package ProjetALA.TestEmployerMetier;
/**/
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ProjetALA.Employer.Employer;
import com.ProjetALA.Employer.Metier.InterfEmployerMetier;


public class TestEmployerMetier {
	private static ClassPathXmlApplicationContext context;
	private static InterfEmployerMetier metier;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metier=(InterfEmployerMetier) context.getBean("EmloyerMetier");
	}
	Employer e3 =new Employer("Renssamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	Employer e1 =new Employer("Regassamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	Employer e2 =new Employer("Rengasamy","Alex","M",new Date(17/9/1988),"Stains","0621729076","alexstains@hotmail.fr");
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddEmployer() {
		metier.AddEmployer(e2);
		metier.AddEmployer(e1);
		metier.AddEmployer(e3);
		assertNotNull(e1.getIdPersonne());
		
	}

	@Test
	public void testDeleteEmployer() {
		metier.deleteEmployer(1L);
		assertNull(e1.getIdPersonne());
	}

	@Test
	public void testGetListofEmployer() {
		List<Employer> tab=metier.getListofEmployer();
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetListofEmployerParMc() {
		List<Employer> tab=metier.getListofEmployerParMc("");
		assertTrue(tab.size()>0);
	}

	@Test
	public void testGetEmployer() {
		fail("Not yet implemented");
	}

	@Test
	public void testMergeEmployer() {
		metier.mergeEmployer(1L);
		assertNull(e3.getIdPersonne());
	}

}
