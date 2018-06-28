/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { Component, OnInit } from '@angular/core';
import { CommonService } from './@core/utils/common.service';
import {Router} from '@angular/router';
import {TranslateService, TranslateParser} from '@ngx-translate/core';

@Component({
  selector: 'ngx-app',
  template: '<router-outlet></router-outlet>',
})
export class AppComponent implements OnInit {
  constructor(private router: Router, 
    private translate: TranslateService,
    private parser : TranslateParser,
    private commonService : CommonService) {
    commonService.setLang(translate);
  }

  ngOnInit(): void {
  }
}
