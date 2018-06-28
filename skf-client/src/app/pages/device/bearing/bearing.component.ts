import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {TranslateService} from '@ngx-translate/core';
import  { BearingService } from '../../../@core/data/bearing.service';
import  { ImgService } from '../../../@core/data/img.service';
import { DataService } from '../../../@core/data/data.service';
import { LocalStorageService } from 'angular-2-local-storage';



@Component({
  selector: 'bearing',
  templateUrl: './bearing.component.html',
  styleUrls: ['./bearing.component.scss']
})
export class BearingComponent implements OnInit {

  constructor(private bearingService: BearingService,
              private dataService: DataService,
              private router: Router,
              private imgService : ImgService,
              private translateService: TranslateService,
              private localStorageService : LocalStorageService) {
  }
  code: any = '';
  bearingCode: string;
  bearing : any = {};
  bearingImg : any = {};
  imgList: any[] = [];
  imgDataList: any = {};
  // trans = [];
  componentTypeID : number = 2;
  imgCheckBox : any = {};
  txtSearch = "";
  listComponent : any[] = [];


   ngOnInit() {
     console.log('bearing into information : ', this.bearing);

    //  this.translateService.get(['DELETE_CONFIRM'])
    //    .subscribe(val => {
    //      this.trans = val;
    //    });

     this.listImg();

     if(this.localStorageService.get('bearingcode')==null){

     }else{
       this.code = this.localStorageService.get('bearingcode');
       this.bearing.code = this.localStorageService.get('bearingcode');

       console.log("ngOnInit bearing information :" + this.bearing.code);

       if(this.bearing.code){
         this.bearingService.getBearingByCode(this.bearing.code).subscribe((result:any)=>{
           console.log("getBearingByCode  information :" + result);
           if(result.code==1){
             this.bearing = result.data;
             console.log("getBearingByCode  information result :",this.bearing);
             this.bearingCode = this.bearing.code;
           }else{
             this.bearing.code = '';
             console.log('bearing does not exsit.');
           }
         });
       }
     }

  }

  listImg(){
    this.imgService.listImgByType(this.componentTypeID).subscribe((result:any)=>{
      console.log('listImg into information : ', result);
      if(result.code==1){
        console.log(result);
        this.imgList = result.data;
       this.loadImages(result.data);
      }else{
        console.log('listImg get fail.msg: ' ,result.message);
      }
    });
  }


  loadImages(listEquipmentType) {
    console.log('loadImage information : ', listEquipmentType);
    listEquipmentType.forEach((v, i) => {
      this.imgDataList[v.code] = v.data;
    });
    console.log('loadImage information : ',  this.imgDataList);
  }

  submitBearing(){
    console.log("submitBearing request bearing0 : " ,  this.bearing);
    this.bearing.type = this.componentTypeID;
    console.log("submitBearing request bearing1 : " ,  this.bearing);
    if(this.bearing.code == null || this.bearing.code==''){
      this.submitToAddBearing();
    }else{
      this.submitToUpdBearing();
    }
    console.log(this.bearing);


  }

  submitToAddBearing(){
    console.log("submitToAddBearing request bearing : " ,  this.bearing);
    this.bearingService.addBearing(this.bearing).subscribe((result:any)=>{
      if(result.code==1){
        console.log(result);
        this.onclickCancel();
      }else{
        console.log('Bearing add fail.msg: ' ,result.message);
      }
    });
  }

  submitToUpdBearing(){
    console.log("submitToUpdBearing request bearing : " ,  this.bearing);
    this.bearingService.updateBearing(this.bearing).subscribe((result:any)=>{
      if(result.code==1){
        console.log(result);
        this.onclickCancel();
      }else{
        console.log('bearing upload fail.msg: ' ,result.message);
      }
    });
  }

  chooseFile(){
    (document.querySelector("#file") as HTMLInputElement).click();
  }



  getFilePath = function(){
    var _this = this;
    var reader = new FileReader();
    reader.onload = function(e:any) {
        _this.bearingImg.data = e.target.result;
        _this.loadImage(e.target.result);
    };
    reader.readAsDataURL((document.querySelector("#file") as HTMLInputElement).files[0]);

    console.log('bearing information.msg: ' ,this.bearingImg);
  };

  loadImage(img) {
    console.log('loadImage reqeust .data: ' ,img);

    this.bearingImg.data = img;
    this.bearingImg.componentTypeID = this.componentTypeID;
    //(document.querySelector('#imgBearing') as HTMLImageElement).src = this.bearingImg.data;

    this.addImage();

  }

  addImage(){
    this.imgService.addImg(this.bearingImg).subscribe((result:any)=>{
      console.log('addImage reqeust data : ', result);
      if(result.code==1){
        console.log("addImage request result:", result);
        this.listImg();
      }else{
        console.log('img add fail.msg: ' ,result.message);
      }
    });
  }

  deleteImg(img){
    if (confirm(this.translateService.instant('DELETE_CONFIRM') )) {
      console.log('deleteImg reqeust data : ', img);
      this.imgService.deleteImg(img.code).subscribe((result:any)=> {
        console.log('deleteImg reqeust data : ', result);
        if (result.code == 1) {
          console.log("deleteImg request result:", result);
          this.listImg();
        } else {
          alert("Picture has been used ! Can't delete.");
          console.log('deleteImg fail msg: ', result.message);
        }
      });
    }
  }


  onclickCancel(){
    this.router.navigate(['/pages/device/bearing-list']);
  };

  saveActivePath(){
    this.localStorageService.set('bearingcode', this.code)
  }

  checkedImg(check,img){
    console.log('checkedImg request msg: ' ,img);
    if( this.bearing.imageCode == img.code){
      this.bearing.imageCode=null;
    }else{
      this.bearing.imageCode = img.code;
    }
    console.log('checkedImg request msg: ' ,this.bearing);
  }


  searchComponent($event,myDrop){
    console.log('searchComponent request msg: ' ,myDrop);
    $event.stopPropagation();
    myDrop.open();
    this.txtSearch = this.txtSearch.trim();
    console.log('searchComponent request msg: ' ,this.txtSearch);
    //if(this.componentTypeID==1 && this.txtSearch.length > 0){
    if(this.txtSearch.length > 0) {
      this.bearingService.listBearingByModel(this.txtSearch).subscribe(
        (val) => {
          console.log('searchComponent respone msg: ', val);
          if (val.code == 1) {
            this.listComponent = val.data;
            console.log(this.listComponent);
          }
        }
      );
    }
    //}else if(this.componentTypeID==2){
    //  this.bearingService.listGearByModel(this.txtSearch).subscribe(
    //    (val) => {
    //      if (val.code == 1) {
    //        this.listComponent = val.data;
    //        console.log(this.listComponent);
    //      }
    //    }
    //  );
    //}
  }

  selectBearingGear(item){
    this.bearing.code = item.code;
    this.bearing.manufacture = item.manufacture;
    this.bearing.description = item.description;
    this.bearing.bpfi = item.bpfi;
    this.bearing.bpfo = item.bpfo;
    this.bearing.bsf = item.bsf;
    this.bearing.ftf =item.ftf;
    this.bearing.modelNumber = item.modelNumber;
    //this.dataService.getImageByCode(this.bearing.imageCode).subscribe(
    //  (val) => {
    //    if (val.code == 1) {
    //      (document.querySelector('#imgComponent') as HTMLImageElement).src = val.data.data;
    //    }
    //  }
    //);
  }

}
