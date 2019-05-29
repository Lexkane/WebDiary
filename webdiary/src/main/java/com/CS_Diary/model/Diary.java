package com.CS_Diary.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Diary {

  @Id
  @Column(name = "diary_id")
  private long id;
  @Column(name = "diary_name")
  private String diaryName;
  @Column(name = "diary_text",columnDefinition = "LONGTEXT")
  private String diaryText;
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  private User user;

  public Diary() {
  }

  public Diary(
      long id,
      String diaryName,
      String diaryText,
      User user
  ) {
    this.id = id;
    this.diaryName = diaryName;
    this.diaryText = diaryText;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDiaryName() {
    return diaryName;
  }

  public void setDiaryName(String diaryName) {
    this.diaryName = diaryName;
  }

  public String getDiaryText() {
    return diaryText;
  }

  public void setDiaryText(String diaryText) {
    this.diaryText = diaryText;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Diary)) {
      return false;
    }
    Diary diary = (Diary) o;
    return id == diary.id &&
        diaryName.equals(diary.diaryName) &&
        diaryText.equals(diary.diaryText) &&
        user.equals(diary.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, diaryName, diaryText, user);
  }

}
