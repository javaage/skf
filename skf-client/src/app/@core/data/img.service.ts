import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';


@Injectable()
export class ImgService {

  //options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };

  constructor(private httpClient: HttpClient) { }

  listImgByType(type : number) : Observable<any> {
    let url = environment.baseUrl + `/api/image/list/${type}`;
    return this.httpClient.get(url,this.options);
  }
  addImg(img: any) : Observable<any> {
    let url = environment.baseUrl + '/api/image';
    console.log(url);
    console.log(img);
    console.log(this.options);
    return this.httpClient.post(url,img,this.options);
  }

  listImg() : Observable<any> {
    let url = environment.baseUrl + '/api/image/list';
    return this.httpClient.get(url,this.options);
  }

  getImgByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/image/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateImg(img: any) : Observable<any> {
    let url = environment.baseUrl + '/api/img';
    return this.httpClient.put(url,img,this.options);
  }

  deleteImg(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/image/${code}`;
    return this.httpClient.delete(url,this.options);
  }


}
