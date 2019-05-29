package com.CS_Diary.repository;

import com.CS_Diary.model.Diary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

  List<Diary> findByUser_Id(long id);

  @Modifying
  @Query(value = "insert into diary ( diary_name , diary_text, user_id) values (?1, ?2, ?3);",
      nativeQuery = true)
  @Transactional
  void insertDiary(String name,
      String text, Long user_id);

  @Modifying
  @Query(value = "update  diary set  diary_name = :name, diary_text =:text where user_id = :user_id and diary_id = :diary_id",
      nativeQuery = true)
  @Transactional
  void updateDiary(@Param("diary_id") Long id, @Param("name") String name,
      @Param("text") String text, @Param("user_id") Long user_id);

}
