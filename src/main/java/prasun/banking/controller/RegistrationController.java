package prasun.banking.controller;

import java.lang.reflect.InvocationTargetException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prasun.banking.dto.ProfileDTO;
import prasun.banking.dto.RegistrationDTO;
import prasun.banking.service.AccountService;

@Controller
public class RegistrationController {
	AccountService accountService;
	@Autowired
	public RegistrationController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.addAttribute("registrationForm", new RegistrationDTO());
		return "create_account";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processLoginPage(ModelMap model, @ModelAttribute("registrationForm") @Valid RegistrationDTO register,
			BindingResult result) throws IllegalAccessException, InvocationTargetException {
		if (result.hasErrors()) {
			return "create_account";
		}
		ProfileDTO profile = accountService.addUser(register);
		if(null==profile) {
			return "create_account";
		}
		return "redirect:/login";
	}
}
