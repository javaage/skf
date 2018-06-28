import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from './users.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserComponent } from './user/user.component';
import { UserResetPSComponent } from './user-resetps/user-resetps.component';
import { ReactiveFormsModule } from '@angular/forms';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { ThemeModule } from '../../@theme/theme.module';
import { NgxEchartsModule } from 'ngx-echarts';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChartModule } from 'angular2-chartjs';
import {DataTableModule} from "angular2-datatable";
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ValidatorsModule } from 'ngx-validators';
import { UsersRoutingModule, routedComponents } from './users-routing.module';
import { PaginationComponent } from './pagination/pagination.component';

@NgModule({
  imports: [
    ThemeModule,
    NgxEchartsModule,
    NgxChartsModule,
    ChartModule,
    UsersRoutingModule,
    Ng2SmartTableModule,
    DataTableModule,
    ReactiveFormsModule,
    ValidatorsModule,
  ],
  declarations: [
    ...routedComponents,
    UsersComponent,
    UserListComponent,
    UserComponent,
    UserResetPSComponent,
    PaginationComponent
  ],
  providers: [
    ...routedComponents,
  ],
})
export class UsersModule { }


