package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the kindness_action database table.
 * 
 */
@Entity
@Table(name="kindness_action")
@NamedQuery(name="KindnessAction.findAll", query="SELECT k FROM KindnessAction k")
public class KindnessAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Lob
	private String content;

	@Column(name="created_time")
	private BigInteger createdTime;

	private int status;

	private String title;

	public KindnessAction() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigInteger getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(BigInteger createdTime) {
		this.createdTime = createdTime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}