package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the following database table.
 * 
 */
@Entity
@Table(name="following")
@NamedQuery(name="Following.findAll", query="SELECT f FROM Following f")
public class Following implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="following_user_id")
	private BigInteger followingUserId;

	@Column(name="inserted_time")
	private BigInteger insertedTime;

	private int status;

	@Column(name="updated_time")
	private BigInteger updatedTime;

	@Column(name="user_id")
	private BigInteger userId;

	public Following() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getFollowingUserId() {
		return this.followingUserId;
	}

	public void setFollowingUserId(BigInteger followingUserId) {
		this.followingUserId = followingUserId;
	}

	public BigInteger getInsertedTime() {
		return this.insertedTime;
	}

	public void setInsertedTime(BigInteger insertedTime) {
		this.insertedTime = insertedTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigInteger getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(BigInteger updatedTime) {
		this.updatedTime = updatedTime;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}