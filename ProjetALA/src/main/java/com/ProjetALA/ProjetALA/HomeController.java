package com.ProjetALA.ProjetALA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ProjetALA.Chambre.Chambre;
import com.ProjetALA.Chambre.Metier.IChambreMetier;
import com.ProjetALA.Client.Client;
import com.ProjetALA.Client.Metier.InterfClientMetier;
import com.ProjetALA.Employer.Employer;
import com.ProjetALA.Employer.Metier.InterfEmployerMetier;
import com.ProjetALA.Reservation.Reservation;
import com.ProjetALA.Reservation.Metier.IReservationMetier;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private IChambreMetier ChambreMetier;
	@Autowired
	private IReservationMetier ReservationMetier;
	@Autowired
	private InterfClientMetier ClientMetier;
	@Autowired 
	private InterfEmployerMetier EmployeMetier;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home2(Model model) {
		
		return "home";
	}
	/************************************** Partie Reservation ****************************************/
	/************************************** Partie Reservation ****************************************/
	/************************************** Partie Reservation ****************************************/
	/* Affichage des r�servations */
	@RequestMapping(value = "/GestionReservation", method = RequestMethod.GET)
	public String homeresa(Model model) {
        model.addAttribute("EntityReservation", ReservationMetier.getListReservation());
        model.addAttribute("EntityChambre", ChambreMetier.getListChambre());
        model.addAttribute("EntityClient", ClientMetier.getListofClient());
        model.addAttribute("EntityEmploye", EmployeMetier.getListofEmployer());
        model.addAttribute("model", new Reservation());
		return "Reservation";
	}
	/*Affichage des r�servations appartenant � un client */
	@RequestMapping(value = "/getresabyclient", method = RequestMethod.GET)
	public String resabyclient(Model model, Long idClient) {
        model.addAttribute("EntityReservationbyCli", ReservationMetier.getListReservationClient(idClient));
        model.addAttribute("EntityReservation", ReservationMetier.getListReservation());
        model.addAttribute("EntityClient", ClientMetier.getListofClient());
        model.addAttribute("EntityEmploye", EmployeMetier.getListofEmployer());
		return "Reservation";
	}
	/*Affichage des r�servations faite par un employe */
	@RequestMapping(value = "/getresabyemploye", method = RequestMethod.GET)
	public String resabyemploye(Model model, Long idEmploye) {
        model.addAttribute("EntityReservationbyEmp", ReservationMetier.getListReservationEmploye(idEmploye));
        model.addAttribute("EntityReservation", ReservationMetier.getListReservation());
        model.addAttribute("EntityClient", ClientMetier.getListofClient());
        model.addAttribute("EntityEmploye", EmployeMetier.getListofEmployer());
		return "Reservation";
	}
	/*Affichage des r�servations d'une chambre */
	@RequestMapping(value = "/getresabychambre", method = RequestMethod.GET)
	public String resabychambre(Model model, Long idChambre) {
        model.addAttribute("EntityReservationbyCha", ReservationMetier.getListReservationChambre(idChambre));
        model.addAttribute("EntityReservation", ReservationMetier.getListReservation());
        model.addAttribute("EntityClient", ClientMetier.getListofClient());
        model.addAttribute("EntityEmploye", EmployeMetier.getListofEmployer());
		return "Reservation";
	}
	/* Ajout d'une r�servation */
	@RequestMapping(value="/insertreservation",method= RequestMethod.GET)
	public String addreservation(@ModelAttribute("model") @Valid Reservation r, Long idClient, Long idEmploye,
			Long idChambre, BindingResult resultat){
		if (resultat.hasErrors()){
			
			return "redirect:GestionReservation";
		}
		Chambre c = ChambreMetier.getChambre(idChambre);
		List<Chambre> tabC = new ArrayList<Chambre>();
		tabC.add(c);
		ReservationMetier.addReservation(r, idClient, idEmploye, tabC);
		return "redirect:GestionReservation";
	}
	/*Suppression d'une r�servation */
	@RequestMapping(value="/deletereservation", method = RequestMethod.GET)
	public String deleteChambre(Model model, Long idReservation){
		ReservationMetier.deleteReservation(idReservation);
		   model.addAttribute("EntityReservation", ReservationMetier.getListReservation());
		return "redirect:GestionReservation";
	}
	/************************************** Partie Chambre ****************************************/
	/************************************** Partie Chambre ****************************************/
	/************************************** Partie Chambre ****************************************/
	/* affichage de la liste des chambres */
	@RequestMapping(value = "/GestionChambre", method = RequestMethod.GET)
	public String homechambre(Model model) {
	 	model.addAttribute("EntityChambre", ChambreMetier.getListChambre());
	 	model.addAttribute("model", new Chambre());
		return "Chambre";
	}
	/* ajout d'une chambre */
	@RequestMapping(value = "/insertchambre", method = RequestMethod.GET)
	public String insertchambre(@ModelAttribute("model") @Valid Chambre c, BindingResult resultat) {
		if(resultat.hasErrors()){
			return "redirect:GestionChambre";
		}
		ChambreMetier.addChambre(c);
	 	ChambreMetier.getListChambre();
		return "redirect:GestionChambre";
	}
	/* Suppression d'une chambre */
	@RequestMapping(value="/deletechambre", method = RequestMethod.GET)
	public String deletechambre(Model model, Long idChambre){
		ChambreMetier.deleteChambre(idChambre);
		model.addAttribute("EntityChambre", ChambreMetier.getListChambre());
		return "redirect:GestionChambre";
	}
	/* Recherche de la disponibilit� d'une chambre */
	@RequestMapping(value="/getdispochambre", method= RequestMethod.GET)
	public String getdispochambre(Model model, Date datedeb, Date datefin, Integer nbrepers){
		try {
/*		   SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd");
			Date Ddeb = sf.parse(datedeb);
			Date Dfin = sf.parse(datefin);*/
			model.addAttribute("DispoChambre", ChambreMetier.getdispo(datedeb, datefin, nbrepers));
		} catch (Exception e) {
			Chambre C = new Chambre();
			C.setException(e.getMessage());
			model.addAttribute("exc", C);
		}
		return "redirect:GestionChambre";
	}
	/* Partie Facture */
	@RequestMapping(value = "/GestionFacture", method = RequestMethod.GET)
	public String homefacture(Model model) {
		
		return "Facture";
	}
	
	
	/************************************** Partie Client ****************************************/
	/************************************** Partie Client ****************************************/
	/************************************** Partie Client ****************************************/
	
	@RequestMapping(value = "/GestionClient", method = RequestMethod.GET)
	/* Affichage des clients */
	public String homeClient(Model model) {
        model.addAttribute("EntityClient", ClientMetier.getListofClient());
        model.addAttribute("EntityEmployer", EmployeMetier.getListofEmployer());
        model.addAttribute("model", new Client());
		return "Client";
	}
	/* ajout d'un client */
	@RequestMapping(value = "/insertclient", method = RequestMethod.GET)
	public String insertclient (@ModelAttribute("model") @Valid Client c, BindingResult resultat) {
		if(resultat.hasErrors()){
			return "errorClient";
		}
		ClientMetier.AjouterClient(c);
	 	ClientMetier.getListofClient();
		return "redirect:GestionClient";
	}
	/* Suppression d'un client */
	@RequestMapping(value="/deleteclient", method = RequestMethod.GET)
	public String deleteclient(Model model, Long idClient){
		ClientMetier.deleteClient(idClient);
		model.addAttribute("EntityClient", ClientMetier.getListofClient());
		return "redirect:GestionClient";
	}
	
	
	/************************************** Partie Employer ****************************************/
	/************************************** Partie Employer ****************************************/
	/************************************** Partie Employer ****************************************/
	
	@RequestMapping(value = "/GestionEmployer", method = RequestMethod.GET)
	/* Affichage des employer */
	public String homeEmployer(Model model) {
        model.addAttribute("EntityReservation", ReservationMetier.getListReservation());
        model.addAttribute("EntityChambre", ChambreMetier.getListChambre());
        model.addAttribute("EntityClient", ClientMetier.getListofClient());
        model.addAttribute("EntityEmployer", EmployeMetier.getListofEmployer());
        model.addAttribute("model", new Employer());
		return "Client";
	}
	/* ajout d'un employer */
	@RequestMapping(value = "/insertemployer", method = RequestMethod.GET)
	public String insertemployer (Model model, Employer e) {
		EmployeMetier.AddEmployer(e);
	 	model.addAttribute("EntityEmployer",EmployeMetier.getListofEmployer());
		return "redirect:GestionEmployer";
	}
	/* Suppression d'un employer */
	@RequestMapping(value="/deleteemployer", method = RequestMethod.GET)
	public String deleteemployer(Model model, Long idEmployer){
		EmployeMetier.deleteEmployer(idEmployer);
		model.addAttribute("EntityEmployer", EmployeMetier.getListofEmployer());
		return "redirect:GestionEmployer";
	}

}
