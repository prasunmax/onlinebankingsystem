package prasun.banking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("daoAuthenticationProvider")
	private AuthenticationProvider authenticationProvider;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("prasun").password("dummy")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login*").permitAll()
        .antMatchers("/register*").permitAll()
        .antMatchers("/image/**").permitAll()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/").permitAll()
        .antMatchers("/index*").permitAll()
        .antMatchers("/flight*").permitAll()
        .antMatchers("/rest/flight*/**").permitAll()
        .antMatchers("/checkin*").permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/profile", true)
        //.failureUrl("/login.html?error=true")
        .failureHandler(authenticationFailureHandler())
        .and()
        .logout()
        .logoutUrl("/logout")
        .deleteCookies("JSESSIONID")
        .logoutSuccessHandler(logoutSuccessHandler())
        .and()
        //.exceptionHandling().accessDeniedPage("/accessDenied")
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
	}

	@Bean
	public static LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}

	@Bean
	public static AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public static AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//This is to handle after logout if the broser is not closed
	@Bean
	private static AuthenticationEntryPoint authenticationEntryPoint() {
		return new MyBasicAuthenticationEntryPoint();
	}

	@Bean("daoAuthenticationProvider")
	public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}
}
