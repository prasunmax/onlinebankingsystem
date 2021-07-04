package prasun.banking.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import prasun.banking.dao.model.AccountModel;

@Component
public class AccountToUserDetails implements Converter<AccountModel, UserDetails> {
    @Override
    public UserDetails convert(AccountModel account) {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        if (account != null) {
            userDetails.setFirstName(account.getFirst_name());
            userDetails.setLastName(account.getLast_name());
            userDetails.setPassword(account.getEncryptedPassword());
            userDetails.setEnabled(account.getEnabled());
            userDetails.setUsername(account.getUsername()); 
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            account.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            userDetails.setAuthorities(authorities);
        }
        return userDetails;
    }
}