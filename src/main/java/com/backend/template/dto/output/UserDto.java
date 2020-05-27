package com.backend.template.dto.output;

import java.util.Date;

import com.backend.template.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private long id;
    private String appleId;
    private String avatar;
    private Date birthday;
    private Long createdTime;
    private String deviceId;
    private String email;
    private String facebookId;
    private String fullName;
    private int gender;
    private String googleId;
    private int isConfirmFollower;
    private String phone;
    private String pushToken;
    private Long updatedTime;

    public void loadDataFromModel(User user) {
        this.id = user.getId();
        this.appleId = user.getAppleId();
        this.avatar = user.getAvatar();
        this.birthday = user.getBirthday();
        this.createdTime = user.getCreatedTime();
        this.deviceId = user.getDeviceId();
        this.email = user.getEmail();
        this.facebookId = user.getFacebookId();
        this.fullName = user.getFullName();
        this.gender = user.getGender();
        this.googleId = user.getGoogleId();
        this.isConfirmFollower = user.getIsConfirmFollower();
        this.phone = user.getPhone();
        this.pushToken = user.getPushToken();
        this.updatedTime = user.getUpdatedTime();
    }
}
