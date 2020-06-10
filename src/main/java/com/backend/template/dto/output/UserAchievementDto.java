package com.backend.template.dto.output;

import java.time.LocalDateTime;

/**
 * template
 *
 * @author anhdt
 * @created_at 10/06/2020 - 10:44 AM
 * @created_by anhdt
 * @since 10/06/2020
 */
public class UserAchievementDto {

    private Long userId;

    private LocalDateTime reachedTime;

    private String content;

    private String icon;

    private String title;

    public UserAchievementDto(Long userId, LocalDateTime reachedTime, String content, String icon, String title) {
        this.userId = userId;
        this.reachedTime = reachedTime;
        this.content = content;
        this.icon = icon;
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getReachedTime() {
        return reachedTime;
    }

    public void setReachedTime(LocalDateTime reachedTime) {
        this.reachedTime = reachedTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
