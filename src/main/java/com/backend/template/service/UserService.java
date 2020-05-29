package com.backend.template.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.backend.template.exception.ServerException;
import com.backend.template.model.User;

@Service
public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id) throws ServerException;
}
