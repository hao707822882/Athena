package com.boom.athean.security;

import com.boom.athean.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author Eric
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private AccessDecisionManagerImpl decisionManager;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.anonymous();
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        http.authorizeRequests().antMatchers("/**").authenticated()
                .accessDecisionManager(decisionManager)
                .and().formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/index.html")
                .defaultSuccessUrl("/angel/index.html", true)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index.html");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminUserService);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
