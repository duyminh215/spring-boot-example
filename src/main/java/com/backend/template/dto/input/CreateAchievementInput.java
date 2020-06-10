package com.backend.template.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * template
 *
 * @author anhdt
 * @created_at 03/06/2020 - 3:43 PM
 * @created_by anhdt
 * @since 03/06/2020
 */
@Getter
@Setter
public class CreateAchievementInput implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Bạn phải nhập mô tả cho danh hiệu")
    private String content;

    private String icon;

    private int status;

    @NotBlank(message = "Bạn phải nhập tiêu đề danh hiệu")
    private String title;

    public CreateAchievementInput(@NotBlank(message = "Bạn phải nhập mô tả cho danh hiệu") String content, String icon, int status, @NotBlank(message = "Bạn phải nhập tiêu đề danh hiệu") String title) {
        this.content = content;
        this.icon = icon;
        this.status = status;
        this.title = title;
    }
}
