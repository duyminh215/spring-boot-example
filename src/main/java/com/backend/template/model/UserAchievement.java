package com.backend.template.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * The persistent class for the user_achievement database table.
 * 
 */
@Entity
@Table(name = "user_achievement")
@NamedQuery(name = "UserAchievement.findAll", query = "SELECT u FROM UserAchievement u")
public class UserAchievement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "achievement_id")
    private BigInteger achievementId;

    @CreationTimestamp
    @Column(name = "reached_time")
    private LocalDateTime reachedTime;

    private int status;

    @Column(name = "user_id")
    private Long userId;

    public UserAchievement() {
    }

    public UserAchievement(long userId, BigInteger achievementId, int status) {
        this.userId = userId;
        this.achievementId = achievementId;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getAchievementId() {
        return this.achievementId;
    }

    public void setAchievementId(BigInteger achievementId) {
        this.achievementId = achievementId;
    }

    public LocalDateTime getReachedTime() {
        return this.reachedTime;
    }

    public void setReachedTime(LocalDateTime reachedTime) {
        this.reachedTime = reachedTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}