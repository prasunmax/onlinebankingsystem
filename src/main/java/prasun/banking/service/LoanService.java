package prasun.banking.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prasun.banking.dao.AccountDAO;
import prasun.banking.dao.LoanDAO;
import prasun.banking.dao.model.AccountModel;
import prasun.banking.dao.model.LoanModel;
import prasun.banking.dto.LoanDTO;
import prasun.banking.dto.ProfileDTO;
import prasun.banking.dto.LoansDTO;

@Service
public class LoanService {
	AccountDAO accountDao;
	LoanDAO loanDao;
	AccountService accountService;

	@Autowired
	public LoanService(AccountDAO accountDao, LoanDAO loanDao, AccountService accountService) {
		this.accountDao = accountDao;
		this.loanDao = loanDao;
		this.accountService = accountService;
	}

	public LoanModel addLoan(LoanDTO loanDto) throws IllegalAccessException, InvocationTargetException {
		LoanModel loan = new LoanModel();
		BeanUtils.copyProperties(loan, loanDto);
		ProfileDTO profile = accountService.getByUsername(loanDto.getUsername());
		if (profile.getSalary() * 1.5 < loan.getLoan_amount()) {
			return null;
		}
		loan.setStatus("Active");
		return loanDao.saveAndFlush(loan);
	}

	public ProfileDTO getByUsername(String username) throws IllegalAccessException, InvocationTargetException {
		AccountModel user = accountDao.findByUsername(username);
		if (null == user) {
			return null;
		}
		ProfileDTO profile = new ProfileDTO();
		BeanUtils.copyProperties(profile, user);

		return profile;
	}

	public List<LoansDTO> getAllLoans(String loanTyp) {
		List<LoanModel> allLoans = loanDao.findByLoan_amountGreaterThan(500000, loanTyp);
		List<LoansDTO> loanDTO = allLoans.stream().map(loan -> {
			LoansDTO loandto = new LoansDTO();
			try {
				BeanUtils.copyProperties(loandto, loan);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return loandto;
		}).collect(Collectors.toList());

		return loanDTO;
	}
}
