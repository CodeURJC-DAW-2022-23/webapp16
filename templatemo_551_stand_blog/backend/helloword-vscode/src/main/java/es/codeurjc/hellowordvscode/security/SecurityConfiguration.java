package es.codeurjc.hellowordvscode.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   
   @Value("${security.user}")
   private String user;
   
   @Value("${security.encodedPassword}")
   private String encodedPassword;
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      PasswordEncoderFactories.createDelegatingPasswordEncoder();
      auth.inMemoryAuthentication().withUser(user).password("{bcrypt}"+encodedPassword).roles("USER");
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception { 
 
      // Security configuration
      // Public pages
       http.authorizeRequests().antMatchers("/index").permitAll();
       http.authorizeRequests().antMatchers("/login").permitAll();
       http.authorizeRequests().antMatchers("/loginerror").permitAll();
       http.authorizeRequests().antMatchers("/logout").permitAll(); 
       http.authorizeRequests().antMatchers("/destino").permitAll(); 
       http.authorizeRequests().antMatchers("/destino/{{name}}").permitAll(); 

       
      
       // Private pages (all other pages)
       http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
       http.authorizeRequests().antMatchers("/personalArea").hasAnyRole("USER");
      
       //Login form
       http.formLogin().loginPage("/login");
       http.formLogin().usernameParameter("username");
       http.formLogin().passwordParameter("password");
       http.formLogin().defaultSuccessUrl("/index");
       http.formLogin().failureUrl("/loginerror");
      
      //Logout
      http.logout().logoutUrl("/logout");
      http.logout().logoutSuccessUrl("/index");
      


      // Disable CSRF at the mome
      // http.csrf().disable(); 
      
      
   }
}
 