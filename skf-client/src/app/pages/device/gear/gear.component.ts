import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../../../@core/data/data.service';
import {TranslateService} from '@ngx-translate/core';
import  { GearService } from '../../../@core/data/gear.service';
import  { ImgService } from '../../../@core/data/img.service';
import { LocalStorageService } from 'angular-2-local-storage';



@Component({
  selector: 'gear',
  templateUrl: './gear.component.html',
  styleUrls: ['./gear.component.scss']
})
export class GearComponent implements OnInit {

  constructor(private dataService: DataService,private gearService: GearService,
              private router: Router,
              private translateService: TranslateService,
              private imgService : ImgService,
              private localStorageService : LocalStorageService) {
  }
  code: any = '';
  gearCode: string;
  gear : any = {};
  gearImg : any = {};
  imgList: any[] = [];
  imgDataList: any = {};
  // trans = [];
  componentTypeID : number = 1;
  imgCheckBox : any = {};
  imgCheckMap : any = {};
  txtSearch = "";
  listComponent : any[] = [];



   ngOnInit() {
     console.log('gear into information : ', this.gear);

     this.listImg();

    //  this.translateService.get(['DELETE_CONFIRM'])
    //    .subscribe(val => {
    //      this.trans = val;
    //    });

     if(this.localStorageService.get('gearcode')==null){

     }else{
       this.code = this.localStorageService.get('gearcode');
       this.gear.code = this.localStorageService.get('gearcode');
       console.log("ngOnInit gear information :" + this.gear.code);

       if(this.gear.code){
         this.gearService.getGearByCode(this.gear.code).subscribe((result:any)=>{
           console.log("getGearByCode  information :" + result);
           if(result.code==1){
             this.gear = result.data;
             console.log("getGearByCode  information result :",this.gear);
             this.gearCode = this.gear.code;
           }else{
             this.gear.code = '';
             console.log('gear does not exsit.');
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
        this.imgCheckMap = result.imgCheckMap;
        console.log('listImg into information : ', this.imgCheckMap);
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

  submitGear(){
    console.log("submitGear request gear0 : " ,  this.gear);
    this.gear.type = this.componentTypeID;
    console.log("submitGear request gear1 : " ,  this.gear);
    //this.gear.imageCode = null;
    //this.gear.imageCode = this.imgCheckBox;
    console.log("submitGear request gear2 : " ,  this.gear);
    if(this.gear.code == null || this.gear.code==''){
      this.submitToAddGear();
    }else{
      this.submitToUpdGear();
    }
    console.log(this.gear);


  }

  submitToAddGear(){
    console.log("submitToAddGear request gear : " ,  this.gear);
    this.gearService.addGear(this.gear).subscribe((result:any)=>{
      if(result.code==1){
        console.log(result);
        this.onclickCancel();
      }else{
        console.log('Gear add fail.msg: ' ,result.message);
      }
    });
  }

  submitToUpdGear(){
    console.log("submitToUpdGear request gear : " ,  this.gear);
    this.gearService.updateGear(this.gear).subscribe((result:any)=>{
      if(result.code==1){
        console.log(result);
        this.onclickCancel();
      }else{
        console.log('gear upload fail.msg: ' ,result.message);
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
        _this.gearImg.data = e.target.result;
        _this.loadImage(e.target.result);
    };
    reader.readAsDataURL((document.querySelector("#file") as HTMLInputElement).files[0]);

    console.log('gear information.msg: ' ,this.gearImg);
  };

  loadImage(img) {
    console.log('loadImage reqeust .data: ' ,img);

    this.gearImg.data = img;
    this.gearImg.componentTypeID = this.componentTypeID;
    //(document.querySelector('#imgGear') as HTMLImageElement).src = this.gearImg.data;

    this.addImage();

  }

  addImage(){
    this.imgService.addImg(this.gearImg).subscribe((result:any)=>{
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
    if (confirm(this.translateService.instant('DELETE_CONFIRM'))) {
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
    this.router.navigate(['/pages/device/gear-list']);
  };

  saveActivePath(){
    this.localStorageService.set('gearcode', this.code)
  }

  checkedImg(img){
    console.log('checkedImg request msg: ' ,img);
    //this.imgCheckBox = img.code;
    if( this.gear.imageCode == img.code){
      this.gear.imageCode=null;
    }else{
      this.gear.imageCode = img.code;
    }
    console.log('checkedImg request msg: ' ,this.gear);
  }

  //searchComponent($event,myDrop){
  //  $event.stopPropagation();
  //  myDrop.open();
  //  this.txtSearch = this.txtSearch.trim();
  //  if(this.componentTypeID==1 && this.txtSearch.length > 0){
  //    this.dataService.listBearingByModel(this.txtSearch).subscribe(
  //      (val) => {
  //        if (val.code == 1) {
  //          this.listComponent = val.data;
  //          console.log(this.listComponent);
  //        }
  //      }
  //    );
  //  }else if(this.componentTypeID==2){
  //    this.dataService.listGearByModel(this.txtSearch).subscribe(
  //      (val) => {
  //        if (val.code == 1) {
  //          this.listComponent = val.data;
  //          console.log(this.listComponent);
  //        }
  //      }
  //    );
  //  }
  //}
  //
  //selectBearingGear(item){
  //  this.gear.code = item.code;
  //  this.gear.manufacture = item.manufacture;
  //  this.gear.description = item.description;
  //  this.gear.meshingFrequency = item.meshingFrequency;
  //  this.gear.imageCode = item.imageCode;
  //  this.gear.modelNumber = item.modelNumber;
  //  //this.dataService.getImageByCode(this.gear.imageCode).subscribe(
  //  //  (val) => {
  //  //    if (val.code == 1) {
  //  //      (document.querySelector('#imgComponent') as HTMLImageElement).src = val.data.data;
  //  //    }
  //  //  }
  //  //);
  //}

}
