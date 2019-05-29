package com.CS_Diary.controller;

import com.CS_Diary.DTO.DiaryDTO;
import com.CS_Diary.service.DiaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diary")
@CrossOrigin
public class DiaryController {

  @Autowired
  DiaryService diaryService;

  @GetMapping("/getAllDiaryByUserId")
  public List<DiaryDTO> getAllDiaries(long id) {
    return diaryService.getAllById(id);
  }

  @PostMapping("/createDiary")
  public void createNewDiary(@RequestBody DiaryDTO diaryDTO) {
    diaryService.insert(diaryDTO);
  }

  @PutMapping("/updateDiary")
  public void updateDiary(@RequestBody DiaryDTO diaryDTO) {
    diaryService.update(diaryDTO);
  }

  @DeleteMapping("/deleteDiaryById")
  public void deleteByName(Long id) {
    diaryService.deleteById(id);
  }

}
