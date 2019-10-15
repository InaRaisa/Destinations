package palvelinohjelmointi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import palvelinohjelmointi.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// all users are allowed to go to the index page
		.authorizeRequests().antMatchers("/index").permitAll()
		// only admin users are allowed to go to pages under /admin dir
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		//all other requests must be authenticated
		.anyRequest().authenticated()
	.and()
	.formLogin()
		.loginPage("/login")
		// where to go after a successful login
		.defaultSuccessUrl("/index")
		.permitAll()
	.and()
	.logout().permitAll();
}
	
	// Spring Security will automatically encrypt the password using BCrypt
   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}