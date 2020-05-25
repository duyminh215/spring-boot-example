package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String icon;

	private String name;

	private int ordinal;

	@Column(name="parent_id")
	private int parentId;

	private int status;

	@Column(name="used_for_filter")
	private int usedForFilter;

	@Column(name="used_for_search")
	private int usedForSearch;

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrdinal() {
		return this.ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUsedForFilter() {
		return this.usedForFilter;
	}

	public void setUsedForFilter(int usedForFilter) {
		this.usedForFilter = usedForFilter;
	}

	public int getUsedForSearch() {
		return this.usedForSearch;
	}

	public void setUsedForSearch(int usedForSearch) {
		this.usedForSearch = usedForSearch;
	}

}