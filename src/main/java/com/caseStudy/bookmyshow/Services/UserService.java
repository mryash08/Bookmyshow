package com.caseStudy.bookmyshow.Services;

import com.caseStudy.bookmyshow.Models.User;
import com.caseStudy.bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User Signup(String Email , String Password){

           User user = new User();
           user.setEmail(Email);
           user.setPassword(Password);

           User savedUser = userRepository.save(user);
           return savedUser;
    }
}
