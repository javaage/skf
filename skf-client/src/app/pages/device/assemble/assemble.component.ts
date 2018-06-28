import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../@core/data/data.service';
import { NgModel } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { activePath } from '../activePath';

@Component({
  selector: 'assemble',
  templateUrl: './assemble.component.html',
  styleUrls: ['./assemble.component.scss']
})
export class AssembleComponent implements OnInit {
  userRoleId = 1;
  //trans = [];
  rootImg: any;
  sensors: any[] = [];
  equipment: any = {};
  equipmentType: any = {};
  listSensorJoin: any[] = [];
  rowsOnPage = 10;
  activeSensor: any = {};
  componentScores: any[] = [];

  constructor(private dataService: DataService,
    private translate: TranslateService,
    private activatedRoute: ActivatedRoute,
    private localStorageService: LocalStorageService,
    private datePipe: DatePipe,
    private router: Router) { }

  ngOnInit() {
    if (sessionStorage.getItem("userRoleId") == "2")
      this.userRoleId = 2;

    activePath.load(this.localStorageService.get('activePath'));

    if (!activePath.customerCode || !activePath.equipmentCode || !activePath.equipmentTypeCode) {
      this.router.navigate(['/pages/device/dashboard']);
      return;
    }

    // this.translate.get(['SENSOR_FIRST','ALARM_TABLE_TH4','POINT'])
    // .subscribe(val => {
    //     this.trans = val;
    // });

    this.equipment.customerCode = activePath.customerCode;
    this.equipment.code = activePath.equipmentCode;
    this.equipment.equipmentTypeCode = activePath.equipmentTypeCode;

    this.dataService.getEquipmentByCode(this.equipment.code).subscribe((result: any) => {
      if (result.code == 1) {
        this.equipment = result.data;
      }
    });

    this.dataService.getEquipmentTypeByCode(this.equipment.equipmentTypeCode).subscribe((result: any) => {
      if (result.code == 1) {
        this.equipmentType = result.data;
        this.rootImg = this.equipmentType.img;
      }
    });

    this.getSensorByOwner(this.equipment.code);
  }

  getSensorByOwner(code) {
    this.dataService.listSensorByOwner(code).subscribe((result: any) => {
      if (result.code == 1) {
        console.log("listSensorByOwner");
        console.log(result.data);
        this.sensors = result.data;
        if (this.sensors.length > 0) {
          this.activeSensor = this.sensors[0];
          this.getComponentScoreByOwerID(this.activeSensor.code);
        }
        this.updateSensors(this.sensors);
      }
    });
  }

  updateSensors(sensors) {
    sensors.forEach((val: any) => {
      val.width = 0.2215;
      val.height = 0.1;
      if (this.activeSensor.code == val.code)
        val.url = '/assets/images/sensor_hilight.png';
      else
        val.url = '/assets/images/pic_sensor.png';
    });
  }

  getComponentScoreByOwerID(sensorCode) {
    this.dataService.getComponentScoreByOwerID(sensorCode).subscribe((result: any) => {
      if (result.code == 1) {
        this.componentScores = result.data;
        this.componentScores.forEach((componentScore: any) => {
          this.generateDescMessage(componentScore);
        });
      }
    });
  }

  getX(posX, imgWidth, svgParent): number {
    // if (typeof (posX) === 'string')
    posX = svgParent.clientWidth * parseFloat(posX);
    // if (typeof (imgWidth) === 'string')
    imgWidth = svgParent.clientWidth * parseFloat(imgWidth);
    return posX - imgWidth / 2;
  }

  getY(posY, imgHeight, svgParent): number {
    // if (typeof (posY) === 'string')
    posY = svgParent.clientHeight * parseFloat(posY);
    // if (typeof (imgHeight) === 'string')
    imgHeight = svgParent.clientHeight * parseFloat(imgHeight);
    return posY - imgHeight / 2;
  }


