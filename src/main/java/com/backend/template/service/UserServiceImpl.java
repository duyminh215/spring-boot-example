package com.backend.template.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.template.dto.UserDetailCustomDto;
import com.backend.template.dto.input.CreateUserInput;
import com.backend.template.model.User;
import com.backend.template.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{
    
	@Autowired
	private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepository.findUserByEmail(username);
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
    
    public User signUp(CreateUserInput createUserInput) {
    	return null;
    }
}
