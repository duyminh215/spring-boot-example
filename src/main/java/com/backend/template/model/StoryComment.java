package com.backend.template.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * The persistent class for the story_comment database table.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "story_comment")
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
}