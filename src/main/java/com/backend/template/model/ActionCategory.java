package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the action_category database table.
 * 
 */
@Entity
@Table(name="action_category")
@NamedQuery(name="ActionCategory.findAll", query="SELECT a FROM ActionCategory a")
public class ActionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="action_id")
	private BigInteger actionId;

	@Column(name="category_id")
	private int categoryId;

	public ActionCategory() {
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

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}