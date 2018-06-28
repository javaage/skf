import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ThemeModule } from '../../@theme/theme.module';
import { NgxEchartsModule } from 'ngx-echarts';

import { AlarmComponent } from './alarm.component';
import { PaginationComponent } from './pagination/pagination.component';

@NgModule({
  imports: [
    CommonModule,
    ThemeModule,
    NgxEchartsModule,
  ],
  declarations: [
    AlarmComponent,
    PaginationComponent
  ]
})
export class AlarmModule { }
