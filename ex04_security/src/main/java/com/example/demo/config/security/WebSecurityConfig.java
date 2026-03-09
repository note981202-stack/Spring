package com.example.demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

    WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeHttpRequests((requests) -> requests    // 접근 제한
				.requestMatchers("/", "/home", "/login").permitAll()
				.requestMatchers("/admin", "/admin/**").hasRole("ADMIN") // admin롤 을 가진자만 접근가능
				.anyRequest().authenticated()  // 로그인해야만 사용가능
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.successHandler(authenticationSuccessHandler())
				.permitAll()
			)
			.logout(LogoutConfigurer::permitAll)
			.csrf( c-> c.disable() );
		// @formatter:on

		return http.build();
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {     				//암호화 해줌
		return new BCryptPasswordEncoder(10);
	}

//	@Bean
//	UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		String password = encoder.encode("1234");    												//로그인 비밀번호
//		UserDetails user = User.withUsername("user").password(password).roles("USER").build();      //로그인 아이디
//		UserDetails admin = User.withUsername("admin").password(password).roles("ADMIN").build();      //로그인 아이디
//		return new InMemoryUserDetailsManager(user, admin);
//	}

}
