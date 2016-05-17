package com.ProjetALA.Test.ChambreMetier;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Chambre.Metier.IChambreMetier;

public class TestChambreMetier2 {
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
	public void testGetdispo() {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd");
			List<Chambre> tabc;
				tabc = ChambreMetier.getdispo(sf.parse("2017-01-01"), sf.parse("2017-01-05"), 2);
				assertTrue(tabc.size()>0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
