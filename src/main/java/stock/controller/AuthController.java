package stock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.mapper.UserInfoMapper;
import stock.model.UserInfo;
import stock.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication Controller", description = "사용자 인증과 관련된 작업들")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "사용자 이름과 비밀번호를 사용하여 로그인합니다.")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String message = authService.login(loginRequest.get("username"), loginRequest.get("password"));
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    @Operation(summary = "User Sign Up", description = "제공된 정보를 사용하여 새로운 사용자를 등록합니다.")
    public ResponseEntity<String> signUp(@RequestBody UserInfo userInfo) {
        try {
            String message = authService.signUp(userInfo);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