  getRotate(angle, posX, posY, svgParent): string {
    angle = angle * 360;
    // if (typeof (posX) === 'string')
    posX = svgParent.clientWidth * parseFloat(posX);
    // if (typeof (posY) === 'string')
    posY = svgParent.clientHeight * parseFloat(posY);
    return `rotate(${angle} ${posX} ${posY})`;
  }

  getWidth(rate, svgParent) {
    return svgParent.clientWidth * rate;
  }

  getHeight(rate, svgParent) {
    return svgParent.clientHeight * rate;
  }

  addComponent() {
    if (this.activeSensor.code) {
      activePath.sensorCode = this.activeSensor.code;
      activePath.componentCode = '';
      this.saveActivePath();
      this.router.navigateByUrl('pages/device/component');
    }else{
      alert(this.translate.instant("SENSOR_FIRST"));
    }
  }

  addSensor() {
    activePath.sensorCode = "";
    this.saveActivePath();
    this.router.navigateByUrl('pages/device/sensor');
  }

  selectSensor(sensor) {
    console.log(sensor);
    this.activeSensor = sensor;
    this.updateSensors(this.sensors);
    this.getComponentScoreByOwerID(this.activeSensor.code);
  }

  saveActivePath() {
    this.localStorageService.set('activePath', activePath)
  }

  edit(item) {
    activePath.componentCode = item.code;
    activePath.sensorCode = item.sensorCode;
    this.saveActivePath();
    this.router.navigateByUrl('pages/device/component');
  }

  //delete component
  delete(item) {
    if (confirm('Are you sure you want to delete?')) {
      this.dataService.deleteComponent(item.code).subscribe(
        (val) => {
          this.getComponentScoreByOwerID(this.activeSensor.code);
          console.log("deleteEquipmentType call successful value returned in body", val);
        },
        response => {
          console.log("deleteEquipmentType call in error", response);
        },
        () => {
          console.log("deleteEquipmentType observable is now completed.");
        }
      );
    }
  }

  editSensor() {
    activePath.sensorCode = this.activeSensor.code;
    this.saveActivePath();
    this.router.navigateByUrl('pages/device/sensor');
  }

  deleteSensor() {
    if (confirm('Are you sure you want to delete?')) {
      this.dataService.deleteSensor(this.activeSensor.code).subscribe(
        (val) => {
          this.getSensorByOwner(this.equipment.code);
          console.log("deleteSensor call successful value returned in body", val);
        },
        response => {
          console.log("deleteSensor call in error", response);
        },
        () => {
          console.log("deleteSensor observable is now completed.");
        }
      );
    }
  }

  selectComponent(item) {
    activePath.componentCode = item.code;
    this.saveActivePath();
    this.router.navigateByUrl('pages/device/component-detail');
  }

  // getSubImg(sensor){
  //   if(this.activeSensor.code == sensor.code)
  //     return '/assets/images/sensor_hilight.png';
  //   else
  //     return '/assets/images/pic_sensor.png';
  // }

  generateDescMessage(componentScore) {
    if(componentScore.calss)
      componentScore.descriptionMsg = this.translate.instant('ALARM_TABLE_TH4') + ': ' + componentScore.calss
      + '(' + componentScore.score + this.translate.instant('POINT') +')';
    else
    componentScore.descriptionMsg = "";
    console.log(componentScore.descriptionMsg);
    // if (componentScore.calss == "A") {
    //   componentScore.descriptionMsg = this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE1");
    // } else if (componentScore.calss == "B") {
    //   componentScore.descriptionMsg = `${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_1")}
    //     ${componentScore.description.val3}
    //     ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_4")}
    //     ${componentScore.description.val1 / 5}
    //     ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_2")}
    //     ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_3")}`;
    // } else if (componentScore.calss == "C") {
    //   componentScore.descriptionMsg = `${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_1")}
    //     ${componentScore.description.val3}        
    //     ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_4")}        
    //     ${componentScore.description.val1 / 5}
    //     ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_2")}
    //     ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_3")}`;
    // }
  }

  goBack(){
    this.router.navigate(['/pages/device/dashboard']);
  }
}
