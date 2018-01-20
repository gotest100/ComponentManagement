package masterSpringMvc.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import masterSpringMvc.services.TweetService;

@Controller
public class HomeController {
	@Autowired
	TweetService service;
	
	@RequestMapping("/")
	public String Search() {
		return "searchPage";
	}

	@RequestMapping("/result")
	public String Hello(@RequestParam(defaultValue = "") String search, Model model) {		
		//List<Tweet> allList = service.getTweeters();
		List<Tweet> filteredList = service.getTweeters();
		
		if(search.length() > 2) {
			filteredList = filteredList.stream().filter(p -> p.getFromUser().toLowerCase().equals(search.toLowerCase()) || p.getText().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
		}
		
		model.addAttribute("tweets", filteredList);
		//return "resultPage";
		return "resultWithLayout";
	}
}
