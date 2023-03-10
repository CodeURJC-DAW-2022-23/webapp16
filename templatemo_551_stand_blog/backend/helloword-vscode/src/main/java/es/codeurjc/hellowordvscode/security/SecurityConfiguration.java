package es.codeurjc.hellowordvscode.security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   
   /*@Value("${security.user}")
   private String user;
   
   @Value("${security.encodedPassword}")
   private String encodedPassword;*/

   @Bean
   public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder(10, new SecureRandom());
   }

   @Autowired
   RepositoryUserDetailsService userDetailsService;
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      //PasswordEncoderFactories.createDelegatingPasswordEncoder();
      //auth.inMemoryAuthentication().withUser(user).password("{bcrypt}"+encodedPassword).roles("USER");

      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

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


       //http.authorizeRequests().antMatchers("/admin").permitAll();

       
      
       // Private pages (all other pages)
       http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
       http.authorizeRequests().antMatchers("/personalArea").hasAnyRole("USER");
      
       //Login form
       http.formLogin().loginPage("/login");
       http.formLogin().usernameParameter("username");
       http.formLogin().passwordParameter("password");
       http.formLogin().defaultSuccessUrl("/personalArea");
       http.formLogin().failureUrl("/loginerror");
      
      //Logout
      http.logout().logoutUrl("/logout");
      http.logout().logoutSuccessUrl("/index");
      


      // Disable CSRF at the mome
      // http.csrf().disable(); 
      
      
   }
}
 