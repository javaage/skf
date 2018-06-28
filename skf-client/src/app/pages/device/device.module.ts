import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { ThemeModule } from '../../@theme/theme.module';
import { DeviceRoutingModule } from './device-routing.module';

import { NgxEchartsModule } from 'ngx-echarts';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChartModule } from 'angular2-chartjs';

import {DataTableModule} from "angular2-datatable";
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { ComponentComponent } from './component/component.component';
import { FileUploadModule } from "ng2-file-upload";
import { OemComponent } from './oem/oem.component';
import { CustomerComponent } from './customer/customer.component';

import { ValidatorsModule } from 'ngx-validators';
import { EquipmentTypeComponent } from './equipment-type/equipment-type.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { SensorComponent } from './sensor/sensor.component';
import { BearingComponent } from './bearing/bearing.component';
import { BearingListComponent } from './bearing-list/bearing-list.component';
import { GearComponent } from './gear/gear.component';
import { GearListComponent } from './gear-list/gear-list.component';
import { EquipmnetTypeListComponent } from './equipmnet-type-list/equipmnet-type-list.component';
import { CommonModule, DatePipe } from '@angular/common';
import { DeviceComponent } from './device.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AssembleComponent } from './assemble/assemble.component';
import { ComponentDetailComponent } from './component-detail/component-detail.component';

import { PaginationComponent } from './pagination/pagination.component';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  imports: [
    ThemeModule,
    NgxEchartsModule,
    NgxChartsModule,
    ChartModule,
    DeviceRoutingModule,
    Ng2SmartTableModule,
    DataTableModule,
    FileUploadModule,
    ReactiveFormsModule,
    ValidatorsModule,
    CommonModule,
  ],
  declarations: [
    DeviceComponent,
    ComponentComponent,
    OemComponent,
    CustomerComponent,
    EquipmentTypeComponent,
    EquipmentComponent,
    SensorComponent,
    BearingComponent,
    BearingListComponent,
    GearComponent,
    GearListComponent,
    EquipmnetTypeListComponent,
    DashboardComponent,
    AssembleComponent,
    ComponentDetailComponent,
    PaginationComponent,
  ],
  providers: [
    DeviceComponent,
    DatePipe,
  ],
})
export class DeviceModule { }

