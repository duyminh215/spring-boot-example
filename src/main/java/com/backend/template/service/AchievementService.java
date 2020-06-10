package com.backend.template.service;

import com.backend.template.dto.UserBasicInfoDto;
import com.backend.template.dto.input.CreateAchievementInput;
import com.backend.template.dto.input.CreateUserAchievementInput;
import com.backend.template.dto.output.CreateUserAchievementDto;
import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.exception.RecordNotFoundException;
import com.backend.template.locale.Translator;
import com.backend.template.model.Achievement;
import com.backend.template.model.UserAchievement;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.AchievementRepository;
import com.backend.template.repositories.UserAchievementRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * template
 *
 * @author anhdt
 * @created_at 03/06/2020 - 2:24 PM
 * @created_by anhdt
 * @since 03/06/2020
 */
@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;
    private final UserAchievementRepository userAchievementRepository;

    public AchievementService(AchievementRepository achievementRepository, UserAchievementRepository userAchievementRepository) {
        this.achievementRepository = achievementRepository;
        this.userAchievementRepository = userAchievementRepository;
    }


    public Achievement createAchievement(CreateAchievementInput createAchievementInput){

        Achievement achievement = createInstanceAchievement(createAchievementInput);
        achievementRepository.save(achievement);

        return achievement;
    }

    private Achievement createInstanceAchievement(CreateAchievementInput input) {

        String content = input.getContent();
        String icon = input.getIcon();
        int status = input.getStatus();
        String title = input.getTitle();

        return new Achievement(content, icon, status, title);
    }

    public Achievement updateAchievement(CreateAchievementInput createAchievementInput, int id) {

        Achievement achievement = achievementRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(Translator.toLocale("error.msg.record.not_found")));
        Achievement changeAchievement = changeAchievement(achievement, createAchievementInput);
        achievementRepository.save(changeAchievement);

        return changeAchievement;
    }

    private Achievement changeAchievement(Achievement achievement, CreateAchievementInput input) {

        achievement.setTitle(input.getTitle());
        achievement.setContent(input.getContent());
        achievement.setStatus(input.getStatus());
        achievement.setIcon(input.getIcon());

        return achievement;
    }

    public CreateUserAchievementDto createUserAchievement(UserBasicInfoDto userBasicInfoDto, CreateUserAchievementInput createUserAchievementInput) {

        UserAchievement userAchievement = createInstanceUserAchievement(userBasicInfoDto, createUserAchievementInput);
        userAchievementRepository.save(userAchievement);

        return generateUserAchievementResponse(userAchievement);
    }

    private CreateUserAchievementDto generateUserAchievementResponse(UserAchievement userAchievement) {

        CreateUserAchievementDto createUserAchievementDto = new CreateUserAchievementDto();
        createUserAchievementDto.setUserAchievement(userAchievement);
        createUserAchievementDto.setId(userAchievement.getId());

        return createUserAchievementDto;
    }

    private UserAchievement createInstanceUserAchievement(UserBasicInfoDto userBasicInfoDto, CreateUserAchievementInput input) {

        long userId = userBasicInfoDto.getUserId();
        BigInteger achievementId = input.getAchievementId();
        int status = input.getStatus();

        return new UserAchievement(userId, achievementId, status);
    }

    public PagingInfo<?> getUserAchievement(long userId, Pageable pageable) {

        return PageResponseBuilder.buildPagingData(achievementRepository.getListAchievementByUser(userId, pageable), pageable);
    }
}
