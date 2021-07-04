package prasun.banking.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginDTO {
	@NotNull(message = "May not be Null!!")
	@NotBlank(message = "May not be Blanks!!")
	@Digits(fraction = 0, integer = 9, message = "User Name should be of 9 digit number, Please try again")
	private String username;
	
	@NotNull(message = "May not be Null!!")
	@NotBlank(message = "May not be Blanks!!")
	private String password;
	
	private String error;
	
	private String success;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
