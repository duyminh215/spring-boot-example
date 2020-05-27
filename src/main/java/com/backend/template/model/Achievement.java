package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the achievement database table.
 * 
 */
@Entity
@Table(name = "achievement")
@NamedQuery(name = "Achievement.findAll", query = "SELECT a FROM Achievement a")
public class Achievement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @Column(name = "created_time")
    private BigInteger createdTime;

    private String icon;

    private int status;

    private String title;

    @Column(name = "updated_time")
    private BigInteger updatedTime;

    public Achievement() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public BigInteger getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(BigInteger updatedTime) {
        this.updatedTime = updatedTime;
    }

}