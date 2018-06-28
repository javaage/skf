import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import { DataService } from '../../../@core/data/data.service';
import { NgModel } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { activePath } from '../activePath';
import { Constant } from '../../../@core/data/constant';

@Component({
  selector: 'equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.scss']
})
export class EquipmentComponent implements OnInit {

  isSubmit = false;
  equipment : any = {};
  equipmentTypes : any[] = [];
  isDuplicated = false;

  constructor(private dataService: DataService,
    private translateService : TranslateService,
    private activatedRoute : ActivatedRoute,
    private localStorageService: LocalStorageService,
    private datePipe : DatePipe,
    private router : Router) { }

  ngOnInit() {
    activePath.load(this.localStorageService.get('activePath'));
    if(!activePath.customerCode){
        this.router.navigate(['/pages/device/dashboard']);
        return;
      }
  
      this.equipment.customerCode = activePath.customerCode;
      this.equipment.code = activePath.equipmentCode;
      this.dataService.listEquipmentTypeByOwner(this.equipment.customerCode).subscribe((result:any)=>{
        if(result.code==1){
          this.equipmentTypes = result.data;
          if(this.equipmentTypes.length>0 && !this.equipment.code){
            this.equipment.equipmentTypeCode = this.equipmentTypes[0].code;
            this.changeEquipmentType();
          }
        }
      });
  
      if(this.equipment.code){
        this.dataService.getEquipmentByCode(this.equipment.code).subscribe((result:any)=>{
          if(result.code==1){
            this.equipment = result.data;
            this.equipment.setupDate = this.datePipe.transform(this.equipment.setupDate, 'yyyy-MM-dd'); 
            this.changeEquipmentType();
          }
        });
      }else{
        this.equipment.setupDate = this.datePipe.transform(new Date(), 'yyyy-MM-dd'); 
      }
  }


  changeEquipmentType(){
    console.log('changeEquipmentType');
    this.dataService.getEquipmentTypeByCode(this.equipment.equipmentTypeCode).subscribe((result:any)=>{
      if(result.code==1){
        (document.querySelector('#imgEquipment') as HTMLImageElement).src = result.data.img;
      }
    });
  }

  cancel() {
    this.router.navigateByUrl('pages/device/dashboard');
  }

  manageType(){
    this.router.navigateByUrl('pages/device/equipment-type-list');
  }

  changeName() {
    this.isDuplicated = false;
  }

  submitEquipment() {
    this.isSubmit = true;
    if(this.equipment.code){
      this.dataService.updateEquipment(this.equipment).subscribe(
        (val) => {
          console.log("PUT call successful value returned in body", val);
          if(val.code==1){
            this.router.navigate(['/pages/device/dashboard']);
          }else if(val.code==Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION){
            this.isDuplicated = true;
          }
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
      this.dataService.addEquipment(this.equipment).subscribe(
        (val) => {
          console.log("POST call successful value returned in body", val);
          if(val.code==1){
            this.router.navigate(['/pages/device/dashboard']);
          }else if(val.code==Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION){
            this.isDuplicated = true;
          }
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

  saveActivePath(){
    this.localStorageService.set('activePath', activePath)
  }
}


