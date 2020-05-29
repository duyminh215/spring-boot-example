package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the server_setting database table.
 * 
 */
@Entity
@Table(name = "server_setting")
@NamedQuery(name = "ServerSetting.findAll", query = "SELECT s FROM ServerSetting s")
public class ServerSetting implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String value;

    private int version;

    public ServerSetting() {
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