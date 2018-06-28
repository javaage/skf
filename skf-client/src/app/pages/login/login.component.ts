import { OnInit,Directive,Component} from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../@core/data/data.service';

import { AlarmService } from '../../@core/data/alarm.service';
import {HttpHeaders} from "@angular/common/http";
import {UserService} from "../../@core/data/users.service";
@Component({
  selector: 'authlogin',
  templateUrl: './login.html',
  styleUrls: ['./userLogin.scss']
})

export class LoginComponent implements OnInit  {
  username: string = '';
  password: string = '';

  constructor(private router: Router,
              private translate: TranslateService,
              private dataService: DataService,
              private alarmService: AlarmService,
              private userService:UserService,
  ) {
  }


  ngOnInit() {
    sessionStorage.clear();
    let loadPart = document.getElementById("nb-global-spinner");
    loadPart.style['display'] = 'none';
    console.log("LoginComponent");
  }

  loginClicked(){
    if(this.username==''||this.password==''){
      alert(this.translate.instant("LOGIN_EMPTY"));
    }else{
      this.dataService.login(this.username,this.password).subscribe(
        (val) => {
          if(val.code=='success'){

            sessionStorage.setItem("userCode",val.userCode);
            sessionStorage.setItem("token",val.token);
            sessionStorage.setItem("loginname",this.username);
            sessionStorage.setItem("username",val.username);
            sessionStorage.setItem("userimage",val.image);
            sessionStorage.setItem("userRoleId",val.userRoleId);
            this.dataService.options  = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };
            this.alarmService.options  = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };
            this.userService.options  = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };
            this.userService.users={
              user: { name: sessionStorage.getItem("username"), picture:  sessionStorage.getItem("userimage") }
            };
            this.router.navigate(['pages']);


          }else{
            alert(this.translate.instant("LOGIN_WRONG"));
          }
        },
        response => {
          console.log("login call in error", response);
        },
        () => {
          console.log("login observable is now completed.");
        }
      );
    }
  }
}
