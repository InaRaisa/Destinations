package palvelinohjelmointi.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller handles requests and returns the name of the View

@Controller
public class HomeController {
	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello Destinations!";
	}
}
