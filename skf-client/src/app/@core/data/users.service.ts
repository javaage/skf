import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

let counter = 0;

@Injectable()
export class UserService {

   options = { headers: new HttpHeaders({ 'Content-Type': 'application/json','Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname") }) };

  users = {
    user: { name: sessionStorage.getItem("username"), picture:  sessionStorage.getItem("userimage") }
  };
  private usersList: any[] = [];


  private userArray: any[];

  constructor(private httpClient: HttpClient) { }

 // constructor() {
    // this.userArray = Object.values(this.users);
  //}

  getUsers(): Observable<any> {
    return Observable.of(this.users);
  }

  getUserArray(): Observable<any[]> {
    return Observable.of(this.userArray);
  }

  getUser(): Observable<any> {
    counter = (counter + 1) % this.userArray.length;
    return Observable.of(this.userArray[counter]);
  }

  getRootUrl() : Observable<any> {
    return Observable.of('../../../../assets/images/cover1.jpg');
  }

  getChildrenUrls() : Observable<any[]> {
    return Observable.of([{image: '../../../../assets/images/kitten-cosmic.png',posX: '5%', posY:'5%', angle:0,width:'20%',height:'20%'},
            {image: '../../../../assets/images/kitten-default.png',posX: '40%', posY:'40%', angle:90,width:'20%',height:'20%'},
            {image: 'data:image/png;base64,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',posX: '60%', posY:'60%', angle:300,width:'20%',height:'20%'}]);
  }

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

  getUserListPage(currentPage : String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/list/${currentPage}`;
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
    let url = environment.baseUrl + `/api/user/del/${code}`;
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
