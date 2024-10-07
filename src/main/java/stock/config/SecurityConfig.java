package stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/test/**").permitAll()  // "/api/**" 경로는 인증 필요 없음
                        .requestMatchers("/login").permitAll()   // "/login" 경로는 인증 필요 없음
                        .anyRequest().authenticated()            // 그 외 모든 경로는 인증 필요
                );

        return http.build();
    }
}