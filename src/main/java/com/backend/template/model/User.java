package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;

import com.backend.template.utils.Utils;

import java.util.Date;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedQuery(name = "User.getUserById", query = "SELECT t FROM User t where t.id = :id")
@NamedQuery(name = "User.getUserByEmail", query = "SELECT t FROM User t where t.email = :email")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "apple_id")
    private String appleId;

    private String avatar;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "created_time")
    private Long createdTime;

    @Column(name = "device_id")
    private String deviceId;

    private String email;

    @Column(name = "facebook_id")
    private String facebookId;

    @Column(name = "full_name")
    private String fullName;

    private int gender;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "is_confirm_follower")
    private int isConfirmFollower;

    private String password;

    private String phone;

    @Column(name = "push_token")
    private String pushToken;

    @Column(name = "updated_time")
    private Long updatedTime;

    public User() {
    }

    public User(String email, String fullName, String phone) {
        if (!Utils.isStringEmpty(email)) {
            this.email = email;
        }
        this.fullName = fullName;
        if (!Utils.isStringEmpty(phone)) {
            this.phone = phone;
        }
        this.createdTime = Utils.getUnixTimeInSecond();
        this.updatedTime = Utils.getUnixTimeInSecond();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppleId() {
        return this.appleId;
    }

    public void setAppleId(String appleId) {
        this.appleId = appleId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebookId() {
        return this.facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getGoogleId() {
        return this.googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public int getIsConfirmFollower() {
        return this.isConfirmFollower;
    }

    public void setIsConfirmFollower(int isConfirmFollower) {
        this.isConfirmFollower = isConfirmFollower;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public Long getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

}