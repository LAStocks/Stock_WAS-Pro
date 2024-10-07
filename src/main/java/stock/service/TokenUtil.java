package stock.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
public class TokenUtil {

    // In-memory token store (you can replace this with Redis or database in production)
    private Map<String, String> tokenStore = new HashMap<>();

    // 토큰 생성
    public String generateToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(token, username);  // 토큰과 사용자 정보 저장
        return token;
    }

    // 토큰 검증
    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }

    // 토큰으로 사용자 이름 가져오기
    public String getUsernameFromToken(String token) {
        return tokenStore.get(token);
    }
}
