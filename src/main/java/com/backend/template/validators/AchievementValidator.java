package com.backend.template.validators;

import com.backend.template.dto.input.CreateAchievementInput;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.locale.Translator;
import org.springframework.stereotype.Component;

/**
 * template
 *
 * @author anhdt
 * @created_at 03/06/2020 - 2:25 PM
 * @created_by anhdt
 * @since 03/06/2020
 */
@Component
public class AchievementValidator {

    public void validateCreateAchievement(CreateAchievementInput createAchievementInput) {

        if (createAchievementInput.getTitle() == null || createAchievementInput.getTitle().trim().isEmpty()) {
            throw new RequestInvalidException(Translator.toLocale("error.msg.create_achievement_title_empty"));
        }
        if (createAchievementInput.getContent() == null || createAchievementInput.getContent().trim().isEmpty()) {
            throw new RequestInvalidException(Translator.toLocale("error.msg.create_achievement_content_empty"));
        }
    }
}
