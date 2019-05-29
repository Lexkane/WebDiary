import {Component, OnChanges, OnInit} from '@angular/core';
import {Diary} from "./model/diary";
import {BasicService} from "../shared/basic.service";
import {DiaryEditorService} from "../shared/diary-editor.service";

@Component({
  selector: 'app-diary',
  templateUrl: './diary.component.html',
  styleUrls: ['./diary.component.css']
})
export class DiaryComponent implements OnInit {
  diaries: Diary[] = [];
  mockDiary: Diary = {
    id: null,
    diaryName: "New Diary",
    diaryText: "Test text of new Diary",
    user_id: "1"
  };

  constructor(private basicService: BasicService,private diaryEditor: DiaryEditorService) {
  }

  ngOnInit() {
    this.getAllDiary();
  }

  public getAllDiary() {
    this.basicService.getUserDiaries().subscribe(
      res => {
        this.diaries = res;
      },
      err => {
        this.diaries.push(this.mockDiary);
        // alert("An error has occured !");
      }
    );

  }

  public deleteDiary(diary: Diary) {
    this.basicService.deleteUserDiary(diary.id).subscribe(
      res => {
        let indexOfDiary = this.diaries.indexOf(diary);
        this.diaries.splice(indexOfDiary, 1);
      },
      err => {
        alert("Houston we have a problem! \n Exception when delete ")

      }
    );
  }

  //res need to modify ngOnInit temporary solution
  createDiary() {
    let newDiary: Diary = {
        id: null,
        diaryName: "New Diary",
        diaryText: "Test text of new Diary",
        user_id: "1"
      };
    this.basicService.createUserDiary(newDiary).subscribe(
      res => {
        this.ngOnInit();
      },
      err => {
        alert("Houston we have a problem! \n Exception when delete ")

      }
    );
  }

  sendToEditor(param: Diary) {
    this.diaryEditor.setDiary(param);
  }
}
