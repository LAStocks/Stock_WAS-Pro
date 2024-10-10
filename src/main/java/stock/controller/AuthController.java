package stock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Authentication Controller", description = "사용자 인증과 관련된 작업들")
public class AuthController {

    //@Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 로그인 후 토큰 발급
    @PostMapping("/login")
    @ApiOperation(value = "User Login", notes = "사용자 이름과 비밀번호를 사용하여 로그인합니다.")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        UserInfo userInfo = userInfoMapper.findByUsername(username);
        if (userInfo == null || !bCryptPasswordEncoder.matches(password, userInfo.getPassword())) {
            return new ResponseEntity<>("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Login successful.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "User Sign Up", notes = "제공된 정보를 사용하여 새로운 사용자를 등록합니다.")
    public ResponseEntity<String> signUp(@RequestBody UserInfo userInfo) {
        if(userInfoMapper.findByUsername(userInfo.getUsername()) != null) {
            return new ResponseEntity<>("회원가입 하려 한 ID가 존재합니다.", HttpStatus.BAD_REQUEST);
        }
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoMapper.save(userInfo);

        return new ResponseEntity<>("회원가입이 완료되었습니다.", HttpStatus.OK);
    }

}
