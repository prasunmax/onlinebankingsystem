package prasun.banking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import prasun.banking.common.validation.FieldMatch;
@FieldMatch.List({ @FieldMatch(first = "password", second = "re_password", message = "The password fields must match")

})
public class UpdateProfileDTO {
	String cur_pass;
	String password;
	String re_password;
	
	@NotBlank(message = "May not be Blanks!!")
	String first_name;

	@NotBlank(message = "May not be Blanks!!")
	String last_name;
	
	@NotBlank(message = "May not be Blanks!!")
	@Email(message = "Should be an email !!")
	String email;

	
	String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCur_pass() {
		return cur_pass;
	}

	public void setCur_pass(String cur_pass) {
		this.cur_pass = cur_pass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRe_password() {
		return re_password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
