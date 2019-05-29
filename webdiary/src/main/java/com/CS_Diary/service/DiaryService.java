package com.CS_Diary.service;

import com.CS_Diary.DTO.DiaryDTO;
import java.util.List;

public interface DiaryService {

  List<DiaryDTO> getAllById(long id);

  void deleteById(Long id);

  void update(DiaryDTO diaryDTO);

  void insert(DiaryDTO diaryDTO);
}
