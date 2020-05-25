package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the story_image database table.
 * 
 */
@Entity
@Table(name="story_image")
@NamedQuery(name="StoryImage.findAll", query="SELECT s FROM StoryImage s")
public class StoryImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="image_id")
	private BigInteger imageId;

	@Column(name="inserted_time")
	private BigInteger insertedTime;

	@Column(name="story_id")
	private BigInteger storyId;

	public StoryImage() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getImageId() {
		return this.imageId;
	}

	public void setImageId(BigInteger imageId) {
		this.imageId = imageId;
	}

	public BigInteger getInsertedTime() {
		return this.insertedTime;
	}

	public void setInsertedTime(BigInteger insertedTime) {
		this.insertedTime = insertedTime;
	}

	public BigInteger getStoryId() {
		return this.storyId;
	}

	public void setStoryId(BigInteger storyId) {
		this.storyId = storyId;
	}

}