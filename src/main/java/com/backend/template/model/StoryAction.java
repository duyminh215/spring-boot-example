package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the story_action database table.
 * 
 */
@Entity
@Table(name="story_action")
@NamedQuery(name="StoryAction.findAll", query="SELECT s FROM StoryAction s")
public class StoryAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="action_id")
	private BigInteger actionId;

	@Column(name="created_time")
	private BigInteger createdTime;

	@Column(name="story_id")
	private BigInteger storyId;

	public StoryAction() {
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

	public BigInteger getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(BigInteger createdTime) {
		this.createdTime = createdTime;
	}

	public BigInteger getStoryId() {
		return this.storyId;
	}

	public void setStoryId(BigInteger storyId) {
		this.storyId = storyId;
	}

}