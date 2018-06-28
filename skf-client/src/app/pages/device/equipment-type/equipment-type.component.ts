import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { DataService } from '../../../@core/data/data.service';
import { NgModel } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { activePath } from '../activePath';
import { Constant } from '../../../@core/data/constant';

@Component({
  selector: 'equipment-type',
  templateUrl: './equipment-type.component.html',
  styleUrls: ['./equipment-type.component.scss']
})
export class EquipmentTypeComponent implements OnInit {

  isSubmit = false;
  equipmentType : any = {};
  imgValid = true;
  isDuplicated = false;

  constructor(private dataService: DataService,
    private translateService : TranslateService,
    private activatedRoute : ActivatedRoute,
    private localStorageService: LocalStorageService,
    private router : Router) { }

  ngOnInit() {
    activePath.load(this.localStorageService.get('activePath'));
    console.log(activePath);
      if(!activePath.customerCode){
        this.router.navigate(['/pages/device/dashboard']);
        return;
      }
  
      this.equipmentType.code = activePath.equipmentTypeCode;
      this.equipmentType.customerCode = activePath.customerCode;
  
      if(this.equipmentType.code){
        this.dataService.getEquipmentTypeByCode(this.equipmentType.code).subscribe((result:any)=>{
          if(result.code==1){
            this.equipmentType = result.data;
            this.loadImage(this.equipmentType.img);
          }
        });
      }
    
  }

  cancel() {
    this.router.navigateByUrl('pages/device/equipment-type-list');
  }

  changeName() {
    this.isDuplicated = false;
  }

  submitEquipmentType() {
    this.isSubmit = true;

    if(this.equipmentType.img)
      this.imgValid = true;
    else
      this.imgValid = false;

    if(this.equipmentType.code){
      this.dataService.updateEquipmentType(this.equipmentType).subscribe(
        (val) => {
          if(val.code==1){
            this.router.navigateByUrl('pages/device/equipment-type-list');
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
      this.dataService.addEquipmentType(this.equipmentType).subscribe(
        (val) => {
          if(val.code==1){
            this.router.navigateByUrl('pages/device/equipment-type-list');
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
    this.equipmentType.img = img;
    let imgEquipmentType = document.querySelector('#imgEquipmentType') as HTMLImageElement;
    imgEquipmentType.src = this.equipmentType.img;
    setTimeout(() => {
      if(imgEquipmentType.naturalHeight>0)
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
