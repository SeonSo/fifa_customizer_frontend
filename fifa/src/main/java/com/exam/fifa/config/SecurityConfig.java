package com.exam.fifa.config;

import com.exam.fifa.config.jwt.JwtAuthenticationFilter;
import com.exam.fifa.config.jwt.JwtAuthorizationFilter;
import com.exam.fifa.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfig corsConfig;
    private final MemberRepository memberRepository;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
                http.csrf().disable()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .formLogin().disable()
                        .httpBasic().disable()
                        .apply(new MyCustomDsl())
                        .and()
                        .authorizeRequests(authorize -> authorize
                            .antMatchers("/api/member/**")
                            .access("hasRole('Role.MEMBER') or hasRole('Role.ADMIN')")
                            .antMatchers("/api/admin/**")
                            .access("hasRole('ROLE_ADMIN')")
                            .anyRequest().permitAll()
                        )
                .build();
    }
    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
            http
                    .addFilter(corsConfig.corsFilter())
                    .addFilter(new JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository))
        }
    }
}
