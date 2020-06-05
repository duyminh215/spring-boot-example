package com.backend.template.service.impl;

import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.model.UserNotification;
import com.backend.template.model.UserNotification_;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.UserNotificationRepository;
import com.backend.template.repositories.specifications.UserNotificationSpecification;
import com.backend.template.service.ServiceAuth;
import com.backend.template.service.UserNotificationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UserNotificationServiceImpl implements UserNotificationService {

    private final UserNotificationRepository userNotificationRepository;

    private final ServiceAuth serviceAuth;

    public UserNotificationServiceImpl(UserNotificationRepository userNotificationRepository, ServiceAuth serviceAuth) {
        this.userNotificationRepository = userNotificationRepository;
        this.serviceAuth = serviceAuth;
    }

    @Override
    public PagingInfo<UserNotification> getAllNotice(PageRequest pageable) {
        return PageResponseBuilder.buildPagingData(userNotificationRepository
                .findAll(Specification
                        .where(UserNotificationSpecification
                                    .equality(UserNotification_.USER_ID, serviceAuth.getLoggedUser().getId())), pageable), pageable);
    }
}
