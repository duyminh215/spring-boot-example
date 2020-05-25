package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the story_comment database table.
 * 
 */
@Entity
@Table(name="story_comment")
@NamedQuery(name="StoryComment.findAll", query="SELECT s FROM StoryComment s")
public class StoryComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="commented_time")
	private BigInteger commentedTime;

	@Lob
	private String content;

	private int status;

	@Column(name="story_id")
	private BigInteger storyId;

	@Column(name="user_id")
	private BigInteger userId;

	public StoryComment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getCommentedTime() {
		return this.commentedTime;
	}

	public void setCommentedTime(BigInteger commentedTime) {
		this.commentedTime = commentedTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigInteger getStoryId() {
		return this.storyId;
	}

	public void setStoryId(BigInteger storyId) {
		this.storyId = storyId;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}