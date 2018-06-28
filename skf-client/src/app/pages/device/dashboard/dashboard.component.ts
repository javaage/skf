import { Component, OnInit, OnChanges, Input, state, Attribute, ContentChild, ContentChildren, Directive, ViewChildren, HostListener, Self, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { NgbAccordionConfig, NgbPanelChangeEvent } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { DatePipe } from '@angular/common';
import { LocalStorageService } from 'angular-2-local-storage';
import { DataService } from '../../../@core/data/data.service';
import { activePath } from '../activePath';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  userRoleId = 1;

  equipmentSize: number = 11;

  listImg: any = {};

  page = 4;

  listEquipmentType: any[] = [];

  preventDefault: boolean = false;
  oemJoins : any[] = [];

  pathList = [];

  //trans = [];
  OEMPanel = ''; //panel-oem-0
  CustomerPanel = ''; //panel-customer-0

  constructor(private router: Router,
    private config: NgbAccordionConfig,
    private translateService: TranslateService,
    private dataService: DataService,
    private datePipe : DatePipe,
    private localStorageService: LocalStorageService,
    @Attribute('ctype') private ctype: string,
  ) {
    config.closeOthers = true;
    config.type = 'info';
  }

  ngOnInit() {
    if(this.localStorageService.get("OEMPanel"))
      this.OEMPanel = this.localStorageService.get("OEMPanel");
    if(this.localStorageService.get("CustomerPanel"))
      this.CustomerPanel = this.localStorageService.get("CustomerPanel");

    if(sessionStorage.getItem("userRoleId") == "2")
        this.userRoleId = 2;

    // this.translateService.get(['EQUIPMENT_MANAGEMENT','DELETE_CONFIRM'])
    // .subscribe(val => {
    //     this.trans = val;
    //     this.pathList = [{name: this.trans['EQUIPMENT_MANAGEMENT'] ,url:''}];
    // });
    
    this.loadOEMJoins();
    
  }

  loadEquipmentType(code){
    this.listEquipmentType = [];
    this.dataService.listEquipmentType().subscribe(
      (val) => {
        val.data.forEach(val=>{
          if(val.customerCode==code) 
          this.listEquipmentType.push(val);
        });

        //this.listEquipmentType = val.data;
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

  loadOEMJoins(){
    let oemID:Number = 0;
    let customerID:Number = 0;
    if(this.OEMPanel)
      oemID = parseInt(this.OEMPanel.substr(10));
    if(this.CustomerPanel)
      customerID = parseInt(this.CustomerPanel.substr(15));
    this.dataService.listOEMTree().subscribe((reult:any)=>{
      console.log(reult);
      this.oemJoins = reult.data;
      this.oemJoins.forEach((val, idx) => {
        val.listCustomerJoin.forEach((customerJoin, i) => {
          customerJoin.equipmentTypeCode = ''; //this.listEquipmentType[0].code
          customerJoin.searchStartDate = this.datePipe.transform(new Date().getTime()-30*24*60*60*1000,'yyyy-MM-dd');
          customerJoin.searchEndDate = this.datePipe.transform(new Date(),'yyyy-MM-dd');
  
          customerJoin.page = 1;
  
          if (idx == oemID && i == customerID) {
            this.showSubList(customerJoin);
            this.loadEquipmentType(customerJoin.code);
          }
        });
      });
    });
  }

  pageChange(index, customerJoin) {
    if (index) {
      customerJoin.page = index;
      this.showSubList(customerJoin);
    }
  }

  changeOEMPanel($event, accParent) {
    this.localStorageService.set('OEMPanel', $event.panelId);

    let activeId = $event.panelId;
    let Id = activeId.substr(10);

    let customerJoin = this.oemJoins[Id].listCustomerJoin[0];
    customerJoin.page = 1;
    this.showSubList(customerJoin);
    
    if (this.preventDefault)
      $event.preventDefault();
    this.preventDefault = false;
  }

  changeCustomerPanel($event, acc, oem) {
    this.localStorageService.set('CustomerPanel', $event.panelId);

    let activeId = $event.panelId;
    let Id = activeId.substr(15);

    let customerJoin = oem.listCustomerJoin[Id];
    customerJoin.page = 1;
    this.showSubList(customerJoin);
    this.loadEquipmentType(customerJoin.code)
    if (this.preventDefault)
      $event.preventDefault();
    this.preventDefault = false;
  };

  searchEquipment(customerJoin,startDateControl,endDateControl) {
    if(startDateControl.value > endDateControl.value){
      startDateControl.isError = true;
      endDateControl.isError = true;
      return;
    }else{
      startDateControl.isError = false;
      endDateControl.isError = false;
    }
    
    // console.log(startDateControl);
    // console.log(endDateControl);
    let search:any = {};
    search.customerCode = customerJoin.code;
    search.equipmentTypeCode = customerJoin.equipmentTypeCode;
    search.name = customerJoin.searchName;
    search.startDate = customerJoin.searchStartDate;
    search.endDate = customerJoin.searchEndDate; 

    this.dataService.searchEquipment(search).subscribe(
      (val) => {
        customerJoin.listEquipmentModel = val.data;
        customerJoin.page = 1;
        this.showSubList(customerJoin);
        console.log("Search call successful value returned in body", val);
      },
      response => {
          console.log("Search call in error", response);
      },
      () => {
          console.log("The Search observable is now completed.");
      }
    );
  }

  showSubList(customerJoin){
    activePath.oemCode = customerJoin.oemCode;
    activePath.customerCode = customerJoin.code;

    this.saveActivePath();

    customerJoin.subList = customerJoin.listEquipmentModel.slice((customerJoin.page - 1) * this.equipmentSize, customerJoin.page * this.equipmentSize);

    let listType = this.getTypeList(customerJoin.subList);
    if (listType.length > 0)
        this.dataService.listEquipmentTypeByList(listType).subscribe(
          (val) => {
            this.loadImage(val.data)
            console.log("listEquipmentTypeByList call successful value returned in body", val);
          },
          response => {
              console.log("listEquipmentTypeByList call in error", response);
          },
          () => {
              console.log("listEquipmentTypeByList observable is now completed.");
          }
        );
  }

  viewEquipment(equipmentModel) {
    console.log(equipmentModel);
  }

  editEquipment(equipmentModel) {
    activePath.equipmentCode = equipmentModel.code;
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/device/equipment');
    }, 100);
  }

  deleteEquipment(equipmentModel) {
    // if (confirm(this.trans['DELETE_CONFIRM'])) {
    if (confirm(this.translateService.instant('DELETE_CONFIRM'))) {
      this.dataService.deleteEquipment(equipmentModel.code).subscribe(
        (val) => {
          if(val.code==1){
            this.loadOEMJoins();
          }
          console.log("deleteEquipment call successful value returned in body", val);
        },
        response => {
            console.log("deleteEquipment call in error", response);
        },
        () => {
            console.log("deleteEquipment observable is now completed.");
        }
      );
    }
  }

  loadImage(listEquipmentType) {
    listEquipmentType.forEach((v, i) => {
      this.listImg[v.code] = v.img;
    });
  }

  getTypeList(listEquipmentModel) {
    let typeList: any[] = [];
    listEquipmentModel.forEach((v, i) => {
      if (typeList.indexOf(v.equipmentTypeCode) == -1) {
        typeList.push(v.equipmentTypeCode);
      }
    });
    return typeList;
  }

  editOEM(oem) {
    this.preventDefault = true;
    activePath.oemCode = oem.code;
    this.saveActivePath();
    setTimeout(() => {
      console.log('appDemo', 'send')
      this.router.navigateByUrl('/pages/device/oem');
    }, 100);
  }

  deleteOEM(oem) {
    this.preventDefault = true;
    if (confirm(this.translateService.instant('DELETE_CONFIRM'))) {
      this.dataService.deleteOEM(oem.code).subscribe(
        (val) => {
          if(val.code==1){
            this.loadOEMJoins();
          }
          console.log("deleteOEM call successful value returned in body", val);
        },
        response => {
            console.log("deleteOEM call in error", response);
        },
        () => {
            console.log("deleteOEM observable is now completed.");
        }
      );
    }
  }

  deleteCustomer(customer) {
    this.preventDefault = true;
    if (confirm(this.translateService.instant('DELETE_CONFIRM'))) {
      this.dataService.deleteCustomer(customer.code).subscribe(
        (val) => {
          if(val.code==1){
            this.loadOEMJoins();
          }
          console.log("deleteCustomer call successful value returned in body", val);
        },
        response => {
            console.log("deleteCustomer call in error", response);
        },
        () => {
            console.log("deleteCustomer observable is now completed.");
        }
      );
    }
  }

  editCustomer(customer) {
    this.preventDefault = true;
    activePath.oemCode = customer.oemCode;
    activePath.customerCode = customer.code;
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigate(['/pages/device/customer']);
    }, 100);
  }

  addEquipment(customer) {
    activePath.customerCode = customer.code;
    activePath.equipmentCode = '';
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigate(['/pages/device/equipment']);
    }, 100);
  };

  addOEM() {
    activePath.oemCode = '';
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/device/oem');
    }, 100);
  }

  addCustomer(oem) {
    activePath.oemCode = oem.code;
    activePath.customerCode = '';
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/device/customer');
    }, 100);
    
  }

  assembleEquipment(equipmentModel){
    activePath.equipmentCode = equipmentModel.code;
    activePath.equipmentTypeCode = equipmentModel.equipmentTypeCode;
    this.saveActivePath();
    setTimeout(() => {
      this.router.navigateByUrl('/pages/device/assemble');
    }, 100);
    
  }

  saveActivePath(){
    this.localStorageService.set('activePath', activePath);
  }
}

