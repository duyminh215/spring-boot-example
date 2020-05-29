package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * The persistent class for the story_reaction database table.
 * 
 */
@Entity
@Table(name = "story_reaction")
@NamedQuery(name = "StoryReaction.findAll", query = "SELECT s FROM StoryReaction s")
public class StoryReaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "reaction_id")
    private String reactionId;

    @Column(name = "reaction_time")
    private BigInteger reactionTime;

    private int status;

    @Column(name = "story_id")
    private BigInteger storyId;

    @Column(name = "user_id")
    private BigInteger userId;

    public StoryReaction() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReactionId() {
        return this.reactionId;
    }

    public void setReactionId(String reactionId) {
        this.reactionId = reactionId;
    }

    public BigInteger getReactionTime() {
        return this.reactionTime;
    }

    public void setReactionTime(BigInteger reactionTime) {
        this.reactionTime = reactionTime;
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