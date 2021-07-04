package prasun.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import prasun.banking.dao.model.DepositSchemeModel;

public interface DepositDAO extends JpaRepository<DepositSchemeModel, String>{

}
