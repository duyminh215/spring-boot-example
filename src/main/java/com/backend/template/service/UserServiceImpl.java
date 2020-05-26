package com.backend.template.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.template.dto.UserDetailCustomDto;
import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.dto.output.UserDto;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.locale.Translator;
import com.backend.template.model.User;
import com.backend.template.repositories.UserRepository;
import com.backend.template.utils.EmailValidation;
import com.backend.template.utils.PhoneValidation;
import com.backend.template.validators.UserValidator;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidator userValidator;
	
	public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
    	User user = null;
    	if(EmailValidation.isValidEmailAddress(username)) {
    		user = userRepository.findUserByEmail(username);
    	}else if(PhoneValidation.isValidPhone(username)){
    		user = userRepository.findUserByPhone(username);
    	}
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        UserDetailCustomDto userDetailCustomDto = new UserDetailCustomDto(user.getId() + "", user.getPassword(), true, true, true, true, getAuthority(), user.getId());
        
        return userDetailCustomDto;
    }
    
    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
    	userRepository.deleteById(id);
    }
    
    public UserDto signUpByEmailOrPhone(CreateUserInput createUserInput) throws Exception{
    	validateSignUpByEmailOrPhone(createUserInput);
    	User user = createNewInstanceUser(createUserInput);
    	userRepository.save(user);
    	return createDto(user);
    }
    
    private void validateSignUpByEmailOrPhone(CreateUserInput createUserInput)  throws Exception{
    	userValidator.validateCreateUser(createUserInput);
    	User existedEmail = userRepository.findUserByEmail(createUserInput.getEmail());
    	if(existedEmail != null && existedEmail.getEmail() != null) {
    		throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.existed_email"));
    	}
    	
    	User existedPhone = userRepository.findUserByPhone(createUserInput.getPhone());
    	if(existedPhone != null && existedPhone.getPhone() != null) {
    		throw new RequestInvalidException(Translator.toLocale("error.msg.create_user.existed_phone"));
    	}
    }
    
    private User createNewInstanceUser(CreateUserInput createUserInput) {
    	User user = new User(createUserInput.getEmail(), createUserInput.getFullName(), createUserInput.getPhone());
    	String encodePassword = passwordEncoder().encode(createUserInput.getPassword());
    	user.setPassword(encodePassword);
    	return user;
    }
    
    private UserDto createDto(User user) {
    	UserDto userDto = new UserDto();
    	userDto.loadDataFromModel(user);
    	return userDto;
    }
}
