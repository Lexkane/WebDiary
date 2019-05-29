package com.CS_Diary.service.impl;

import com.CS_Diary.DTO.DiaryDTO;
import com.CS_Diary.repository.DiaryRepository;
import com.CS_Diary.service.DiaryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {

  @Autowired
  DiaryRepository diaryRepository;

  @Override
  public List<DiaryDTO> getAllById(long id) {
    return diaryRepository.findByUser_Id(id)
        .stream()
        .map(DiaryDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteById(Long id) {
    diaryRepository.deleteById(id);
  }

  @Override
  public void update(DiaryDTO diaryDTO) {
    diaryRepository
        .updateDiary(diaryDTO.getId(), diaryDTO.getDiaryName(), diaryDTO.getDiaryText(),
            diaryDTO.getUser_id());
  }

  @Override
  public void insert(DiaryDTO diaryDTO) {
    diaryRepository
        .insertDiary(diaryDTO.getDiaryName(), diaryDTO.getDiaryText(), diaryDTO.getUser_id());
  }

}
