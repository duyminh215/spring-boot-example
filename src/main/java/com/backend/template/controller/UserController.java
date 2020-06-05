package com.backend.template.controller;

import java.util.List;

import com.backend.template.dto.input.UpdateUserInput;
import com.backend.template.dto.output.UserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.model.User;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.UserServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private ResponseFactory responseFactory;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> listUser() {
        return userService.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "success";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<?> signUpByEmailOrPhone(@RequestBody CreateUserInput createUserInput) throws Exception {
        return responseFactory.success(userService.signUpByEmailOrPhone(createUserInput));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserInput updateUserInput){
        UserDto userDto = userService.updateUser(updateUserInput,getLoginedUser().getId());
        return responseFactory.success(userDto);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getUserById(){
        UserDto userDto = userService.getUserById(getLoginedUser().getId());
        return responseFactory.success(userDto);
    }
}
