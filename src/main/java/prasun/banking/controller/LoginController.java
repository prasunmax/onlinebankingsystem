package prasun.banking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prasun.banking.dto.LoginDTO;
import prasun.banking.service.AccountService;

@Controller
public class LoginController {
	AccountService accountService;

	@Autowired
	public LoginController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model, HttpServletRequest request) {
		String referrer = request.getHeader("referer");
		LoginDTO dto = new LoginDTO();
		if(referrer.contains("register")) {
			dto.setSuccess("success");
		}
		model.addAttribute("loginform", dto);
		return "login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String processLoginPage(@Valid @ModelAttribute("loginform") LoginDTO login, BindingResult result,
//			HttpSession ses) {
//		if (result.hasErrors()) {
//			login.setError("");			
//			return "login";
//		}
//		AccountModel user = accountService.validateLogin(login);
//		if (null != user && !StringUtils.isBlank(user.getAccount_no())) {
//			ses.setAttribute("username", user.getUsername());
//			return "redirect:/profile";
//		}
//		login.setError("User is not registered with the system");
//		return "login";
//	}

//	private String getLoggedInUserName() {
//		Object principal = SecurityContextHolder.getContext()
//				.getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails)
//			return ((UserDetails) principal).getUsername();
//
//		return principal.toString();
//	}

}
