package it.academy.rent.car.config;

import it.academy.rent.car.service.impl.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
   private AuthenticateService authenticateService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .exceptionHandling()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                //.antMatchers("/userComeIn").permitAll()
                // .antMatchers("/userRegistration").permitAll()
                // .antMatchers("/admin/**","/user/**","/company/**").permitAll()
                //.antMatchers("/admin/**","/user/**","/company/**").hasRole("ADMIN")
                //.antMatchers("/user/**").hasRole("USER")
                //.antMatchers("/user/**","/company/**").hasRole("COMPANY")
                .anyRequest().authenticated()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticateService).passwordEncoder(bCryptPasswordEncoder());
    }
}