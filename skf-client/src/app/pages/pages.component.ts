import { Component, Inject, OnInit } from '@angular/core';
import { TranslateService, LangChangeEvent } from '@ngx-translate/core';
import { NbMenuItem } from '@nebular/theme';

@Component({
  selector: 'ngx-pages',
  template: `
    <ngx-sample-layout>
      <nb-menu [items]="menu"></nb-menu>
      <router-outlet></router-outlet>
    </ngx-sample-layout>
  `,
})
export class PagesComponent implements OnInit {
  userRoleId = 1;
  EQUIPMENT_MANAGEMENT: string;
  menu: NbMenuItem[] = [
    {
      title: 'Equipment Management',
      icon: 'nb-keypad',
      link: '/pages/device/equipment-list',
      home: true,
    },
    {
      title: 'Alarm',
      icon: 'nb-alert',
      link: '/pages/alarm',
      home: true,
    },
    {
      title: 'User Management',
      icon: 'nb-person',
      link: '/pages/users/user-list',
      home: true,
    },
  ];

  constructor(public translate: TranslateService) {
  }

  ngOnInit(): void {
    console.log("ngOnInit");

    if (sessionStorage.getItem("userRoleId") == "2")
      this.userRoleId = 2;

    this.getMenu();

    this.translate.onLangChange.subscribe((event: LangChangeEvent) => {
      console.log("onLangChange");
      console.log(event);
      this.getMenu();
    });
  }

  getMenu() {
    this.translate.get('MENU').subscribe((res: NbMenuItem[]) => {
      if (this.userRoleId == 2) {
        this.menu = res.slice(0, 2);
      } else {
        this.menu = res.slice(0, 3);
      }
    });
  }
}
