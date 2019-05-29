import {Component, OnInit} from '@angular/core';
import {Diary} from "../diary/model/diary";
import {DiaryEditorService} from "../shared/diary-editor.service";
import {BasicService} from "../shared/basic.service";
import {Route, Router} from "@angular/router";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {
  public diary: Diary;

  constructor(private diaryEditor: DiaryEditorService,private basicService:BasicService,private router: Router) {
  }

  ngOnInit() {
    this.diary = this.diaryEditor.getDiary();
  }

  saveChanges() {
    this.basicService.updateUserDiary(this.diary).subscribe(
      res=>{
        this.router.navigate(['./navigation/diary'])
      },
      err =>{
        alert("Houston we have a problem! \n Exception when update ")
      }
    );
  }
}
