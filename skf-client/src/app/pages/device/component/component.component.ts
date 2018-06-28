import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../@core/data/data.service';
import { NgModel } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { activePath } from '../activePath';
import { Constant } from '../../../@core/data/constant';

@Component({
  selector: 'component',
  templateUrl: './component.component.html',
  styleUrls: ['./component.component.scss']
})
export class ComponentComponent implements OnInit {

  isDuplicated = false;
  isSubmit = false;
  component: any = {};
  sensor: any = {};
  imgValid = true;
  txtSearch = "";
  nodes = [];
  listComponent : any[] = [];

  constructor(private dataService: DataService,
    private translateService: TranslateService,
    private activatedRoute: ActivatedRoute,
    private localStorageService: LocalStorageService,
    private router: Router) {
  }

  ngOnInit() {
    activePath.load(this.localStorageService.get('activePath'));
    if (!activePath.sensorCode) {
      this.router.navigate(['/pages/device/dashboard']);
      return;
    }

    this.component.sensorCode = activePath.sensorCode;
    this.component.code = activePath.componentCode;

    this.dataService.getSensorByCode(this.component.sensorCode).subscribe((reult: any) => {
      if (reult.code == 1) {
        this.sensor = reult.data;
        this.loadSchema(this.sensor);
        this.loadNodes();
      }
    });

    if (this.component.code) {
      this.dataService.getComponentByCode(this.component.code).subscribe((reult: any) => {
        if (reult.code == 1) {
          this.component = reult.data;
          this.loadBearingGear(this.component.componentTypeID, this.component.bearingGearCode);
        }
      });
    } else {
      this.component.componentTypeID = 1;
    }
  }

  getNodeValue(schema, nodeID){
    this.dataService.getNodeValue(schema, nodeID).subscribe((reult: any) => {
      if (reult.code == 1) {
        this.component.nodeValue = reult.data;
      }else{
        this.component.nodeValue = 0;
      }
    });
  }

  loadBearingGear(type, code){
    if(type==Constant.BEARING){
      this.dataService.getBearingByCode(this.component.bearingGearCode).subscribe((reult: any) => {
        if (reult.code == 1) {
          this.selectBearingGear(reult.data);
        }
      });
    }else if(type==Constant.GEAR){
      this.dataService.getGearByCode(this.component.bearingGearCode).subscribe((reult: any) => {
        if (reult.code == 1) {
          this.selectBearingGear(reult.data);
        }
      });
    }
  }

  loadSchema(sensor){
    this.component.schemaName = this.sensor.schemaName;
    
  }

  manageTable() {
    if (this.component.componentTypeID == 1) {
      this.router.navigate(['/pages/device/bearing-list']);
    } else {
      this.router.navigate(['/pages/device/gear-list']);
    }
  }

  setComponentType(value) {
    this.component.componentTypeID = value;
  }

  setSpeedType(value) {
    this.component.speedType = value;
  }

  setDangerType(value) {
    this.component.defectType = value;
  }

  cancel() {
    this.router.navigateByUrl('pages/device/assemble');
  }

  changeName() {
    this.isDuplicated = false;
  }

  submitComponent() {
    this.isSubmit = true;
    if (this.component.img)
      this.imgValid = true;
    else
      this.imgValid = false;

    if (this.component.code) {
      this.dataService.updateComponent(this.component).subscribe(
        (val) => {
          if (val.code == 1) {
            this.router.navigateByUrl('pages/device/assemble');
          } else if (val.code == Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION) {
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
    } else {
      this.dataService.addComponent(this.component).subscribe(
        (val) => {
          if (val.code == 1) {
            this.router.navigateByUrl('pages/device/assemble');
          } else if (val.code == Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION) {
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

  chooseFile() {
    (document.querySelector("#file") as HTMLInputElement).click();
    //this.imgValid = false;
  }

  loadImage(img) {
    this.component.img = img;
    let imgComponent = document.querySelector('#imgComponent') as HTMLImageElement;
    imgComponent.src = this.component.img;

    setTimeout(() => {
      if (imgComponent.naturalHeight > 0 && imgComponent.naturalWidth / imgComponent.naturalHeight < 5)
        this.imgValid = true;
      else
        this.imgValid = false;
    }, 100);
  }

  getFilePath = function () {
    var _this = this;
    var reader = new FileReader();
    reader.onload = function (e: any) {
      _this.loadImage(e.target.result);
    };
    var file = (document.querySelector("#file") as HTMLInputElement).files[0];
    if (file && file.size <= Constant.FILE_MAX_SIZE) {
      this.imgValid = true;
      reader.readAsDataURL(file);
    } else {
      this.imgValid = false;
    }
  };

  saveActivePath() {
    this.localStorageService.set('activePath', activePath)
  }

  searchComponent($event,myDrop){
    $event.stopPropagation(); 
    myDrop.open();
    this.txtSearch = this.txtSearch.trim();
    if(this.component.componentTypeID==1 && this.txtSearch.length > 0){
      this.dataService.listBearingByModel(this.txtSearch).subscribe(
        (val) => {
          if (val.code == 1) {
            this.listComponent = val.data;
            console.log(this.listComponent);
          } 
        }
      );
    }else if(this.component.componentTypeID==2){
      this.dataService.listGearByModel(this.txtSearch).subscribe(
        (val) => {
          if (val.code == 1) {
            this.listComponent = val.data;
            console.log(this.listComponent);
          } 
        }
      );
    }
  }

  selectBearingGear(item){
    this.component.bearingGearCode = item.code;
    this.component.manufacture = item.manufacture;
    this.component.description = item.description;
    this.component.meshingFrequency = item.meshingFrequency;
    this.component.imageCode = item.imageCode;
    this.component.modelNumber = item.modelNumber;

    this.component.bpfo = item.bpfo;
    this.component.bpfi = item.bpfi;
    this.component.bsf = item.bsf;
    this.component.ftf = item.ftf;

    this.dataService.getImageByCode(this.component.imageCode).subscribe(
      (val) => {
        if (val.code == 1) {
          (document.querySelector('#imgComponent') as HTMLImageElement).src = val.data.data;
        } 
      }
    );
  }

  loadNodes() {
    console.log(this.sensor.schemaName);
    this.dataService.leafpath(this.sensor.schemaName).subscribe((reult: any) => {
      if (reult.code == 1) {
        this.nodes = reult.data;

        if(!this.component.nodeID && this.nodes.length > 0)
          this.component.nodeID = this.nodes[0].bottomId;
        
        this.changeNodeID();
      }
    });
  }

  changeNodeID(){
    this.getNodeValue(this.component.schemaName, this.component.nodeID);
    this.changeRatio();
  }

  changeRatio(){
    if(this.component.ratio && this.component.nodeValue)
      this.component.ratioMul = this.component.ratio * this.component.nodeValue;
    else
      this.component.ratioMul = 0;
  }
}

