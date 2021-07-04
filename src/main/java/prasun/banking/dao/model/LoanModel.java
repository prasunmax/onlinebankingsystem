package prasun.banking.dao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Loan")
public class LoanModel {
	@Id
	@GeneratedValue(generator = "custom-generator")
	@GenericGenerator(name = "custom-generator", parameters = @Parameter(name = "prefix", value = "LOAN"), strategy = "prasun.banking.common.CustomGenerator")
	String account_no;
	String first_name;
	String last_name;
	String username;
	String loan_type;
	float rateOfInterest;
	Date loan_date;
	float duration;
	float loan_amount;
	String status;
	Date emi_start_date;
	float emi_amount;

	public Date getEmi_start_date() {
		return emi_start_date;
	}

	public void setEmi_start_date(Date emi_start_date) {
		this.emi_start_date = emi_start_date;
	}

	public float getEmi_amount() {
		return emi_amount;
	}

	public void setEmi_amount(float emi_amount) {
		this.emi_amount = emi_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public float getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(float loan_amount) {
		this.loan_amount = loan_amount;
	}

}
