package com.backend.template.service;

import com.backend.template.model.UserNotification;
import com.backend.template.paging.PagingInfo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserNotificationService {
    PagingInfo<UserNotification> getAllNotice(long userId, PageRequest pageable);
}
