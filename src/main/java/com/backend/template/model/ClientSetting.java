package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client_setting database table.
 * 
 */
@Entity
@Table(name="client_setting")
@NamedQuery(name="ClientSetting.findAll", query="SELECT c FROM ClientSetting c")
@NamedQuery(name="ClientSetting.getSettingByName", query="SELECT c FROM ClientSetting c WHERE c.name = :name")
public class ClientSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String value;

	private int version;

	public ClientSetting() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}