package prasun.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import prasun.banking.dao.model.AccountModel;

public interface AccountDAO extends JpaRepository<AccountModel, String>{
	AccountModel findByUsername(String userName);

}
