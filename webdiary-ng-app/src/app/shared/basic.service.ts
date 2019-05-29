import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Diary} from "../diary/model/diary";
import {SignInViewModel} from "../signin/sign-in.component";

@Injectable({
  providedIn: 'root'
})
export class BasicService {
  private BASE_URL = "http://localhost:8080/api";
  private ALL_DIARIES = `${this.BASE_URL}\\diary\\getAllDiaryByUserId?id=1`;
  private UPDATE_DIARY = `${this.BASE_URL}\\diary\\updateDiary`;
  private DELETE_DIARY = `${this.BASE_URL}\\diary\\deleteDiaryById?id=`;
  private CREATE_DIARY = `${this.BASE_URL}\\diary\\createDiary`;
  private REGISTER_URL = `${this.BASE_URL}\\register`;
  private SIGN_IN_URL = `${this.BASE_URL}\\sign-in`;


  constructor(private http: HttpClient) {

  }

  getUserDiaries(): Observable<Diary[]> {
    return this.http.get<Diary[]>(this.ALL_DIARIES);
  }

  deleteUserDiary(id: String): Observable<any> {
    return this.http.delete((this.DELETE_DIARY + id));

  }

  updateUserDiary(diary: Diary): Observable<any> {
    return this.http.put(this.UPDATE_DIARY,diary);
  }

  createUserDiary(diary: Diary): Observable<any> {
    return this.http.post(this.CREATE_DIARY, diary);
  }

  postRegisterNewUser(user: Object): Observable<any> {
    return this.http.post(this.REGISTER_URL, user);
  }

  postSignInInfo(user: SignInViewModel): Observable<any> {
    return this.http.post(this.SIGN_IN_URL, user);
  }
}
