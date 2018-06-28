import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { AuthCheckService} from './login/auth.service.js';
import { AlarmComponent } from './alarm/alarm.component';
const routes: Routes = [{

  path: '',
  component: PagesComponent,
  children: [{
    path: 'alarm',
    component: AlarmComponent,
  }, {
    path: '',
    redirectTo: 'device/dashboard',
    pathMatch: 'full',
  }, {
    path: 'device',
    loadChildren: './device/device.module#DeviceModule',
  }, {
    path: 'users',
    loadChildren: './users/users.module#UsersModule',
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
