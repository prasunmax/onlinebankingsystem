package prasun.banking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import prasun.banking.dao.model.LoanModel;

public interface LoanDAO extends JpaRepository<LoanModel, String> {

	@Query(value = "SELECT * FROM Loan WHERE loan_amount>?1 and loan_type=?2 ORDER BY username DESC", nativeQuery = true)
	List<LoanModel> findByLoan_amountGreaterThan(float i,String loanTyp);

}
