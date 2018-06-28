import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import  { UserManageService } from '../../../@core/data/usersamanage.service';
import { activePath } from '../activePath';
import { LocalStorageService } from 'angular-2-local-storage';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  private userListData: any[] = [];
  private currentPageNum: number = 0;
  private totalPageNum: number = 0;
  userDelCodes : any = [];
  userCodeCheck : any = [];
  page : any = {};
  loginUserCode = sessionStorage.getItem('userCode');
  loginUserRoleId =  sessionStorage.getItem("userRoleId");
  // trans = [];


  constructor(
    private userManageService : UserManageService,
    private translateService: TranslateService,
    private localStorageService : LocalStorageService,
    private router: Router) {
  }

  ngOnInit() {
    this.getInitPageUserList();

    console.log("init  :" + this.loginUserCode);
    console.log("init :" + this.loginUserRoleId);

    // this.translateService.get(['DELETE_CONFIRM'])
    //   .subscribe(val => {
    //     this.trans = val;
    //   });

  }

  onClickEdit(row){
    console.log("onClickEdit :" +row.code);
    activePath.code = row.code;
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/users/user');
    }, 100);
  }

  onClickDeletes() {
    if (confirm(this.translateService.instant('DELETE_CONFIRM'))) {
      console.log("onClickDelete :" + this.userDelCodes);
      this.userManageService.deleteUsers(this.userDelCodes).subscribe((data) => {
        console.log("deleteUser, response:", data);
        this.getInitPageUserList();
      }, (error) => {
        console.log("deleteUser error:", error);
      });
    }
  }

  onClickDelete(row) {
    if (confirm(this.translateService.instant('DELETE_CONFIRM'))) {
      console.log("onClickDelete :", row.code);

      this.userManageService.deleteUser(row.code).subscribe((data) => {
        console.log("deleteUser, response:", data);
        this.getInitPageUserList();
      }, (error) => {
        console.log("deleteUser error:", error);
      });
    }
  }

  checkedAll(){
    console.log("checkedAll :", this.userCodeCheck);

  }

  checkBoxChange(check,code){
    console.log("checkBoxChange request information : " ,  check,code);

  }


  selectUserCheckbox(check,code){
    console.log("selectOemCheckbox request information : " ,  check,code);
    let index:number = this.userDelCodes.indexOf(code);
    if(check){
      if(index<0){
        this.userDelCodes.push(code);
        console.log("selectOemCheckbox request information : " ,  this.userDelCodes);
      }
    }else{
      this.userDelCodes = this.userDelCodes.filter((ele,index)=>{
        return ele != code;
      })
      console.log("selectOemCheckbox request information : " ,  this.userDelCodes);
    }
  }



  getInitPageUserList(){
        this.getUserList(this.currentPageNum);
  }

  getUserList(currentPageNum){
    console.log("getUserList, response currentPageNum:",currentPageNum);
    this.userManageService.getUserListPage(currentPageNum,this.loginUserCode).subscribe((data)=>{
      console.log("getUserList, response:",data);
      if(data.code==1){
        this.page=data.data;
      }else{
        console.log("getUserList, response error msg::",data);
      }
    });
  }

    pageChange(pageNum) {
      console.log("pageChange, rquest::",pageNum);
    // 获取Alarm Table List By filter
    this.getUserList(pageNum+1);
  }

  openAddPage(){
    this.cleanActivePath();
    this.router.navigate(['/pages/users/user']);
  }

  onClickChangePW(){
    console.log("onClickEdit :" +this.userDelCodes);
    if(this.userDelCodes==null || this.userDelCodes==''){
      alert('Please checked a user!!');
    }else if(this.userDelCodes=='1'){
      alert('Can not change superAdmin password!!');
    }else{
      activePath.code = this.userDelCodes;
      this.saveActivePath();
      setTimeout(() => {
        this.router.navigateByUrl('/pages/users/user-resetps');
      }, 100);
    }
  }



  saveActivePath(){
    this.localStorageService.set('activePath', activePath);
  }
  cleanActivePath(){
    this.localStorageService.set('activePath', null);
  }
}
