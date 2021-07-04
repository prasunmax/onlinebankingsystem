package prasun.banking.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prasun.banking.dao.AccountDAO;
import prasun.banking.dao.model.AccountModel;
import prasun.banking.dao.model.Role;
import prasun.banking.dto.UpdateProfileDTO;
import prasun.banking.dto.ProfileDTO;
import prasun.banking.dto.RegistrationDTO;

@Service
public class AccountService {
	AccountDAO accountDao;
	RoleService roleService;
	@Autowired
	EncryptionService encryptionService;

	@Autowired
	public AccountService(AccountDAO accountDao, RoleService roleService) {
		this.accountDao = accountDao;
		this.roleService = roleService;
	}

	public ProfileDTO addUser(RegistrationDTO register) throws IllegalAccessException, InvocationTargetException {

		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setRole("ROLE_USER");
		roles.add(role);

		roles = roleService.saveAll(roles);

		AccountModel user = new AccountModel();

		BeanUtils.copyProperties(user, register);
		
		if (null != accountDao.findByUsername(user.getUsername())) {
			return null;
		}
		
		
		user.setRoles(roles);
		if(null != user.getPassword()){
			user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
		}
		
		user.setReg_date(new Date());
		ProfileDTO profile = new ProfileDTO();
		BeanUtils.copyProperties(profile, accountDao.saveAndFlush(user));

		return profile;
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

	public UpdateProfileDTO updatePassword(UpdateProfileDTO profile, String username) {
		AccountModel user = accountDao.findByUsername(username);
		if(!encryptionService.encryptString(profile.getCur_pass()).equals(user.getEncryptedPassword())) {
			return null;
		}
		if(null != profile.getPassword()){
			user.setEncryptedPassword(encryptionService.encryptString(profile.getPassword()));
		}
		user.setFirst_name(profile.getFirst_name());
		user.setLast_name(profile.getLast_name());
		user.setEmail(profile.getEmail());
		user = accountDao.saveAndFlush(user);
		return profile;
	}

	public AccountModel findByUsername(String username) {
		return accountDao.findByUsername(username);
	}
}
