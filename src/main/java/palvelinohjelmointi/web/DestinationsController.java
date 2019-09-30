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
	
		// Show all destinations
	@RequestMapping(value="/destinationlist", method = RequestMethod.GET)
	public String DestinationList(Model model) {
		model.addAttribute("destinations", repository.findAll());
		return "destinationlist";
	}
		
		// RESTful service to get all destinations
	@RequestMapping(value = "/destinations", method = RequestMethod.GET)
	public @ResponseBody List<Destination> destinationListRest() {
		return (List<Destination>) repository.findAll();
	}
		
		// RESTful service to get destination by id
	@RequestMapping(value="/destination/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Destination> findDestinationRest(@PathVariable("id") Long destinationId) {
		return repository.findById(destinationId);
}

		// Add new destination
	@RequestMapping(value = "/add")
	@PreAuthorize("hasRole('ADMIN')")
	public String addDestination(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("continent", crepository.findAll());
		return "addDestination";
	}

		// Save new destination
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Destination destination) {
		repository.save(destination);
		return "redirect:destinationlist";
	}
	
		// Delete destination
		// Read the destination id from the path variable
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteDestination(@PathVariable("id") Long destinationId, Model model) {
		repository.deleteById(destinationId);
		return "redirect:../destinationlist";
	}

	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String editDestination(@PathVariable("id") Long destinationId, Model model) {
		model.addAttribute("destination", repository.findById(destinationId));
		model.addAttribute("continent", crepository.findAll());
		return "editdestination";
	}
	
    @RequestMapping(value="/login")
    public String login() {
    	return "login";
    }
}