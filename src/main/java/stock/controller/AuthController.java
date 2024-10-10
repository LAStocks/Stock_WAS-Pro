package stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import stock.mapper.UserInfoMapper;
import stock.model.UserInfo;
import stock.service.TokenUtil;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    //@Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserInfo userInfo) {
        if(userInfoMapper.findByUsername(userInfo.getUsername()) != null) {
            return new ResponseEntity<>("회원가입 하려 한 ID가 존재합니다.", HttpStatus.BAD_REQUEST);
        }
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoMapper.save(userInfo);

        return new ResponseEntity<>("회원가입이 완료되었습니다.", HttpStatus.OK);
    }

}
