import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'skf-device',
  template: `<router-outlet></router-outlet>`,
})
export class DeviceComponent implements OnInit {
  constructor(private localStorageService: LocalStorageService) {
  }

  ngOnInit(): void {
    this.localStorageService.set('OEMPanel', '');
    this.localStorageService.set('CustomerPanel', '');
  }
  
}
