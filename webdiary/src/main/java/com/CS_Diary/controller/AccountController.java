package com.CS_Diary.controller;

import com.CS_Diary.DTO.UserDTO;
import com.CS_Diary.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accountInfo")
@CrossOrigin
public class AccountController {

  @Autowired
  UserService userService;

  @GetMapping("/getAll")
  public List<UserDTO> getAll() {
    return userService.getAll();
  }

  @GetMapping("/getById")
  public UserDTO getById(long id) {
    return userService.getByID(id);
  }
}
