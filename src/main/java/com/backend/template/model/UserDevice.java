package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the user_device database table.
 * 
 */
@Entity
@Table(name = "user_device")
@NamedQuery(name = "UserDevice.findAll", query = "SELECT u FROM UserDevice u")
public class UserDevice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "inserted_time")
    private BigInteger insertedTime;

    @Column(name = "push_token")
    private String pushToken;

    @Column(name = "user_id")
    private BigInteger userId;

    public UserDevice() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BigInteger getInsertedTime() {
        return this.insertedTime;
    }

    public void setInsertedTime(BigInteger insertedTime) {
        this.insertedTime = insertedTime;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public BigInteger getUserId() {
        return this.userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

}