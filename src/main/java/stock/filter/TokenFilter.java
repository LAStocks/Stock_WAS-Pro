package stock.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import stock.service.TokenUtil;

import java.io.IOException;

//@Component
public class TokenFilter extends OncePerRequestFilter {

    //@Autowired
    private TokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if (tokenUtil.validateToken(token)) {
                String username = tokenUtil.getUsernameFromToken(token);
                System.out.println("인증된 사용자: " + username);
            }
        }

        filterChain.doFilter(request, response);
    }
}