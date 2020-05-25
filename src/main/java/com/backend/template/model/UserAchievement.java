package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the user_achievement database table.
 * 
 */
@Entity
@Table(name="user_achievement")
@NamedQuery(name="UserAchievement.findAll", query="SELECT u FROM UserAchievement u")
public class UserAchievement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="achievement_id")
	private BigInteger achievementId;

	@Column(name="reached_time")
	private BigInteger reachedTime;

	private int status;

	@Column(name="user_id")
	private BigInteger userId;

	public UserAchievement() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(BigInteger achievementId) {
		this.achievementId = achievementId;
	}

	public BigInteger getReachedTime() {
		return this.reachedTime;
	}

	public void setReachedTime(BigInteger reachedTime) {
		this.reachedTime = reachedTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}