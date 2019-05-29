import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BasicService} from "../shared/basic.service";

@Component({
  selector: 'app-signin',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  model: SignInViewModel = {
    email: '',
    password: ''
  };

  constructor(private  basicService:BasicService) {
  }

  ngOnInit() {
  }

  sendSignInInfo(): void {
    this.basicService.postSignInInfo(this.model).subscribe(
      res => {
        (res) ? location.replace("/navigation") : alert("Wrong data");
      },
      err => {
        alert("An error has occured !");
      }
    );
  }
}

export interface SignInViewModel {
  email: string;
  password: string;
}
