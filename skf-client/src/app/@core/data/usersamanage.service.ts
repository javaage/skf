import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

let counter = 0;

@Injectable()
export class UserManageService {

   options = { headers: new HttpHeaders({ 'Content-Type': 'application/json','Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname") }) };

  constructor(private httpClient: HttpClient) { }
  /******************************** User Action  ********************************/

  addUser(user: any) : Observable<any> {
    let url = environment.baseUrl + '/api/user';
    console.log(url);
    console.log(user);
    console.log(this.options);
    return this.httpClient.post(url,user,this.options);
  }

  getUserList() : Observable<any> {
    let url = environment.baseUrl + '/api/user/list';
    return this.httpClient.get(url,this.options);
  }

  getUserListPage(currentPage : String,loginUserCode:String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/list/${currentPage}/${loginUserCode}`;
    return this.httpClient.get(url,this.options);
  }

  checkUserInfo(user: any) : Observable<any> {
    let url = environment.baseUrl + `/api/user/checkInfo`;
    return this.httpClient.post(url,user,this.options);
  }



  getUserByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateUser(user: any) : Observable<any> {
    let url = environment.baseUrl + '/api/user';
    return this.httpClient.put(url,user,this.options);
  }

  deleteUser(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  deleteUsers(code : any) : Observable<any> {
    let url = environment.baseUrl + `/api/user/dels/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  getUserListData(params: any) : Observable<any> {
    let url = "assets/mock/getAlarmListData.json";
    return this.httpClient.get(url,this.options);
  }


  /******************************** User Action  ********************************/
}
