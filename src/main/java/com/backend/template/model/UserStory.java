package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;

import com.backend.template.constant.StoryStatuses;
import com.backend.template.utils.Utils;

/**
 * The persistent class for the user_story database table.
 * 
 */
@Entity
@Table(name = "user_story")
@NamedQuery(name = "UserStory.findAll", query = "SELECT u FROM UserStory u")
public class UserStory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    @Column(name = "created_time")
    private Long createdTime;

    @Column(name = "number_of_comment")
    private int numberOfComment;

    @Column(name = "number_of_dislike")
    private int numberOfDislike;

    @Column(name = "number_of_like")
    private int numberOfLike;

    @Column(name = "privacy_status")
    private int privacyStatus;

    private int status;

    private String title;

    @Column(name = "user_id")
    private Long userId;

    public UserStory() {
    }

    public UserStory(Long userId, String title, String content, int privacyStatus) {
        this.content = content;
        this.privacyStatus = privacyStatus;
        this.title = title;
        this.userId = userId;
        this.createdTime = Utils.getUnixTimeInSecond();
        this.status = StoryStatuses.NEW.getStatus();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public int getNumberOfComment() {
        return this.numberOfComment;
    }

    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }

    public int getNumberOfDislike() {
        return this.numberOfDislike;
    }

    public void setNumberOfDislike(int numberOfDislike) {
        this.numberOfDislike = numberOfDislike;
    }

    public int getNumberOfLike() {
        return this.numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    public int getPrivacyStatus() {
        return this.privacyStatus;
    }

    public void setPrivacyStatus(int privacyStatus) {
        this.privacyStatus = privacyStatus;
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

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}