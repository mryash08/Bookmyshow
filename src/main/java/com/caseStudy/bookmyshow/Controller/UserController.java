package com.caseStudy.bookmyshow.Controller;

import com.caseStudy.bookmyshow.DTOs.ResponseStatus;
import com.caseStudy.bookmyshow.DTOs.SignUpRequestDto;
import com.caseStudy.bookmyshow.DTOs.SignupResponsedto;
import com.caseStudy.bookmyshow.Models.User;
import com.caseStudy.bookmyshow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

      private UserService userService;

      @Autowired
      public UserController(UserService userService) {
            this.userService = userService;
      }

      public SignupResponsedto signup(SignUpRequestDto signUpRequestDto){
            SignupResponsedto signupResponsedto = new SignupResponsedto();
            User user;

            try{
                  user = userService.Signup(signUpRequestDto.getEmail(),signUpRequestDto.getPassword());
                  signupResponsedto.setUserID(user.getId());
                  signupResponsedto.setResponseStatus(ResponseStatus.SUCCESS);
            }catch (Exception e){
                  signupResponsedto.setResponseStatus(ResponseStatus.FAILURE);
            }
            return signupResponsedto;
      }
}
