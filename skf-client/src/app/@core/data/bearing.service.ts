import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';


@Injectable()
export class BearingService {

  //options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };

  constructor(private httpClient: HttpClient) { }

  addBearing(bearing: any) : Observable<any> {
    let url = environment.baseUrl + '/api/bearing';
    console.log(url);
    console.log(bearing);
    console.log(this.options);
    return this.httpClient.post(url,bearing,this.options);
  }

  listBearing() : Observable<any> {
    let url = environment.baseUrl + '/api/bearing/list';
    return this.httpClient.get(url,this.options);
  }

  listBearingPage(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/list/${code}`;
    return this.httpClient.get(url,this.options);
  }


  getBearingByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateBearing(bearing: any) : Observable<any> {
    let url = environment.baseUrl + '/api/bearing';
    return this.httpClient.put(url,bearing,this.options);
  }

  deleteBearing(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  listBearingByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  listBearingByModel(modelNumber) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/listOdbModel/${modelNumber}`;
    return this.httpClient.get(url,this.options);
  }


}
