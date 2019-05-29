package com.CS_Diary.DTO;

import com.CS_Diary.model.Diary;


public class DiaryDTO {

  private long id;
  private String diaryName;
  private String diaryText;
  private long user_id;


  public DiaryDTO(long id, String diaryName, String diaryText, long user_id) {
    this.id = id;
    this.diaryName = diaryName;
    this.diaryText = diaryText;
    this.user_id = user_id;
  }

  public DiaryDTO(Diary diary) {
    this.id = diary.getId();
    this.diaryName = diary.getDiaryName();
    this.diaryText = diary.getDiaryText();
    this.user_id = diary.getUser().getId();
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

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }
}
