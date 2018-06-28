import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import  { GearService } from '../../../@core/data/gear.service';
import { LocalStorageService } from 'angular-2-local-storage';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'gear-list',
  templateUrl: './gear-list.component.html',
  styleUrls: ['./gear-list.component.scss']
})
export class GearListComponent implements OnInit {

  private gearListData: any[] = [];
  private currentPageNum: number = 0;
  private totalPageNum: number = 0;
  page : any ={};
  //trans = [];
  code: any = '';


  constructor(
    private gearService : GearService,
    private translateService: TranslateService,
    private localStorageService : LocalStorageService,
    private router: Router) {
  }

  ngOnInit() {
    this.getPageInitGearList();

    // this.translateService.get(['DELETE_CONFIRM'])
    //   .subscribe(val => {
    //     this.trans = val;
    //   });
  }

  onClickEdit(row){
    this.code = row.code;

    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/device/gear');
    }, 100);
  }

  onClickDelete(row) {
    if (confirm( this.translateService.instant('DELETE_CONFIRM') )) {
      console.log("onClickDelete :", row.code);

      this.deleteGear(row.code);
    }
  }

  deleteGear(code){
    this.gearService.deleteGear(code).subscribe((data) => {
      console.log("deleteGear, response:", data);
      this.getPageInitGearList();
    }, (error) => {
      console.log("deleteGear error:", error);
    });
  }


  onClicCancle() {
    console.log("onClickDelete :");
    this.router.navigateByUrl('/pages/device/component');
  }

  getPageInitGearList(){
    this.getGearList(this.currentPageNum+1);
  }

  getGearList(parm){
    console.log("getGearList, request :",parm);
    if(parm==0){
      parm=1;
    }
    this.gearService.listGearPage(parm).subscribe((data)=>{
      console.log("getGearList, response:",data);
      this.page = data.data;
      console.log("getGearList, response page:",this.page);

    });
  }

    pageChange(pageNum) {
    this.currentPageNum = pageNum;
    // 获取Alarm Table List By filter
    this.getGearList(pageNum);
  }

  openAddPage(){
    this.cleanActivePath();
    this.router.navigate(['/pages/device/gear']);
  }

  saveActivePath(){
    this.localStorageService.set('gearcode', this.code);
  }
  cleanActivePath(){
    this.localStorageService.set('gearcode', null);
  }
}
