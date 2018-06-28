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
  selector: 'sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.scss']
})
export class SensorComponent implements OnInit {

  rootImg: any;
  sensors: any[] = [];
  isDuplicated = false;
  isSubmit = false;
  sensor: any = {};
  schemaNames = [];
  nodes = [];
  equipmentType: any = {};

  constructor(private dataService: DataService,
    private translateService: TranslateService,
    private activatedRoute: ActivatedRoute,
    private localStorageService: LocalStorageService,
    private router: Router) { }

  ngOnInit() {
    activePath.load(this.localStorageService.get('activePath'));
    if (!activePath.equipmentCode) {
      this.router.navigate(['/pages/device/dashboard']);
      return;
    }

    this.sensor.equipmentCode = activePath.equipmentCode;
    this.sensor.code = activePath.sensorCode;

    this.dataService.getNodeDatabase().subscribe((reult: any) => {
      if (reult.code == 1) {
        this.schemaNames = reult.data;
        if (!this.sensor.schemaName && this.schemaNames.length > 0) {
          this.sensor.schemaName = this.schemaNames[0];
          this.changeSchema();
        }else{
          this.loadNodes();
        }
      }
    });

    // if (this.sensor.code) {
    //   this.dataService.getSensorByCode(this.sensor.code).subscribe((reult: any) => {
    //     if (reult.code == 1) {
    //       this.sensor = reult.data;
    //       this.changeSchema();
    //       // this.loadImage(this.sensor.img);
    //     }
    //   });
    // }

    this.dataService.getEquipmentTypeByCode(activePath.equipmentTypeCode).subscribe((result: any) => {
      if (result.code == 1) {
        this.equipmentType = result.data;
        this.rootImg = this.equipmentType.img;
      }
    });

    this.dataService.listSensorByOwner(activePath.equipmentCode).subscribe((result: any) => {
      if (result.code == 1) {
        console.log("listSensorByOwner");
        console.log(result.data);
        this.sensors = result.data;

        if (this.sensor.code) {
          for (let entry of this.sensors) {
            if(this.sensor.code==entry.code){
              this.sensor = entry; 
              break;
            }
          }
        }else{
          this.sensors.push(this.sensor);
        }
        this.updateSensors(this.sensors);
      }
    });
  }

  updateSensors(sensors){
    sensors.forEach((val: any) => {
      val.width = 0.2215;
      val.height = 0.1;
      if(this.sensor.code == val.code)
        val.url = '/assets/images/sensor_hilight.png';
      else
        val.url = '/assets/images/pic_sensor.png';
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

  changeSchema() {
    console.log(this.sensor.schemaName);
    this.dataService.leafpath(this.sensor.schemaName).subscribe((reult: any) => {
      if (reult.code == 1) {
        this.nodes = reult.data;
        if (this.nodes.length > 0) {
          this.sensor.nodeID = this.nodes[0].bottomId;
        }
      }
    });
  }

  loadNodes() {
    console.log(this.sensor.schemaName);
    this.dataService.leafpath(this.sensor.schemaName).subscribe((reult: any) => {
      if (reult.code == 1) {
        this.nodes = reult.data;
      }
    });
  }

  cancel() {
    this.router.navigateByUrl('pages/device/assemble');
  }

  changeName() {
    this.isDuplicated = false;
  }

  submitSensor() {
    this.isSubmit = true;

    if (this.sensor.code) {
      this.dataService.updateSensor(this.sensor).subscribe(
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
      this.dataService.addSensor(this.sensor).subscribe(
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

  saveActivePath() {
    this.localStorageService.set('activePath', activePath)
  }
}

