package palvelinohjelmointi.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.access.prepost.PreAuthorize;

import palvelinohjelmointi.domain.ContinentRepository;
import palvelinohjelmointi.domain.Destination;
import palvelinohjelmointi.domain.DestinationRepository;


@Controller
public class DestinationsController {
	@Autowired
	private DestinationRepository repository;
	
	@Autowired
	private ContinentRepository crepository;
	
		// Show index page
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
		// Show all destinations
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
		// Show all destinations
	@RequestMapping(value="/destinationList")
	public String destinationList(Model model) {
		model.addAttribute("destinations", repository.findAll());
		return "destinationList";
	}
		
		// RESTful service to get all destinations
	@RequestMapping(value = "/destinations")
	public @ResponseBody List<Destination> destinationListRest() {
		return (List<Destination>) repository.findAll();
	}
		
		// RESTful service to get a destination by id
	@RequestMapping(value="/destination/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Destination> findDestinationRest(@PathVariable("id") Long id) {
		return repository.findById(id);
}

		// Add new destination
	@RequestMapping(value = "/addDestination")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addDestination(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("continents", crepository.findAll());
		return "addDestination";
	}

		// Save new destination
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Destination destination) {
		repository.save(destination);
		return "redirect:destinationList";
	}
	
		// Delete destination
		// Read the destination id from the path variable
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteDestination(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../destinationList";
	}
	
	// Edit destination
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editDestination(@PathVariable("id") Long id, Model model) {
		model.addAttribute("destination", repository.findById(id));
		model.addAttribute("continents", crepository.findAll());
		return "redirect:destinationList";
    }
	
}