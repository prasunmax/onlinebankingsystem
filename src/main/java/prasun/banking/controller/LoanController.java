package prasun.banking.controller;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import prasun.banking.dto.LoanDTO;
import prasun.banking.dto.ProfileDTO;
import prasun.banking.dto.ShowLoanDTO;
import prasun.banking.dto.LoansDTO;
import prasun.banking.security.UserDetailsImpl;
import prasun.banking.service.AccountService;
import prasun.banking.service.LoanService;

@Controller
public class LoanController {
	AccountService accountService;
	LoanService loanService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@Autowired
	public LoanController(AccountService accountService, LoanService loanService) {
		this.accountService = accountService;
		this.loanService = loanService;
	}

	@RequestMapping(value = "/loan", method = RequestMethod.GET)
	public String showLoanPage(ModelMap model, Principal principal)
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
		LoanDTO loan = new LoanDTO();
		BeanUtils.copyProperties(loan, profile);
		model.addAttribute("loan", loan);
		return "loan";
	}

	@RequestMapping(value = "/loan", method = RequestMethod.POST)
	public String processLoanPage(ModelMap model, @ModelAttribute("loan") @Valid LoanDTO loan, BindingResult result)
			throws IllegalAccessException, InvocationTargetException {
		if (result.hasErrors()) {
			return "loan";
		}
		if (null == loanService.addLoan(loan)) {
			loan.setError("Error");
			return "loan";
		}
		return "redirect:/profile";
	}

	@RequestMapping(value = "/loans", method = RequestMethod.GET)
	public String showLoans(ModelMap model, Principal principal, ShowLoanDTO loanDto)
			throws IllegalAccessException, InvocationTargetException {
		if (null == principal) {
			return "redirect:/login";
		}
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal)
				.getPrincipal();
		if (StringUtils.isBlank(userDetailsImpl.getUsername())) {
			return "redirect:/login";
		}

		if (null == loanDto.getLoan_type()) {
			loanDto = new ShowLoanDTO();
			loanDto.setLoan_type("Home Loan");
		}
		List<LoansDTO> loan = loanService.getAllLoans(loanDto.getLoan_type());
		loanDto.setLoan(loan);
		model.addAttribute("loan", loanDto);
		return "loan_request";
	}
}
