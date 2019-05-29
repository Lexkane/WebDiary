package com.CS_Diary.service;

import com.CS_Diary.DTO.UserDTO;
import java.util.List;

public interface UserService {

  List<UserDTO> getAll();

  UserDTO getByID(long id);

  UserDTO getByEmail(String email);

  void deleteByID(long id);

  void update(UserDTO userDTO);

  void insert(UserDTO userDTO);

}
