package com.backend.template.dto.input;

import lombok.Data;

import java.math.BigInteger;

/**
 * template
 *
 * @author anhdt
 * @created_at 04/06/2020 - 3:34 PM
 * @created_by anhdt
 * @since 04/06/2020
 */
@Data
public class CreateUserAchievementInput {

    private BigInteger achievementId;
    private int status;
}
