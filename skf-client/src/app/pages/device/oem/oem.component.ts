import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { DataService } from '../../../@core/data/data.service';
import { activePath } from '../activePath';
import { Constant } from '../../../@core/data/constant';

@Component({
  selector: 'oem',
  templateUrl: './oem.component.html',
  styleUrls: ['./oem.component.scss']
})
export class OemComponent implements OnInit {
  userRoleId = 1;
  oem : any = {};
  imgValid = true;
  isSubmit = false;
  isDuplicated = false;

  constructor(private dataService: DataService,
    private translateService : TranslateService,
    private activatedRoute : ActivatedRoute,
    private localStorageService: LocalStorageService,
    private router : Router,) { }

  ngOnInit() {
    if(sessionStorage.getItem("userRoleId") == "2")
        this.userRoleId = 2;

    activePath.load(this.localStorageService.get('activePath'));
      
      this.oem.code = activePath.oemCode;
      console.log("ngOnInit");

      if(this.oem.code){
        this.dataService.getOEMByCode(this.oem.code).subscribe((reult:any)=>{
          if(reult.code==1){
            console.log(reult);
            this.oem = reult.data;
            this.loadImage(this.oem.img);
          }else{
            this.oem.code = '';
            console.log('OEM does not exsit.');
          }
        });
      }
  }

  cancel() {
    window.history.back();
    //this.router.navigateByUrl('pages/device/dashboard');
  }

  changeName() {
    this.isDuplicated = false;
  }

  submitOEM() {
    this.isSubmit = true;

    if(this.oem.img)
      this.imgValid = true;
    else
      this.imgValid = false;

    if(this.oem.code){
      this.dataService.updateOEM(this.oem).subscribe(
        (val) => {
          if(val.code==1){
            this.router.navigateByUrl('pages/device/dashboard');
          }else if(val.code==Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION){
            this.isDuplicated = true;
          }
          console.log("PUT call successful value returned in body", val);
        },
        response => {
            console.log("PUT call in error", response);
        },
        () => {
          this.isSubmit = false;
          console.log("The PUT observable is now completed.");
        }
      );
    }else{
      this.dataService.addOEM(this.oem).subscribe(
        (val) => {
          if(val.code==1){
            this.router.navigateByUrl('pages/device/dashboard');
          }else if(val.code==Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION){
            this.isDuplicated = true;
          }
          console.log("POST call successful value returned in body", val);
        },
        response => {
            console.log("POST call in error", response);
        },
        () => {
          this.isSubmit = false;
          console.log("The POST observable is now completed.");
        }
      );
    }
  }

  chooseFile(){
    (document.querySelector("#file") as HTMLInputElement).click();
    //this.imgValid = false;
  }

  loadImage(img) {
    console.log("img.length" + img.length);
    this.oem.img = img;
    let imgOEM = document.querySelector('#imgOEM') as HTMLImageElement;
    imgOEM.src = this.oem.img;
    setTimeout(() => {
      if(imgOEM.naturalHeight>0 && imgOEM.naturalWidth/imgOEM.naturalHeight<8)
        this.imgValid = true;
      else
        this.imgValid = false;
    }, 100);
  }

  getFilePath = function(){  
    var _this = this;
    var reader = new FileReader();
    reader.onload = function(e:any) {
        _this.loadImage(e.target.result);
    };
    var file = (document.querySelector("#file") as HTMLInputElement).files[0];
    if(file && file.size <= Constant.FILE_MAX_SIZE){
      this.imgValid = true;
      reader.readAsDataURL(file);
    }else{
      this.imgValid = false;
    }
  };

  saveActivePath(){
    this.localStorageService.set('activePath', activePath)
  }
}
