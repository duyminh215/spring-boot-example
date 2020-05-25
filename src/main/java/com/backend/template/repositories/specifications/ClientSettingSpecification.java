package com.backend.template.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.backend.template.model.ClientSetting;
import com.backend.template.model.ClientSetting_;

public final class ClientSettingSpecification {

	public static Specification<ClientSetting> hasName(String name){
		return (root, query, cb) -> cb.equal(root.get(ClientSetting_.name), name);
	}
}
