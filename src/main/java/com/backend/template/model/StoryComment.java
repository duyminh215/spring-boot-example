package com.backend.template.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * The persistent class for the story_comment database table.
 * 
 */
@Entity
@Table(name = "story_comment")
@NamedQuery(name = "StoryComment.findAll", query = "SELECT s FROM StoryComment s")
public class StoryComment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "commented_time")
    private Long commentedTime;

    @NotBlank(message = "Bạn phải nhập nội dung bình luận")
    @Lob
    private String content;

    private int status;

    @Column(name = "story_id")
    private Long storyId;

    @Column(name = "user_id")
    private Long userId;

    public StoryComment() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCommentedTime() {
        return this.commentedTime;
    }

    public void setCommentedTime(Long commentedTime) {
        this.commentedTime = commentedTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getStoryId() {
        return this.storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}