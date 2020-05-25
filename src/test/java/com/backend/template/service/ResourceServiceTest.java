package com.backend.template.service;

import com.backend.template.model.ClientSetting;
import com.backend.template.paging.PagingInfo;
import com.backend.template.utils.Utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void testGetClientSettingWithFilterNoResult(){
        String name = "aa";
        PageRequest pageable = PageRequest.of(0, 10, Sort.by(Utils.getOrderFieldsOfRequest("")));
        PagingInfo<ClientSetting> clientSettingPagingInfo = resourceService.getAllClientSettings(name, pageable);
        assertEquals(clientSettingPagingInfo.getContents().size(), 0);
    }
    
    @Test
    public void testGetClientSettingWithFilter(){
        String name = "hello";
        PageRequest pageable = PageRequest.of(0, 10, Sort.by(Utils.getOrderFieldsOfRequest("")));
        PagingInfo<ClientSetting> clientSettingPagingInfo = resourceService.getAllClientSettings(name, pageable);
        assertEquals(clientSettingPagingInfo.getContents().size(), 1);
    }
    
}
