import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import  { BearingService } from '../../../@core/data/bearing.service';
import { LocalStorageService } from 'angular-2-local-storage';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'bearing-list',
  templateUrl: './bearing-list.component.html',
  styleUrls: ['./bearing-list.component.scss']
})
export class BearingListComponent implements OnInit {
  code : any = '';
  private bearingListData: any[] = [];
  private currentPageNum: number = 1;
  private totalPageNum: number = 0;
  page : any = {};
  //trans = [];

  constructor(
    private bearingService : BearingService,
    private translateService: TranslateService,
    private localStorageService : LocalStorageService,
    private router: Router) {
  }

  ngOnInit() {
    this.getPageInitBearingList();

    // this.translateService.get(['DELETE_CONFIRM'])
    //   .subscribe(val => {
    //     this.trans = val;
    //   });
  }

  onClickEdit(row){
    console.log("onClickEdit :" +row.code);
    this.code = row.code;
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/device/bearing');
    }, 100);
  }

  onClickDelete(row) {
    if (confirm(this.translateService.instant('DELETE_CONFIRM') )) {
      console.log("onClickDelete :", row.code);
      this.deleteBearing(row.code);
    }
  }

  deleteBearing(code){
    this.bearingService.deleteBearing(code).subscribe((data) => {
      console.log("deleteBearing, response:", data);
      this.getPageInitBearingList();
    }, (error) => {
      console.log("deleteBearing error:", error);
    });
  }


  onClicCancle() {
    console.log("onClickDelete :");
    this.router.navigateByUrl('/pages/device/component');
  }

  getPageInitBearingList(){
    this.getBearingList(this.currentPageNum);
  }

  getBearingList(parm){
    console.log("getBearingList, request :",parm);
    if(parm==0){
      parm=1;
    }
    this.bearingService.listBearingPage(parm).subscribe((data)=>{
      console.log("getBearingList, response:",data);
      this.page = data.data;
      console.log("getGearList, response page:",this.page);
    });
  }

    pageChange(pageNum) {
    this.currentPageNum = pageNum;
    // 获取Alarm Table List By filter
    this.getBearingList(pageNum);
  }

  openAddPage(){
    this.cleanActivePath();
    this.router.navigate(['/pages/device/bearing']);
  }

  saveActivePath(){
    this.localStorageService.set('bearingcode', this.code);
  }
  cleanActivePath(){
    this.localStorageService.set('bearingcode', null);
  }
}
