package palvelinohjelmointi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.domain.CheckUser;
import palvelinohjelmointi.domain.User;
import palvelinohjelmointi.domain.UserRepository;

//Controller for creating new users to the Destinations application

@Controller
public class UserController {

	// Initialize UserRepository
	@Autowired 
	UserRepository userRepository; 
	
	// Add new user
	@GetMapping("addUser")
	public String addUser(Model model) {
		System.out.println("addUser");
		model.addAttribute("checkUser", new CheckUser());
		return "newUser";
	}
	
	// Save new user in the database
	@PostMapping("saveUser")
	public String saveUser(@Valid @ModelAttribute("checkUser") CheckUser cUser, BindingResult bindingResult) {
    	
		System.out.println("saveUser " + cUser.getPassword() );
		if (!bindingResult.hasErrors()) { // If there are no validation errors, continue
    		if (cUser.getPassword().equals(cUser.getPasswordCheck())) { // Check if passwords match
    			
	    		String pwd = cUser.getPassword();
	    		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(cUser.getUsername());
		    	newUser.setRole(cUser.getRole().toUpperCase());
		    	if (userRepository.findByUsername(cUser.getUsername()) == null) { // Check if username already exists
		    		System.out.println("Username does not exist yet");
		    		userRepository.save(newUser);
		    	}
		    	else {
		    		System.out.println("Username already exists");
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "newUser";		    		
		    	}
    		}
    		else {
    			System.out.println("Passwords do not match");
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");    	
    			return "newUser";
    		}
    	}
    	else {
    		System.out.println("Password is too short");
    		bindingResult.rejectValue("passwordCheck", "err.passCheck", "Password is too short");
    		return "newUser";
    	}
    	return "redirect:/login";    	
    }  

	
	
	//poistetaan käyttäjä - optional
	
	//vaihdetaan salasanaa - optional
	
}
