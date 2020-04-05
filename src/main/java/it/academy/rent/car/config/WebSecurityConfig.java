package it.academy.rent.car.config;

import it.academy.rent.car.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticateService authenticateService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/userRegistration","/","/userComeIn").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/adminCreate").hasRole("ADMIN")
                .antMatchers("/userRegistration","/","/userComeIn").hasRole("USER")
                //Доступ разрешен всем пользователей
                .antMatchers("/userRegistration","/","/userComeIn").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/user/userComeIn")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/index")
                .permitAll()
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
