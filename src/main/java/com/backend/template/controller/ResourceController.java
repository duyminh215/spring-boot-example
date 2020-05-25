package com.backend.template.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.template.exception.ServerException;
import com.backend.template.model.ClientSetting;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.paging.PagingInfo;
import com.backend.template.service.ResourceService;
import com.backend.template.utils.Utils;

@RestController
@RequestMapping("/api")
public class ResourceController extends BaseController{
	private static final Logger logger = LogManager.getLogger(ResourceController.class);
	@Autowired
	private ResponseFactory responseFactory;
    
    @Autowired
    ResourceService resourceService;

    @GetMapping("/client-settings")
    public ResponseEntity<?> getAllClientSettings(@RequestParam(defaultValue = "") String name,
    		@RequestParam(defaultValue = "0") Integer page, 
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String sort) {
    	PageRequest pageable = PageRequest.of(page, size, Sort.by(Utils.getOrderFieldsOfRequest(sort)));
    	PagingInfo<ClientSetting> data = resourceService.getAllClientSettings(name, pageable);
        return responseFactory.success(data);
    }
    
    @GetMapping("/client-settings-test")
    public List<ClientSetting> getClientSettingsTest() throws ServerException {
        return resourceService.getClientSettingsByIds();
    }
}
