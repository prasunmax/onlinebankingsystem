package prasun.banking.dao.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Deposit")
public class DepositSchemeModel {
	@Id
	String account_no;
	Date deposit_date;
	String value;
	int year, interest_rate, amount;

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(int interest_rate) {
		this.interest_rate = interest_rate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDeposit_date() {
		return deposit_date;
	}

	public void setDeposit_date(Date deposit_date) {
		this.deposit_date = deposit_date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
