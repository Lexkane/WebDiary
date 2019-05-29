package com.CS_Diary.service.impl;

import com.CS_Diary.DTO.UserDTO;
import com.CS_Diary.repository.UserRepository;
import com.CS_Diary.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  public List<UserDTO> getAll() {
    return userRepository.findAll()
        .stream()
        .map(UserDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public UserDTO getByID(long id) {
    return userRepository.findById(id)
        .map(UserDTO::new)
        .get();
  }

  @Override
  public UserDTO getByEmail(String email) {
    return new UserDTO(userRepository.findByEmail(email));
  }


  @Override
  public void deleteByID(long id) {
    userRepository.deleteById(id);
  }

  @Override
  public void update(UserDTO userDTO) {
    userRepository.save(userDTO.toUser());
  }

  @Override
  public void insert(UserDTO userDTO) {
    userRepository.save(userDTO.toUser());
  }

}
