package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the comment_image database table.
 * 
 */
@Entity
@Table(name="comment_image")
@NamedQuery(name="CommentImage.findAll", query="SELECT c FROM CommentImage c")
public class CommentImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="comment_id")
	private BigInteger commentId;

	@Column(name="created_time")
	private BigInteger createdTime;

	@Column(name="image_id")
	private BigInteger imageId;

	public CommentImage() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getCommentId() {
		return this.commentId;
	}

	public void setCommentId(BigInteger commentId) {
		this.commentId = commentId;
	}

	public BigInteger getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(BigInteger createdTime) {
		this.createdTime = createdTime;
	}

	public BigInteger getImageId() {
		return this.imageId;
	}

	public void setImageId(BigInteger imageId) {
		this.imageId = imageId;
	}

}