package stock.mapper;

import org.apache.ibatis.annotations.Mapper;
import stock.model.UserInfo;


@Mapper
public interface UserInfoMapper {

    int findByUserIdCnt(String userId);

/*
    int findByUserId(String userId);
    void update(UserInfo userInfo);

    void deleteByUserId(String userId);
void save(UserInfo userInfo);
*/
}
