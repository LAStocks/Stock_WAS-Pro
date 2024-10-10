package stock.model;

import java.util.Map;

public class UserInfo {

    private Long user_info_id;
    private String username;
    private String password;
    private String address;
    private String birthDate;
    private String gender;
    private String occupation;

    // Constructors
    public UserInfo() {}

    public UserInfo(Map<String, Object> userInfoMap) {
        this.user_info_id = (Long) userInfoMap.get("user_info_id");
        this.username = (String) userInfoMap.get("username");
        this.password = (String) userInfoMap.get("password");
        this.address = (String) userInfoMap.get("address");
        this.birthDate = (String) userInfoMap.get("birthDate");
        this.gender = (String) userInfoMap.get("gender");
        this.occupation = (String) userInfoMap.get("occupation");
    }

    public Long getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(Long user_info_id) {
        this.user_info_id = user_info_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
