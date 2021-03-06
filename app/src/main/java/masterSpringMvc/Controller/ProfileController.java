package masterSpringMvc.Controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import date.PingAnLocalDateFormatter;
import masterSpringMvc.Model.ProfileModel;

@Controller
public class ProfileController {

	@RequestMapping("/profile")
	public String CreateProfile(ProfileModel profileModel) {
		return "profile/create";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST, params = {"save"})
	public String SaveProfile(HttpServletRequest request, RedirectAttributes attr, @Valid ProfileModel profileModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/profile/create";
		}
		else {
			attr.addFlashAttribute("saveInfo", String.format("Save profile: %s", profileModel.getEmail()));
		}
		
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/profile", params = {"addTaste"})
	public String addRow(ProfileModel profileModel) {
		profileModel.getTastes().add(null);
		return "profile/create";
	}
	@RequestMapping(value = "/profile", params = {"removeTaste"})
	public String removeRow(ProfileModel profileModel, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.
		getParameter("removeTaste"));
		profileModel.getTastes().remove(rowId.intValue());
		return "profile/create";
	}
	
	@ModelAttribute("localDateFormat")
	public String localeDateFormat(Locale locale) {
		return PingAnLocalDateFormatter.getPattern(locale);			
	}
	
}
