package com.backend.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.backend.template.constant.ErrorMessage;
import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.exception.ServerException;
import com.backend.template.model.ClientSetting;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.ClientSettingRepository;
import com.backend.template.repositories.specifications.ClientSettingSpecification;

@Service
@CacheConfig(cacheNames = {"clientSetting"})
public class ResourceService {

	@Autowired
	ClientSettingRepository clientSettingRepository;
    
	@Cacheable(value = "clientSettings", key="{ 'name:' + #name, 'page:' + #pageable.getPageNumber(), 'size:' + #pageable.getPageSize(), 'sort:' + #pageable.getSort().toString() }")
	public PagingInfo<ClientSetting> getAllClientSettings(String name, PageRequest pageable) {
		Specification conditions = null;
		if(!StringUtils.isEmpty(name)) {
			conditions = Specification.where(ClientSettingSpecification.hasName(name)); 
		}
        Page<ClientSetting> clientSettingsPage = clientSettingRepository.findAll(conditions, pageable);
        return PageResponseBuilder.buildPagingData(clientSettingsPage, pageable);
    }
    
    public List<ClientSetting> getClientSettingsByIds() throws ServerException{
        throw new ServerException(ErrorMessage.CUSTOMER_CODE_NOT_FOUND);
    }
}
