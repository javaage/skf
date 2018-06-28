import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from './users.component';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserResetPSComponent } from './user-resetps/user-resetps.component';

const routes: Routes = [{
  path: '',
  component: UsersComponent,
  children: [{
    path: 'user-list',
    component: UserListComponent,
  },{
    path: 'user',
    component: UserComponent,
  },{
    path: 'user-resetps',
    component: UserResetPSComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UsersRoutingModule { }

export const routedComponents = [
  UsersComponent,
  UserListComponent,
  UserComponent,
  UserResetPSComponent,
];
