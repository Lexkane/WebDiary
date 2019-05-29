package com.CS_Diary.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

  @Id
  @Column(name = "user_id")
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "surname")
  private String surname;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @OneToMany(mappedBy = "user")
  private List<Diary> diaries;

  public User() {
  }

  public User(
      long id,
      String name,
      String surname,
      String email,
      String password,
      List<Diary> diaries
  ) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.diaries = diaries;
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

  public List<Diary> getDiaries() {
    return diaries;
  }

  public void setDiaries(List<Diary> diaries) {
    this.diaries = diaries;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return id == user.id &&
        name.equals(user.name) &&
        surname.equals(user.surname) &&
        email.equals(user.email) &&
        password.equals(user.password) &&
        diaries.equals(user.diaries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, email, password, diaries);
  }


}
