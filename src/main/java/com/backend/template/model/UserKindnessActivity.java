package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the user_kindness_activity database table.
 * 
 */
@Entity
@Table(name = "user_kindness_activity")
@NamedQuery(name = "UserKindnessActivity.findAll", query = "SELECT u FROM UserKindnessActivity u")
public class UserKindnessActivity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "action_time")
    private BigInteger actionTime;

    @Lob
    @Column(name = "activity_content")
    private String activityContent;

    @Column(name = "activity_title")
    private String activityTitle;

    @Column(name = "kindness_action_id")
    private BigInteger kindnessActionId;

    @Column(name = "user_id")
    private BigInteger userId;

    public UserKindnessActivity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getActionTime() {
        return this.actionTime;
    }

    public void setActionTime(BigInteger actionTime) {
        this.actionTime = actionTime;
    }

    public String getActivityContent() {
        return this.activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public String getActivityTitle() {
        return this.activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public BigInteger getKindnessActionId() {
        return this.kindnessActionId;
    }

    public void setKindnessActionId(BigInteger kindnessActionId) {
        this.kindnessActionId = kindnessActionId;
    }

    public BigInteger getUserId() {
        return this.userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

}