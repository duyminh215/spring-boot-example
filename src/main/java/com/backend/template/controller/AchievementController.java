package com.backend.template.controller;

import com.backend.template.dto.input.CreateAchievementInput;
import com.backend.template.dto.input.CreateUserAchievementInput;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.AchievementService;
import com.backend.template.validators.AchievementValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * template
 *
 * @author anhdt
 * @created_at 03/06/2020 - 2:18 PM
 * @created_by anhdt
 * @since 03/06/2020
 */
@RestController
@RequestMapping("/achievement")
public class AchievementController extends BaseController {

    static final Logger logger = LogManager.getLogger(AchievementController.class);

    private final ResponseFactory responseFactory;
    private final AchievementService achievementService;
    private final AchievementValidator achievementValidator;

    public AchievementController(ResponseFactory responseFactory, AchievementService achievementService, AchievementValidator achievementValidator) {
        this.responseFactory = responseFactory;
        this.achievementService = achievementService;
        this.achievementValidator = achievementValidator;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAchievement(@RequestBody CreateAchievementInput createAchievementInput) {
        achievementValidator.validateCreateAchievement(createAchievementInput);
        return responseFactory.success(achievementService.createAchievement(createAchievementInput));
    }

    @PostMapping("/create-user-achievement")
    public ResponseEntity<?> createUserAchievement(@RequestBody CreateUserAchievementInput createUserAchievementInput) {
        return responseFactory.success(achievementService.createUserAchievement(getUserBasicInfo(), createUserAchievementInput));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAchievement(@RequestBody CreateAchievementInput createAchievementInput, @PathVariable Integer id) {
        achievementValidator.validateCreateAchievement(createAchievementInput);
        return responseFactory.success(achievementService.updateAchievement(createAchievementInput, id));
    }

    @GetMapping("")
    public ResponseEntity<?> getUserAchievement(@RequestParam(defaultValue ="0") @Min(value = 0) Integer page,
                                                @RequestParam(defaultValue = "10") @Min(1) @Max(10) Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return responseFactory.success(achievementService.getUserAchievement(getLoginedUser().getId(), pageable));
    }
}
