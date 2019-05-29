package com.CS_Diary.DTO;

public class SignInDTO {

  private String email;
  private String password;

  public SignInDTO() {
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

  @Override
  public String toString() {
    return "SignInDTO{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
