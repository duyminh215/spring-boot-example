package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the user_notification database table.
 * 
 */
@Entity
@Table(name="user_notification")
@NamedQuery(name="UserNotification.findAll", query="SELECT u FROM UserNotification u")
public class UserNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String body;

	@Column(name="created_time")
	private BigInteger createdTime;

	@Column(name="hash_key")
	private String hashKey;

	private String icon;

	@Column(name="icon_name")
	private String iconName;

	@Column(name="is_read")
	private byte isRead;

	private BigInteger paramId1;

	private BigInteger paramId2;

	private BigInteger paramId3;

	private String paramStr1;

	@Column(name="parent_type")
	private int parentType;

	@Column(name="push_status")
	private byte pushStatus;

	@Column(name="reference_id")
	private BigInteger referenceId;

	private String title;

	private int type;

	private String url;

	@Column(name="user_id")
	private BigInteger userId;

	public UserNotification() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public BigInteger getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(BigInteger createdTime) {
		this.createdTime = createdTime;
	}

	public String getHashKey() {
		return this.hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconName() {
		return this.iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public byte getIsRead() {
		return this.isRead;
	}

	public void setIsRead(byte isRead) {
		this.isRead = isRead;
	}

	public BigInteger getParamId1() {
		return this.paramId1;
	}

	public void setParamId1(BigInteger paramId1) {
		this.paramId1 = paramId1;
	}

	public BigInteger getParamId2() {
		return this.paramId2;
	}

	public void setParamId2(BigInteger paramId2) {
		this.paramId2 = paramId2;
	}

	public BigInteger getParamId3() {
		return this.paramId3;
	}

	public void setParamId3(BigInteger paramId3) {
		this.paramId3 = paramId3;
	}

	public String getParamStr1() {
		return this.paramStr1;
	}

	public void setParamStr1(String paramStr1) {
		this.paramStr1 = paramStr1;
	}

	public int getParentType() {
		return this.parentType;
	}

	public void setParentType(int parentType) {
		this.parentType = parentType;
	}

	public byte getPushStatus() {
		return this.pushStatus;
	}

	public void setPushStatus(byte pushStatus) {
		this.pushStatus = pushStatus;
	}

	public BigInteger getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(BigInteger referenceId) {
		this.referenceId = referenceId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}