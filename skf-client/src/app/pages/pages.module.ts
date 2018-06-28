import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { AlarmModule } from './alarm/alarm.module';
import { LoginModule } from './login/login.module';
import { PagesRoutingModule } from './pages-routing.module';
import { ThemeModule } from '../@theme/theme.module';
import { DeviceModule } from './device/device.module';
import { UsersModule } from './users/users.module';

const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    AlarmModule,
    LoginModule,
    DeviceModule,
    UsersModule,
  ],
  declarations: [
    ...PAGES_COMPONENTS,
  ],
})
export class PagesModule {
}


