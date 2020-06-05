package com.backend.template.service;

import java.util.List;

import com.backend.template.dto.input.UpdateUserInput;
import com.backend.template.dto.output.UserDto;
import org.springframework.stereotype.Service;

import com.backend.template.exception.ServerException;
import com.backend.template.model.User;

@Service
public interface UserService {

    User save(User user);

    UserDto updateUser(UpdateUserInput updateUserInput,long id);

    UserDto getUserById(long id);

    List<User> findAll();

    void delete(long id) throws ServerException;
}
