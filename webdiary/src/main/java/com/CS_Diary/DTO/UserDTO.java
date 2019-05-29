package com.CS_Diary.DTO;

import com.CS_Diary.model.Diary;
import com.CS_Diary.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {


  private long id;
  private String name;
  private String surname;
  private String email;
  private String password;
  private List<DiaryDTO> diaries;

  public UserDTO(
      String name,
      String surname,
      String email,
      String password
  ) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
  }

  public UserDTO(
      long id,
      String name,
      String surname,
      String email,
      String password,
      List<DiaryDTO> diaries
  ) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.diaries = diaries;
  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.surname = user.getSurname();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.diaries = user.getDiaries()
        .stream()
        .map(DiaryDTO::new)
        .collect(Collectors.toList());
  }

  public User toUser() {
    User user = new User();
    user.setId(id);
    user.setName(name);
    user.setSurname(surname);
    user.setEmail(email);
    user.setPassword(password);
    if (diaries != null) {
      user.setDiaries(
          diaries.stream()
              .map(a -> new Diary(a.getId(), a.getDiaryName(), a.getDiaryText(), user))
              .collect(Collectors.toList()));
    }
    return user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<DiaryDTO> getDiaries() {
    return diaries;
  }

  public void setDiaries(List<DiaryDTO> diaries) {
    this.diaries = diaries;
  }


  @Override
  public String toString() {
    return "UserDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", diaries=" + diaries +
        '}';
  }
}
