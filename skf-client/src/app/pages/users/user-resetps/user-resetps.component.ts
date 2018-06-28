import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {TranslateService} from '@ngx-translate/core';
import { UserManageService } from '../../../@core/data/usersamanage.service';
import { activePath } from '../activePath';
import { LocalStorageService } from 'angular-2-local-storage';
import { Constant } from '../../../@core/data/constant';


@Component({
  selector: 'user-resetps',
  templateUrl: './user-resetps.component.html',
  styleUrls: ['./user-resetps.component.scss']
})
export class UserResetPSComponent implements OnInit {

  constructor(private userManageService: UserManageService,
              private router: Router,
              private localStorageService : LocalStorageService) {
  }

  userCode: string;
  user : any = {};
  errorMsg : any = {};
  loginUser : any = {};


   ngOnInit() {

     if(this.localStorageService.get('activePath')==null){

     }else{
       activePath.load(this.localStorageService.get('activePath'));
       console.log("activePath  information :" + activePath);
       this.user.code = activePath.code;
       console.log("ngOnInit user information :" + this.user.code);

       if(this.user.code){
         this.userManageService.getUserByCode(this.user.code).subscribe((result:any)=>{
           console.log("getUserByCode  information :" + result);
           if(result.code==1){
             this.user = result.data;
             console.log("getUserByCode  information result :",this.user);
             this.userCode = this.user.code;
           }else{
             this.user.code = '';
             console.log('USER does not exsit.');
           }
         });
       }
     }
  }


  submitUser(){
    console.log('submitUser reqeust .',this.user.passwordOne);
    console.log('submitUser request .',this.user.passwordTwo);
    //if(this.user.oldPssword==null || this.user.oldPssword==''){
    //  alert("oldPssword is null!!");
    //  return;
    //}else
    if( this.user.passwordOne==null || this.user.passwordOne==''){
      alert("password One is null!!");
      return;
    }else if(this.user.passwordTwo==null || this.user.passwordTwo==''){
      alert("password Two is null!!");
      return;
    }else if(this.user.passwordOne != this.user.passwordTwo){
      alert("new Password different!");
      return;
    }else
    //if(this.user.oldPssword == this.user.passwordOne){
    //  alert("new Password is same with old one!!");
    //  return;
    //}else
    {
      console.log('submitToUpdUser password :: ' ,this.user.password );
      this.userManageService.updateUser(this.user).subscribe((result:any)=>{
        if(result.code==1){
          console.log(result);
          this.onclickCancel();
        }else{
          this.errorMsg.msg = result.message;
          console.log('USER upload fail.msg: ' ,result.message);
        }
      });
    }
  }

  onclickCancel(){
    console.log("onClickEdit :" +this.user.code);
    activePath.code = this.user.code;
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/users/user');
    }, 100);
  };

  saveActivePath(){
    this.localStorageService.set('activePath', activePath);
  }
  cleanActivePath(){
    this.localStorageService.set('activePath', null);
  }

}
