import {Injectable} from '@angular/core';
import {Diary} from "../diary/model/diary";

@Injectable({
  providedIn: 'root'
})
export class DiaryEditorService {

  private tempDiary: Diary;

  constructor() {
  }

  setDiary(diary: Diary) {
    this.tempDiary = diary;
  }

  getDiary(): Diary {
    return this.tempDiary;
  }
}
