package com.backend.template.controller;

import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.UserNotificationService;
import com.backend.template.utils.Utils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userNotice")
public class UserNotificationController extends BaseController{

    private final ResponseFactory responseFactory;

    private final UserNotificationService userNotificationService;

    public UserNotificationController(ResponseFactory responseFactory, UserNotificationService userNotificationService) {
        this.responseFactory = responseFactory;
        this.userNotificationService = userNotificationService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllNotice(@RequestParam(defaultValue = "0", required = false) Integer page,
                                          @RequestParam(defaultValue = "10", required = false) Integer size,
                                          @RequestParam(defaultValue = "", required = false) String sort) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Utils.getOrderFieldsOfRequest(sort)));
        return responseFactory.success(userNotificationService.getAllNotice(pageable));
    }
}
