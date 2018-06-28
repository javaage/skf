import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThemeModule } from '../../@theme/theme.module';
import { NgxEchartsModule } from 'ngx-echarts';

import { LoginComponent } from './login.component';

@NgModule({
  imports: [
    CommonModule,
    ThemeModule,
    NgxEchartsModule,
  ],
  declarations: [
    LoginComponent
  ]
})
export class LoginModule { }
