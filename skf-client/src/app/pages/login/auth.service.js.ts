import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class AuthCheckService implements CanActivate {

  constructor(public router: Router) {}

  canActivate(): boolean {
    let token = sessionStorage.getItem("token");
    if(token=='null'||token==null||token==""||token==undefined){
      this.router.navigate(['authlogin']);
      return false;
    }
    return true;
  }

}
