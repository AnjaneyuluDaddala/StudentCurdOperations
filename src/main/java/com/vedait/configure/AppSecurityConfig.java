package com.vedait.configure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class AppSecurityConfig{
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf->csrf.disable())
		    .authorizeHttpRequests(
		    		authroize->authroize.anyRequest().permitAll()	
		    		).httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
//	  @Bean
//	   WebMvcConfigurer corsConfigurer() {
//	        return new WebMvcConfigurer() {
//	            @Override
//	            public void addCorsMappings(CorsRegistry registry) {
//	                registry.addMapping("/**")
//	                        .allowedOrigins("http://localhost:3000")
//	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//	                        .allowedHeaders("*")
//	                        .allowCredentials(true);
//	            }
//	        };
//	    }
	
	@Bean
	UserDetailsService userDetailsService() {
		
		UserDetails ramesh=User.builder()
				               .username("ramesh")
				               .password(passwordEncoder().encode("1234"))
		                       .roles("USER")
		                       .build();
		
		UserDetails admin=User.builder()
	               .username("admin")
	               .password(passwordEncoder().encode("4567"))
                   .roles("ADMIN")
                   .build();
		
		return new InMemoryUserDetailsManager(ramesh,admin);
	}
	
	
	@Bean
	static PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
}