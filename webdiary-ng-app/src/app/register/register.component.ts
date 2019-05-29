import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BasicService} from "../shared/basic.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  model: RegisterViewModel = {
    name: '',
    surname: '',
    email: '',
    password: '',
    confirm_password: '',
  };
  confirm_model = {
    name: '',
    surname: '',
    email: '',
    password: ''
  };

  constructor(private  basicService: BasicService) {
  }

  ngOnInit() {
  }

  sendRegisterInfo(): void {
    if (this.validate()) {
      this.basicService.postRegisterNewUser(this.confirm_model).subscribe(
        res => {
          (res) ? location.replace("/navigation") : alert("Rejected");
        },
        err => {
          alert("An error has occured !")
        }
      );
    }

  }

  validate(): boolean {
    if (this.model.password == this.model.confirm_password) {
      this.confirm_model.name = this.model.name;
      this.confirm_model.surname = this.model.surname;
      this.confirm_model.email = this.model.email;
      this.confirm_model.password = this.model.password;
      return true;
    } else {
      return false;
    }
  }

}

export interface RegisterViewModel {
  name: string;
  surname: string;
  email: string;
  password: string;
  confirm_password: string;
}
