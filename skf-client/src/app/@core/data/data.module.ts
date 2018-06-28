import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OEMService } from './oem.service';
import { DataService } from './data.service';

import { UserService } from './users.service';
import { ElectricityService } from './electricity.service';
import { StateService } from './state.service';
import { SmartTableService } from './smart-table.service';
import { PlayerService } from './player.service';
import { AlarmService } from './alarm.service';
import { GearService } from './gear.service';
import { BearingService } from './bearing.service';
import { ImgService } from './img.service';
import { UserManageService } from './usersamanage.service';

const SERVICES = [
  OEMService,
  DataService,
  UserService,
  ElectricityService,
  StateService,
  SmartTableService,
  PlayerService,
  AlarmService,
  GearService,
  BearingService,
  ImgService,
  UserManageService
];

@NgModule({
  imports: [
    CommonModule,
  ],
  providers: [
    ...SERVICES,
  ],
})
export class DataModule {
  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders>{
      ngModule: DataModule,
      providers: [
        ...SERVICES,
      ],
    };
  }
}
