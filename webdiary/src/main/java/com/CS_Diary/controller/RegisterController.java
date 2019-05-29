package com.CS_Diary.controller;

import com.CS_Diary.DTO.RegisterDTO;
import com.CS_Diary.DTO.UserDTO;
import com.CS_Diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@CrossOrigin
public class RegisterController {

  @Autowired
  UserService userService;

  @PostMapping
  public boolean registerAccount(@RequestBody RegisterDTO registerDTO) {
    try{
      UserDTO userDTO = new UserDTO(
          registerDTO.getName(), registerDTO.getSurname(),
          registerDTO.getEmail(), registerDTO.getPassword()
      );
      userService.insert(userDTO);
      return true;
    }catch (Exception ex){
      System.out.println(ex.getMessage());
      return false;
    }
  }
}
