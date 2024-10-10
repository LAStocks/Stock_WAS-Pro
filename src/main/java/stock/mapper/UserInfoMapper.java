package stock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import stock.model.UserInfo;

@Mapper
public interface UserInfoMapper {

    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo findByUsername(String username);

    @Insert("INSERT INTO user_info (username, password, address, birthDate, gender, occupation) VALUES (#{username}, #{password}, #{address}, #{birthDate}, #{gender}, #{occupation})")
    @Options(useGeneratedKeys = true, keyProperty = "user_info_id")
    void save(UserInfo userInfo);

}
