package com.CS_Diary.controller;

import com.CS_Diary.DTO.SignInDTO;
import com.CS_Diary.DTO.UserDTO;
import com.CS_Diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sign-in")
@CrossOrigin
public class SignInController {

  @Autowired
  UserService userService;

  @PostMapping
  public boolean checkAccount(@RequestBody SignInDTO signInDTO) {
    return validate(signInDTO);
  }


  private boolean validate(SignInDTO signInDTO) {
    if (userService.getByEmail(signInDTO.getEmail()) == null) {
      return false;
    } else {
      UserDTO user = userService.getByEmail(signInDTO.getEmail());
      if (user.getEmail().equals(signInDTO.getEmail())
          &&
          user.getPassword().equals(signInDTO.getPassword())
      ) {
        return true;
      }
    }
    return false;
  }
}
