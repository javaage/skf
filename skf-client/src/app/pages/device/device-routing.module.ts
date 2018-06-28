import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeviceComponent } from './device.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OemComponent } from './oem/oem.component';
import { CustomerComponent } from './customer/customer.component';
import { ComponentComponent } from './component/component.component';
import { ComponentDetailComponent } from './component-detail/component-detail.component';
import { EquipmentTypeComponent } from './equipment-type/equipment-type.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { SensorComponent } from './sensor/sensor.component';
import { BearingComponent } from './bearing/bearing.component';
import { BearingListComponent } from './bearing-list/bearing-list.component';
import { GearComponent } from './gear/gear.component';
import { GearListComponent } from './gear-list/gear-list.component';
import { EquipmnetTypeListComponent } from './equipmnet-type-list/equipmnet-type-list.component';
import { AssembleComponent } from './assemble/assemble.component';

const routes: Routes = [{
  path: '',
  component: DeviceComponent,
  children: [{
    path: 'dashboard',
    component: DashboardComponent,
  },{
    path: 'oem',
    component: OemComponent,
  },{
    path: 'customer',
    component: CustomerComponent,
  },{
    path: 'equipment-type',
    component: EquipmentTypeComponent,
  },{
    path: 'equipment-type-list',
    component: EquipmnetTypeListComponent,
  },{
    path: 'equipment',
    component: EquipmentComponent,
  },{
    path: 'sensor',
    component: SensorComponent,
  },{
    path: 'component',
    component: ComponentComponent,
  },{
    path: 'bearing',
    component: BearingComponent,
  },{
    path: 'bearing-list',
    component: BearingListComponent,
  },{
    path: 'gear',
    component: GearComponent,
  },{
    path: 'gear-list',
    component: GearListComponent,
  },{
    path: 'assemble',
    component: AssembleComponent,
  },{
    path: 'component-detail',
    component: ComponentDetailComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DeviceRoutingModule { }
