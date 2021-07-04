package prasun.banking.controller;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prasun.banking.dto.UpdateProfileDTO;
import prasun.banking.dto.ProfileDTO;
import prasun.banking.security.UserDetailsImpl;
import prasun.banking.service.AccountService;

@Controller
public class ProfileController {

	AccountService accountService;

	@Autowired
	public ProfileController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model, Principal principal)
			throws IllegalAccessException, InvocationTargetException {
		if (null == principal) {
			return "redirect:/login";
		}
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal)
				.getPrincipal();
		if (StringUtils.isBlank(userDetailsImpl.getUsername())) {
			return "redirect:/login";
		}
		ProfileDTO profile = accountService.getByUsername(userDetailsImpl.getUsername());
		model.addAttribute("profile", profile);
		return "profile";
	}

	@RequestMapping(value = "/update-profile", method = RequestMethod.GET)
	public String showChangePage(ModelMap model, Principal principal)
			throws IllegalAccessException, InvocationTargetException {
		if (null == principal) {
			return "redirect:/login";
		}
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal)
				.getPrincipal();
		if (StringUtils.isBlank(userDetailsImpl.getUsername())) {
			return "redirect:/login";
		}
		UpdateProfileDTO changepassDTO = new UpdateProfileDTO();
		ProfileDTO profile = accountService.getByUsername(userDetailsImpl.getUsername());
		BeanUtils.copyProperties(changepassDTO, profile);
		model.addAttribute("profile", changepassDTO);
		return "update-profile";
	}

	@RequestMapping(value = "/update-profile", method = RequestMethod.POST)
	public String doChangePage(ModelMap model, Principal principal, @Valid UpdateProfileDTO profile,
			BindingResult result) throws IllegalAccessException, InvocationTargetException {
		if (null == principal) {
			return "redirect:/login";
		}
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal)
				.getPrincipal();
		if (StringUtils.isBlank(userDetailsImpl.getUsername())) {
			return "redirect:/login";
		}
		if (result.hasErrors()) {
			model.addAttribute("profile", profile);
		}
		UpdateProfileDTO newprofile = accountService.updatePassword(profile, userDetailsImpl.getUsername());
		if(null==newprofile) {
			newprofile = new UpdateProfileDTO();
			BeanUtils.copyProperties(newprofile, profile);
			newprofile.setError("error");
		}else {
		newprofile.setError("success");
		}
		newprofile.setCur_pass("");
		newprofile.setPassword("");
		newprofile.setRe_password("");
		model.addAttribute("profile", newprofile);
		return "update-profile";
	}
}
