package prasun.banking.dto;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoansDTO {

	@NotBlank(message = "May not be Blanks!!")
	String first_name;

	@NotBlank(message = "May not be Blanks!!")
	String last_name;

	@NotBlank(message = "May not be Blanks!!")
	String loan_type;

	@NotNull(message = "Should enter a value")
	Float loan_amount;

	@NotBlank(message = "May not be Blanks!!")
	@Digits(fraction = 0, integer = 9, message = "User Name should be of 9 digit number, Please try again")
	String username;

	@NotNull(message = "Should enter a value")
	Float rateOfInterest;

	@NotNull(message = "Should enter a value")
	Float duration;

	@NotNull(message = "Should enter a value")
	Date loan_date;

	@NotNull(message = "Should enter a value")
	String account_no;

	@NotNull(message = "Should enter a value")
	String email;

	@NotNull(message = "Should enter a value")
	String address;

	String error;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public Float getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(Float loan_amount) {
		this.loan_amount = loan_amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

}