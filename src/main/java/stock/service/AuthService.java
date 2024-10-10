package stock.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import stock.mapper.UserInfoMapper;
import stock.model.UserInfo;

@Service
public class AuthService {

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String signUp(UserInfo userInfo) {
        System.out.println(userInfoMapper.findByUserIdCnt(userInfo.getUserId()));
//        if(userInfoMapper.findByUserId(userInfo.getUserName()) != null) {
//            throw new RuntimeException("회원가입 하려 한 ID가 존재합니다.");
//        }
//        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
//        userInfoMapper.save(userInfo);
        return "회원가입이 완료되었습니다.";
    }

    public String login(String username, String password) {
//        UserInfo userInfo = userInfoMapper.findByUserId(username);
//        if (userInfo == null || !bCryptPasswordEncoder.matches(password, userInfo.getPassword())) {
//            throw new RuntimeException("Invalid username or password.");
//        }
        return "Login successful.";
    }
}
