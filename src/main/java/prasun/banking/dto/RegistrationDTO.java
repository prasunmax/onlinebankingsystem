package prasun.banking.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import prasun.banking.common.validation.FieldMatch;

@FieldMatch.List({ @FieldMatch(first = "password", second = "re_password", message = "The password fields must match")

})
public class RegistrationDTO {

	@NotBlank(message = "May not be Blanks!!")
	String first_name;

	@NotBlank(message = "May not be Blanks!!")
	String last_name;

	@NotBlank(message = "May not be Blanks!!")
	String address;

	@NotBlank(message = "May not be Blanks!!")
	String city;

	@NotBlank(message = "May not be Blanks!!")
	String branch;

	@NotBlank(message = "May not be Blanks!!")
	String zip;

	@NotBlank(message = "May not be Blanks!!")
	String password;

	@NotBlank(message = "May not be Blanks!!")
	String phone_number;

	@NotBlank(message = "May not be Blanks!!")
	@Email(message = "Should be an email !!")
	String email;

	@NotBlank(message = "May not be Blanks!!")
	String account_type;

	@NotBlank(message = "May not be Blanks!!")
	String re_password;

	@NotNull(message = "Should enter a value")
	Float amount;

	@NotBlank(message = "May not be Blanks!!")
	@Digits(fraction = 0, integer = 9, message = "User Name should be of 9 digit number, Please try again")
	String username;

	@NotBlank(message = "May not be Blanks!!")
	@Size(min = 10, max = 10, message = "Pan number should be of 10 characters")
	String pan;

	@NotNull(message = "Should enter a value")
	float salary;
	
	String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getPan() {
		return null != pan ? pan.toUpperCase() : pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRe_password() {
		return re_password;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public void setRe_password(String re_password) {
		this.re_password = re_password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
}
