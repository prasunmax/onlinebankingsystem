package prasun.banking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import prasun.banking.dao.model.AccountModel;
import prasun.banking.service.AccountService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountservice;

    @Autowired
    @Qualifier(value = "accountToUserDetails")
    private Converter<AccountModel, UserDetails> accountUserDetailsConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountUserDetailsConverter.convert(accountservice.findByUsername(username));
    }
}
