import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';

let counter = 0;

@Injectable()
export class GearService {

   //options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };

  constructor(private httpClient: HttpClient) { }

     /******************************** Gear Action  ********************************/

  addGear(gear: any) : Observable<any> {
    let url = environment.baseUrl + '/api/gear';
    console.log(url);
    console.log(gear);
    console.log(this.options);
    return this.httpClient.post(url,gear,this.options);
  }

  listGear() : Observable<any> {
    let url = environment.baseUrl + '/api/gear/list';
    return this.httpClient.get(url,this.options);
  }

  listGearPage(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/gear/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  getGearByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/gear/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateGear(gear: any) : Observable<any> {
    let url = environment.baseUrl + '/api/gear';
    return this.httpClient.put(url,gear,this.options);
  }

  deleteGear(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/gear/${code}`;
    return this.httpClient.delete(url,this.options);
  }


  /******************************** Gear Action  ********************************/
}
