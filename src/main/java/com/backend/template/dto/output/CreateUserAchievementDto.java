package com.backend.template.dto.output;

import com.backend.template.model.UserAchievement;
import lombok.Data;

/**
 * template
 *
 * @author anhdt
 * @created_at 04/06/2020 - 3:55 PM
 * @created_by anhdt
 * @since 04/06/2020
 */
@Data
public class CreateUserAchievementDto {

    private UserAchievement userAchievement;
    private long id;
}
