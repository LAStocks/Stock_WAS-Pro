package stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stock.service.TokenUtil;

@RestController
public class AuthController {

    //@Autowired
    private TokenUtil tokenUtil;

    // 로그인 후 토큰 발급
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 실제 로그인 로직 추가 (예: 데이터베이스에서 사용자 검증)
        if ("user".equals(username) && "password".equals(password)) {
            // 토큰 생성
            return tokenUtil.generateToken(username);
        } else {
            return "로그인 실패";
        }
    }
}
