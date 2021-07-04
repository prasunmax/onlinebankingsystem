package prasun.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
	private PasswordEncoder  strongEncryptor; 
	/*
	* Using concrete class instead of interface will give bean of type 
	* 'org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder' that could not be found.
	*/

	@Autowired
	public EncryptionService(PasswordEncoder strongEncryptor) {
		super();
		this.strongEncryptor = strongEncryptor;
	}

	public String encryptString(String input) {
		return strongEncryptor.encode(input);
	}

	public boolean checkPassword(String plainPassword, String encryptedPassword) {
		return strongEncryptor.matches(plainPassword, encryptedPassword);
	}
}