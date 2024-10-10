package stock.model;

import java.util.Map;

public class UserInfo {

    private Long user_idx;
    private String userId;
    private String userName; // 필드 이름 변경
    private String password;
    private String address;
    private String birthDate;
    private String gender;
    private String occupation;

    // Getters and Setters
    public Long getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(Long user_idx) {
        this.user_idx = user_idx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() { // 필드 이름 변경에 따라 수정
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Constructors
    public UserInfo() {}

    public UserInfo(Map<String, Object> userInfoMap) {
        this.user_idx = (Long) userInfoMap.get("user_idx");
        this.userId = (String) userInfoMap.get("userId");
        this.userName = (String) userInfoMap.get("userName");
        this.password = (String) userInfoMap.get("password");
        this.address = (String) userInfoMap.get("address");
        this.birthDate = (String) userInfoMap.get("birthDate");
        this.gender = (String) userInfoMap.get("gender");
        this.occupation = (String) userInfoMap.get("occupation");
    }
}