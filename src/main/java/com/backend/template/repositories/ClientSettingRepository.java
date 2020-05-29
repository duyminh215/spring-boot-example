package com.backend.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.backend.template.model.ClientSetting;

@Repository
public interface ClientSettingRepository
        extends JpaRepository<ClientSetting, Integer>, JpaSpecificationExecutor<ClientSetting> {

    ClientSetting findByName(String name);
}
