package com.backend.template.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStoryComment {

    @NotBlank(message = "Bạn phải nhập nội dung bình luận")
    private String content;

    private int status;
}
