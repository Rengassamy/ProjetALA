package com.ProjetALA.Chambre.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Chambre.Metier.IChambreMetier;

@RestController
public class ServiceChambre {
	@Autowired
	private IChambreMetier ChambreMetier;
	
	@RequestMapping(value="/getlistchambre", method=RequestMethod.GET)
	public List<Chambre> getlistchambre(){
		return ChambreMetier.getListChambre();
	}
}
