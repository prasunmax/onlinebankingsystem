package prasun.banking.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prasun.banking.dao.RoleRepository;
import prasun.banking.dao.model.Role;

@Service
public class RoleService {

	private RoleRepository repo;

	@Autowired
	public RoleService(RoleRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Role> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Role save(Role user) {
		return repo.save(user);
	}

	public List<Role> saveAll(List<Role> roles) {
		return repo.saveAll(roles);
		
	}

}
