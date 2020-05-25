package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the suggest_kindness_action database table.
 * 
 */
@Entity
@Table(name="suggest_kindness_action")
@NamedQuery(name="SuggestKindnessAction.findAll", query="SELECT s FROM SuggestKindnessAction s")
public class SuggestKindnessAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="action_id")
	private BigInteger actionId;

	@Column(name="inserted_time")
	private BigInteger insertedTime;

	@Column(name="user_id")
	private BigInteger userId;

	public SuggestKindnessAction() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getActionId() {
		return this.actionId;
	}

	public void setActionId(BigInteger actionId) {
		this.actionId = actionId;
	}

	public BigInteger getInsertedTime() {
		return this.insertedTime;
	}

	public void setInsertedTime(BigInteger insertedTime) {
		this.insertedTime = insertedTime;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}