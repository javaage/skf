import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class AlarmService {

  constructor(private httpClient: HttpClient) { }
  options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };
  getAlarmTotalData() : Observable<any> {
    // let url = "assets/mock/getAlarmTotalData.json";
    let url = environment.baseAlarmUrl + `/api/alarm/counts`;
    return this.httpClient.get(url,this.options);
  }

  getDropdownFilterData() : Observable<any> {
    // let url = "assets/mock/getDropdownFilterData.json";
    let url = environment.baseAlarmUrl + `/api/alarm/dropdowns`;
    return this.httpClient.get(url,this.options);
  }

  getAlarmListData(body: any) : Observable<any> {
    // let url = "assets/mock/getAlarmListData.json";
    // return this.httpClient.get(url);
    let url = environment.baseAlarmUrl + `/api/alarm/alarms`;
    return this.httpClient.post(url, body,this.options);
  }

  getAlarmDetailData(body: any) : Observable<any> {
    // let url = "assets/mock/getAlarmDetailData.json";
    // return this.httpClient.get(url);
    let url = environment.baseAlarmUrl + `/api/alarm/alarmDetails`;
    return this.httpClient.post(url, body,this.options);
  }

  getSpectrogramData(body: any) : Observable<any> {
    // let url = "assets/mock/getSpectrogramData.json";
    // return this.httpClient.get(url);
    let url = environment.baseAlarmUrl + `/api/alarm/alarmFreq`;
    return this.httpClient.post(url, body,this.options);
  }

  getNotesListData(params: any) : Observable<any> {
    // let url = "assets/mock/getNotesListData.json";
    let url = environment.baseAlarmUrl + `/api/alarm/comments/${params.rowId}/${params.alarmType}`;
    return this.httpClient.get(url, this.options);
  }

  saveNoteMessage(body: any) : Observable<any> {
    let url = environment.baseAlarmUrl + `/api/alarm/comment`;
    return this.httpClient.post(url, body,this.options);
  }

  doAlarmProcess(body: any) : Observable<any> {
    let url = environment.baseAlarmUrl + `/api/alarm/claim`;
    return this.httpClient.post(url, body,this.options);
  }

  stopAlarmProcess(body: any) : Observable<any> {
    let url = environment.baseAlarmUrl + `/api/alarm/terminate`;
    return this.httpClient.post(url, body,this.options);
  }

  reHandleAlarmProcess(body: any) : Observable<any> {
    let url = environment.baseAlarmUrl + `/api/alarm/reopen`;
    return this.httpClient.post(url, body,this.options);
  }

  saveAlarmDangerLevel(body: any) : Observable<any> {
    let url = environment.baseAlarmUrl + `/api/alarm/updateDangerLevel`;
    return this.httpClient.post(url, body,this.options);
  }

  deleteAlarmProcess(body: any) : Observable<any> {
    let url = environment.baseAlarmUrl + `/api/alarm/remove`;
    return this.httpClient.post(url, body,this.options);
  }
}
