/* package es.codeurjc.hellowordvscode.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

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
       http.authorizeRequests().antMatchers("/logout").permitAll(); //CREAR PAGINA DE LOGOUT
       http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
       http.authorizeRequests().antMatchers("/personalArea").hasAnyRole("USER");
      // Private pages (all other pages)
      http.authorizeRequests().anyRequest().authenticated();

      //Login form
      http.formLogin().loginPage("/login"); //hay que poner la misma URL que en formulario del login
      http.formLogin().usernameParameter("name"); //mismo nombre que en el formulario
      http.formLogin().passwordParameter("password");
      http.formLogin().defaultSuccessUrl("/personalArea");
      http.formLogin().failureUrl("/loginerror");
      
      //Logout
      http.logout().logoutUrl("/logout");
      http.logout().logoutSuccessUrl("/");
      // Disable CSRF at the mome
      http.csrf().disable(); 
      // - Other security configurations
   }
}
 */