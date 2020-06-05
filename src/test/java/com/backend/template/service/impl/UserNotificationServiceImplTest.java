package com.backend.template.service.impl;

import com.backend.template.model.User;
import com.backend.template.model.UserNotification;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.UserNotificationRepository;
import com.backend.template.repositories.UserRepository;
import com.backend.template.service.ServiceAuth;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserNotificationServiceImplTest {

    @InjectMocks
    UserNotificationServiceImpl userNotificationServiceMock;

    @Mock
    UserNotificationRepository userNotificationRepositoryMock;

    @Mock
    UserRepository userRepositoryMock;

    @Mock
    ServiceAuth serviceAuthMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllNotice() {
        List<UserNotification> userNotificationList = new ArrayList<>();
        UserNotification userNotification = new UserNotification();
        userNotification.setId(1);
        userNotification.setBody("Được của ló");
        userNotification.setCreatedTime(BigInteger.valueOf(2020));
        userNotification.setIsRead((byte) 0);
        userNotification.setParentType(1);
        userNotification.setPushStatus((byte) 1);
        userNotification.setType(1);
        userNotification.setUserId(BigInteger.valueOf(2));
        userNotificationList.add(userNotification);
        PageRequest pageRequest = PageRequest.of(0, 10);
        PagingInfo pagingInfo = new PagingInfo();
        pagingInfo.setSize(10);
        pagingInfo.setTotalElement(1);
        pagingInfo.setTotalPage(1);
        pagingInfo.setCurrentPage(0);
        pagingInfo.setNextPageURL(null);
        pagingInfo.setPreviousPageURL(null);
        pagingInfo.setContents(userNotificationList);
        User user = new User();
        user.setId(2);
        doAnswer(mock -> user).when(serviceAuthMock).getLoggedUser();

//        Mockito.when(userNotificationRepositoryMock.findAll(Specification
//                .where(UserNotificationSpecification
//                        .equality(UserNotification_.USER_ID, 2)), pageRequest)).thenReturn(pagingInfo);

        assertEquals(pagingInfo, userNotificationServiceMock.getAllNotice(pageRequest));
    }

}