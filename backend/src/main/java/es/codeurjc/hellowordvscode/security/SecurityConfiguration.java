package es.codeurjc.hellowordvscode.security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder(10, new SecureRandom());
   }   
   
   @Autowired
      RepositoryUserDetailsService userDetailsService;
   @Bean
   @Override
   public AuthenticationManager authenticationManager() throws Exception{
      return super.authenticationManager();
   }

      
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception { 

      
 
      // Public pages 
      http.authorizeRequests().antMatchers("/index").permitAll();
      http.authorizeRequests().antMatchers("/login").permitAll(); 
      http.authorizeRequests().antMatchers("/loginerror").permitAll();
      http.authorizeRequests().antMatchers("/logout").permitAll();
      http.authorizeRequests().antMatchers("/").permitAll();
      //http.authorizeRequests().antMatchers("/error").permitAll();
      http.authorizeRequests().antMatchers("/destination/*").permitAll(); 
      http.authorizeRequests().antMatchers("/signup").permitAll();
      http.authorizeRequests().antMatchers("/editDestinations/{name}").permitAll();
      http.authorizeRequests().antMatchers("/error").permitAll();
      
      // Private pages (all other pages)

      http.authorizeRequests().antMatchers("/addDestinations").hasAnyRole("ADMIN");
      http.authorizeRequests().antMatchers("/personalArea").hasAnyRole("USER", "ADMIN");
      http.authorizeRequests().antMatchers("/configUsers").hasAnyRole("ADMIN");
      //http.authorizeRequests().antMatchers("/editarDestinos/*").hasAnyRole("ADMIN");
      
    

      //Login form
      http.formLogin().loginPage("/login");
      http.formLogin().usernameParameter("username");
      http.formLogin().passwordParameter("password");
      http.formLogin().successHandler((request, response, authentication) -> {
         if (authentication.getAuthorities().stream()
                 .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"))) {
             response.sendRedirect("/admin");
         } else {
             response.sendRedirect("/personalArea");
         }
      });

      http.formLogin().failureUrl("/loginerror");

      //Logout
      http.logout().logoutUrl("/logout");
      http.logout().logoutSuccessUrl("/logout");


      // Disable CSRF at the mome
      // http.csrf().disable(); 
      
      
   }
}