/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { APP_BASE_HREF } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CoreModule } from './@core/core.module';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ThemeModule } from './@theme/theme.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { CommonModule } from '@angular/common';
//import { LocalStorageModule } from '@ngx-pwa/local-storage';
import { LocalStorageModule } from 'angular-2-local-storage';
import{LoginModule} from './pages/login/login.module';
import {AuthCheckService} from "./pages/login/auth.service.js";
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,

    CommonModule,
    LoginModule,
    LocalStorageModule.withConfig({
      prefix: 'ngx-app',
      storageType: 'localStorage'
    }),
    NgbModule.forRoot(),
    ThemeModule.forRoot(),
    CoreModule.forRoot(),
    TranslateModule.forRoot({
      loader:{
        provide:TranslateLoader,
        useFactory:HttpLoaderFactory,
        deps:[HttpClient],
      },
    })
  ],
  bootstrap: [AppComponent],
  providers: [AuthCheckService,
    { provide: APP_BASE_HREF, useValue: '/' },
  ],
})
export class AppModule {
}
