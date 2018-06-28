import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import { Router, ActivatedRoute, Params } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { LocalStorageService } from 'angular-2-local-storage';
import { DataService } from '../../../@core/data/data.service';
import { activePath } from '../activePath';

@Component({
  selector: 'equipmnet-type-list',
  templateUrl: './equipmnet-type-list.component.html',
  styleUrls: ['./equipmnet-type-list.component.scss']
})
export class EquipmnetTypeListComponent implements OnInit {
    userRoleId = 1;
    listEquipmentType : any[] = [];
    //trans = [];
    settings : any = {};

    public filterQuery = "";
    public rowsOnPage = 10;
    public sortBy = "name";
    public sortOrder = "asc";

    constructor(private http: Http, 
      private dataService: DataService, 
      private localStorageService: LocalStorageService,
      private router: Router,
      private translateService: TranslateService) {
    }

    ngOnInit(): void {
      if(sessionStorage.getItem("userRoleId") == "2")
        this.userRoleId = 2;
        
      activePath.load(this.localStorageService.get('activePath'));

        if(!activePath.customerCode){
          this.router.navigate(['/pages/device/dashboard']);
          return;
        }
        this.loadListEquipmentType();
    }

    loadListEquipmentType(){
      this.dataService.listEquipmentTypeByOwner(activePath.customerCode).pipe().subscribe((reult:any)=>{
        console.log(reult);
        this.listEquipmentType = reult.data;
        this.listEquipmentType.forEach((val, idx)=>{
          val.imgLink = `<img class="img-panel" src="${val.img}">`;
        })
      });
    }

    delete(item) {
      if(confirm('Are you sure you want to delete?')){
        this.dataService.deleteEquipmentType(item.code).subscribe(
          (val) => {
            this.loadListEquipmentType();
            console.log("listEquipmentType call successful value returned in body", val);
          },
          response => {
              console.log("listEquipmentType call in error", response);
          },
          () => {
              console.log("listEquipmentType observable is now completed.");
          }
        );
      }
    }

    edit(item){
      activePath.equipmentTypeCode = item.code;
      this.saveActivePath();
      this.router.navigate(['/pages/device/equipment-type']);
    }

    add(){
      activePath.equipmentTypeCode = '';
      this.saveActivePath();
      this.router.navigate(['/pages/device/equipment-type']);
    }

    goBack(){
      this.router.navigate(['/pages/device/equipment']);
    }
  
    onDeleteConfirm(event): void {
      if (window.confirm('Are you sure you want to delete?')) {
        event.confirm.resolve();
      } else {
        event.confirm.reject();
      }
    }

    saveActivePath(){
      this.localStorageService.set('activePath', activePath);
    }
}
