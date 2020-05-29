package com.backend.template.dto.input;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class CreateStoryInput implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Bạn phải nhập tiêu đề bài viết")
    private String title;

    @NotBlank(message = "Bạn phải nhập nội dung bài viết")
    private String content;
    private Integer privacyStatus;

    public CreateStoryInput(@NotBlank(message = "Bạn phải nhập tiêu đề bài viết") String title,
            @NotBlank(message = "Bạn phải nhập nội dung bài viết") String content, Integer privacyStatus) {
        super();
        this.title = title;
        this.content = content;
        this.privacyStatus = privacyStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrivacyStatus() {
        return privacyStatus;
    }

    public void setPrivacyStatus(Integer privacyStatus) {
        this.privacyStatus = privacyStatus;
    }
}
