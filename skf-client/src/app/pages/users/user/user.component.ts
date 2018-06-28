import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {TranslateService} from '@ngx-translate/core';
import { UserManageService } from '../../../@core/data/usersamanage.service';
import { activePath } from '../activePath';
import { LocalStorageService } from 'angular-2-local-storage';
import { DataService } from '../../../@core/data/data.service';
import { Constant } from '../../../@core/data/constant';


@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  constructor(private userManageService: UserManageService,
              private router: Router,
              private dataService:DataService,
              private localStorageService : LocalStorageService) {
  }

  userCode: string;
  user : any = {};
  userForRpw : any = {};
  roles : any[] = [{code:1,name:"USER_ADMIN"},
    {code:2,name:"USER_NORMAL"}
  ];


  oldName : any ={};
  oldPhone : any ={};
  oldEmail : any ={};

  oems : any[] = [];
  userOems : any[] = [];
  customers : any[] = [];
  userCustomers : any[] = [];
  private oemCheckedList = [];
  private cusCheckedList = [];
  submitFlag : any = false;
  submitCheckFlag : any = false;
  errorMsg : any = {};
  imgValid = true;
  nameValid = true;
  phoneValid = true;
  emailValid = true;

   ngOnInit() {

     if(this.localStorageService.get('activePath')==null){
       this.dataService.listOEM().subscribe((result:any)=>{
         console.log("listOEM  information :" + result);
         if(result.code==1){
           console.log("listOEM  information result :",result.data);
           this.oems = result.data;
         }else{
           console.log('listOEM does not exsit.');
         }
       });
       this.loadCustomerList();

     }else{
       activePath.load(this.localStorageService.get('activePath'));
       console.log("activePath  information :" + activePath);
       this.user.code = activePath.code;
       console.log("ngOnInit user information :" + this.user.code);
       this.submitCheckFlag=true;
       if(this.user.code){
         this.userManageService.getUserByCode(this.user.code).subscribe((result:any)=>{
           console.log("getUserByCode  information :" + result);
           if(result.code==1){
             this.user = result.data;
             console.log("getUserByCode  information result :",this.user);
             this.userCode = this.user.code;
             this.oems = this.user.userOems;
             console.log("getUserByCode oems information :" + this.oems);
             this.customers = this.user.userCustomers;
             console.log("getUserByCode customers information :" + this.customers);
             this.loadImage(this.user.img);

             this.oldName=this.user.name;
             this.oldPhone=this.user.phone;
             this.oldEmail=this.user.email;

             console.log("cusCheckedList add customers information :" + this.cusCheckedList);

             for(let i=0; i<this.customers.length; i++) {
               if(this.customers[i].ifChecked=="checked"){
                 this.cusCheckedList.push(this.customers[i].code);
                 console.log("cusCheckedList add customers information :" + this.cusCheckedList);
               }
             }

             for(let i=0; i<this.oems.length; i++) {
               if(this.oems[i].ifChecked=="checked"){
                 this.oemCheckedList.push(this.oems[i].code);
                 console.log("cusCheckedList add customers information :" + this.oemCheckedList);
               }
             }
           }else{
             this.user.code = '';
             console.log('USER does not exsit.');
           }
         });
       }
     }
     }

  loadCustomerList(){
    this.dataService.listCustomer().subscribe((result:any)=>{
      console.log("listCustomer  information :" + result);
      if(result.code==1){
        console.log("listCustomer  information result :",result.data);
        this.customers = result.data;
      }else{
        this.customers=null;
        console.log('listCustomer does not exsit.');
      }
    });
  }

  selectOemCheckbox(check,code){
    console.log("selectOemCheckbox request information : " ,  check,code);
    let index:number = this.oemCheckedList.indexOf(code);
    if(check){
      if(index<0){
        this.oemCheckedList.push(code);
        console.log("selectOemCheckbox request information : " ,  this.oemCheckedList);
      }
    }else{
      this.oemCheckedList = this.oemCheckedList.filter((ele,index)=>{
        return ele != code;
      })
      console.log("selectOemCheckbox request information : " ,  this.oemCheckedList);
    }
  }

  selectCusCheckbox(check,code){
    console.log("selectCusCheckbox request information : " ,  check,code);
    let index:number = this.cusCheckedList.indexOf(code);
    if(check){
      if(index<0){
        this.cusCheckedList.push(code);
        console.log("selectCusCheckbox request information : " ,  this.cusCheckedList);
      }
    }else{
      this.cusCheckedList = this.cusCheckedList.filter((ele,index)=>{
        return ele != code;
      })
      console.log("selectCusCheckbox request information : " ,  this.cusCheckedList);
    }
  }


  submitUser(){
    this.userCheckFun('all');
    console.log("submitUser request user : " ,  this.submitFlag);
    if(this.submitCheckFlag){
      console.log("submitUser request user : " ,  this.user);
      this.user.oemGroup = this.oemCheckedList;
      this.user.cusGroup = this.cusCheckedList;
      if(this.user.code == null || this.user.code==''){
        this.submitToAddUser();
      }else{
        if(this.submitCheckFlag){
          this.submitToUpdUser();
        }
      }
      console.log(this.user);
    }
  }

  submitToAddUser(){
    this.userManageService.addUser(this.user).subscribe((result:any)=>{
      if(result.code==1){
        console.log(result);
        this.onclickCancel();
      }else{
        console.log('USER add fail.msg: ' ,result.message);
      }
    });
  }

  submitToUpdUser(){
    this.userManageService.updateUser(this.user).subscribe((result:any)=>{
      if(result.code==1){
        console.log(result);
        this.onclickCancel();
      }else{
        console.log('USER upload fail.msg: ' ,result.message);
      }
    });
  }



  chooseFile(){
    (document.querySelector("#file") as HTMLInputElement).click();
  }

  loadImage(img) {
    this.user.img = img;
    (document.querySelector('#imgUser') as HTMLImageElement).src = this.user.img;
  }

  getFilePath = function(){
    var _this = this;
    var reader = new FileReader();
    reader.onload = function(e:any) {
      _this.user.img = e.target.result;
      _this.loadImage(e.target.result);
    };
    var file = (document.querySelector("#file") as HTMLInputElement).files[0];
    if(file && file.size <= Constant.FILE_MAX_SIZE){
      this.imgValid = true;
      this.submitFlag = true;
      reader.readAsDataURL(file);
      console.log("getFilePath request result : " ,  this.submitFlag);
    }else{
      this.imgValid = false;
      this.submitFlag = false;
      console.log("getFilePath request result : " ,  this.submitFlag);
    }
  }

  onclickCancel(){
    this.router.navigate(['/pages/users/user-list']);
  };

  resetPassword(code){
    console.log("resetPassword request code : " ,  code);

    this.userForRpw = this.user;
    this.user = {};
    this.user.password='123';
    this.user.code=code;
    this.submitToUpdUser()
    this.user = this.userForRpw;
    this.user.password = '123';
 }


  userCheckFun(checkFlag){
    console.log("userDataNullCheck request code : " ,  this.user);
    if(checkFlag=='name' || checkFlag=='all'){
      this.submitFlag = true;
      if(this.user.name== null|| this.user.name=='') {
        this.submitFlag = false;
        this.nameValid = false;
        this.errorMsg.name = 'Name is null !';
      }else{
        this.errorMsg.name = '';
        this.nameValid = true;
        this.infoRepeatCheck('name');
      }
    }
    if(checkFlag=='password' || checkFlag=='all'){
      if(this.user.password== null|| this.user.password==''){
        this.submitFlag = false;
        this.errorMsg.password = 'Password is null !';
      }else{
        this.errorMsg.password = '';
      }
    }
    if(checkFlag=='roleId' || checkFlag=='all'){
    if(this.user.roleId== null|| this.user.roleId==''){
      this.submitFlag = false;
      this.errorMsg.roleId = 'Role is null !';
    }else{
      this.errorMsg.roleId = '';
    }
    }
    //if(checkFlag=='company' || checkFlag=='all'){
    //if(this.user.company== null|| this.user.company==''){
    //  this.submitFlag = false;
    //  this.errorMsg.company = 'company is null !';
    //}else{
    //  this.submitFlag = true;
    //  this.errorMsg.company = '';
    //}
    //}
    //if(checkFlag=='address' || checkFlag=='all'){
    //if(this.user.address== null|| this.user.address==''){
    //  this.submitFlag = false;
    //  this.errorMsg.address = 'address is null !';
    //}else{
    //  this.submitFlag = true;
    //  this.errorMsg.address = '';
    //}
    //}
    if(checkFlag=='phone' || checkFlag=='all'){
      if(this.user.phone== null|| this.user.phone==''){
        this.submitFlag = false;
        this.phoneValid = false;
        this.errorMsg.phone = 'Phone is null !';
      }else{
        this.errorMsg.phone = '';
        this.phoneValid = true;
        this.infoRepeatCheck('phone');
      }
    }
    if(checkFlag=='email' || checkFlag=='all'){
      if(this.user.email== null|| this.user.email==''){
        this.submitFlag = false;
        this.emailValid = false;
        this.errorMsg.email = 'Email is null !';
      }else{
        this.errorMsg.email = '';
        this.emailValid = true;
        this.infoRepeatCheck('email');
      }
    }
    if(checkFlag=='img' || checkFlag=='all'){
      if(this.user.img==null || this.user.img==''){
        this.submitFlag = false;
        this.errorMsg.img = 'Img is null !';
        this.imgValid=false;
      //}
      //else if(!this.imgValid){
      //  this.submitFlag = false;
      //  this.errorMsg.img = 'img size > 200k !';
      }else{
        this.errorMsg.img = '';
      }
    }
    if(this.submitFlag){
      this.submitCheckFlag = true;
    }
  }

  infoRepeatCheck(checkRange){
    console.log('infoRepeatCheck.msg: ' ,this.user);
    this.userManageService.checkUserInfo(this.user).subscribe((result:any)=>{
      if(result.code==1){
        console.log('getUserCountByName. result: ' ,result);
        if(checkRange=='name' || checkRange=='all'){
          if(result.data.name==0){
            this.errorMsg.name = '';
            this.submitFlag = true;
            this.nameValid = true;
          }else if(result.data.name== -99) {
            this.submitFlag = false;
            this.nameValid = false;
            this.errorMsg.name = 'Name format error:'+ this.user.name;
          }else{
            if(this.user.name==this.oldName){
              this.errorMsg.name = '';
              this.submitFlag = true;
              this.nameValid = true;
            }else{
              this.submitFlag = false;
              this.nameValid = false;
              this.errorMsg.name = 'Already have name:'+ this.user.name;
            }
          }
        }

        console.log('infoRepeatCheck.checkRange: ' ,checkRange);
        if(checkRange=='phone' || checkRange=='all'){
          if(result.data.phone==0){
            this.errorMsg.phone = '';
            this.submitFlag = true;
            this.phoneValid = true;
          }else if(result.data.phone== -99) {
            this.submitFlag = false;
            this.phoneValid = false;
            this.errorMsg.phone = 'Phone format error:'+ this.user.phone;
          }else{
            if(this.user.phone==this.oldPhone){
              this.errorMsg.phone = '';
              this.submitFlag = true;
              this.phoneValid = true;
            }else{
              this.submitFlag = false;
              this.phoneValid = false;
              this.errorMsg.phone = 'Already have phone:'+ this.user.phone;
            }
          }
        }
        if(checkRange=='email' || checkRange=='all') {
          if (result.data.email == 0) {
            this.errorMsg.email = '';
            this.submitFlag = true;
            this.emailValid = true;
          }else if(result.data.email== -99) {
            this.submitFlag = false;
            this.emailValid = false;
            this.errorMsg.email = 'Email format error:'+ this.user.email;
          } else {
            if (this.user.email == this.oldEmail) {
              this.errorMsg.email = '';
              this.submitFlag = true;
              this.emailValid = true;
            } else {
              this.submitFlag = false;
              this.emailValid = false;
              this.errorMsg.email = 'Already have email:' + this.user.email;
            }
          }
        }
      }else{
        console.log('USER check fail.msg: ' ,result.message);
      }
    });
  }


  onClickChangePW(){
    console.log("onClickEdit :" +this.user.code);
      //if(this.user.code==null || this.user.code==''){
      //  alert('Please checked a user!!');
      //}else if(this.userDelCodes=='1'){
      //  alert('Can not change superAdmin password!!');
      //}else{
      //activePath.code = this.user.code;
      //this.saveActivePath();
      setTimeout(() => {
        this.router.navigateByUrl('/pages/users/user-resetps');
      }, 100);
    //}
  }

}
