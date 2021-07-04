package prasun.banking.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class ShowLoanDTO {
	@NotBlank(message = "May not be Blanks!!")
	private String loan_type;
	private List<LoansDTO> loan;

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public List<LoansDTO> getLoan() {
		return loan;
	}

	public void setLoan(List<LoansDTO> loan) {
		this.loan = loan;
	}

}
