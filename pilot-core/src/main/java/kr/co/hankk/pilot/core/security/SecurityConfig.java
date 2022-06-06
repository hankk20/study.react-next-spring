package kr.co.hankk.pilot.core.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;
import java.util.Set;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 기본 Accessible Scope{@link org.springframework.security.oauth2.core.oidc.OidcScopes}과
         * Kakao에서 사용하는 Scope 명이 달라 카카오에서 사용하는 Scope으로 지정해야 한다.
         */

        OidcUserService oidcUserService = new OidcUserService();
        oidcUserService.setAccessibleScopes(Set.of("account_email", "openid", "phone_number"));

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(List.of("http://localhost*"));
        corsConfiguration.setAllowedMethods(List.of("*"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));

        http.authorizeRequests()
                .antMatchers("/inquiry")
                .permitAll()
                .anyRequest().authenticated()
                .and()
            .oauth2Login()
                .userInfoEndpoint()
                .oidcUserService(oidcUserService)
                .and()
                .successHandler((request, response, authentication) -> {
                    response.sendRedirect("http://localhost:3000/");
                })
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("http://localhost:3000/")
                .and()
                .csrf().disable()
                .cors()
                .configurationSource(request -> corsConfiguration)
                ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
    }

}
