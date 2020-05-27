package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the story_share database table.
 * 
 */
@Entity
@Table(name = "story_share")
@NamedQuery(name = "StoryShare.findAll", query = "SELECT s FROM StoryShare s")
public class StoryShare implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String comment;

    @Column(name = "shared_time")
    private BigInteger sharedTime;

    private int status;

    @Column(name = "story_id")
    private BigInteger storyId;

    @Column(name = "user_id")
    private BigInteger userId;

    public StoryShare() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigInteger getSharedTime() {
        return this.sharedTime;
    }

    public void setSharedTime(BigInteger sharedTime) {
        this.sharedTime = sharedTime;
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