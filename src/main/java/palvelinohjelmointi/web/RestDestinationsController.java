package palvelinohjelmointi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import palvelinohjelmointi.domain.ContinentRepository;
import palvelinohjelmointi.domain.Destination;
import palvelinohjelmointi.domain.DestinationRepository;

@RestController
public class RestDestinationsController {
	// inject DestinationRepository interface to be used by DestinationController class
	@Autowired
	private DestinationRepository destinationRepository;
	@Autowired
	private ContinentRepository continentRepository;

	@RequestMapping(value="destinations", method = RequestMethod.GET)
	public List<Destination> destinationListRest() {
		return (List<Destination>) destinationRepository.findAll();
	}

	
	// Add a new destination into the database
	@RequestMapping(value="destinations", method = RequestMethod.POST)
	public List<Destination> saveDestination(@RequestBody Destination destination) {
		destinationRepository.save(destination);
		return (List<Destination>) destinationRepository.findAll();
	}
}
