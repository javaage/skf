import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../@core/data/data.service';
import { NgModel } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { activePath } from '../activePath';
import { Constant } from '../../../@core/data/constant';

@Component({
  selector: 'customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {
  userRoleId = 1;
  isDuplicated = false;
  isSubmit = false;
  customer: any = {};
  imgValid = true;

  constructor(private dataService: DataService,
    private translateService: TranslateService,
    private activatedRoute: ActivatedRoute,
    private localStorageService: LocalStorageService,
    private router: Router) {
  }

  ngOnInit() {
    if(sessionStorage.getItem("userRoleId") == "2")
        this.userRoleId = 2;

    activePath.load(this.localStorageService.get('activePath'));
    if (!activePath.oemCode) {
      this.router.navigate(['/pages/device/dashboard']);
      return;
    }

    this.customer.oemCode = activePath.oemCode;
    this.customer.code = activePath.customerCode;

    if (this.customer.code) {
      this.dataService.getCustomerByCode(this.customer.code).subscribe((reult: any) => {
        if (reult.code == 1) {
          this.customer = reult.data;
          this.loadImage(this.customer.img);
        }
      });
    }
  }

  cancel() {
    this.router.navigateByUrl('pages/device/dashboard');
  }

  changeName() {
    this.isDuplicated = false;
  }

  submitCustomer() {
    this.isSubmit = true;
    if (this.customer.img)
      this.imgValid = true;
    else
      this.imgValid = false;

    if (this.customer.code) {
      this.dataService.updateCustomer(this.customer).subscribe(
        (val) => {
          if (val.code == 1) {
            this.router.navigateByUrl('pages/device/dashboard');
          } else if (val.code == Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION) {
            this.isDuplicated = true;
          }
          console.log("PUT call successful value returned in body", val);
        },
        response => {
          console.log("PUT call in error", response);
        },
        () => {
          this.isSubmit = false;
          console.log("The PUT observable is now completed.");
        }
      );
    } else {
      this.dataService.addCustomer(this.customer).subscribe(
        (val) => {
          if (val.code == 1) {
            this.router.navigateByUrl('pages/device/dashboard');
          } else if (val.code == Constant.HTTP_TYPE_DUPLICATE_KEY_EXCEPTION) {
            this.isDuplicated = true;
          }
          console.log("POST call successful value returned in body", val);
        },
        response => {
          console.log("POST call in error", response);
        },
        () => {
          this.isSubmit = false;
          console.log("The POST observable is now completed.");
        }
      );
    }
  }

  chooseFile() {
    (document.querySelector("#file") as HTMLInputElement).click();
    //this.imgValid = false;
  }

  loadImage(img) {
    this.customer.img = img;
    let imgCustomer = document.querySelector('#imgCustomer') as HTMLImageElement;
    imgCustomer.src = this.customer.img;

    setTimeout(() => {
      if (imgCustomer.naturalHeight > 0 && imgCustomer.naturalWidth / imgCustomer.naturalHeight < 5)
        this.imgValid = true;
      else
        this.imgValid = false;
    }, 100);
  }

  getFilePath = function () {
    var _this = this;
    var reader = new FileReader();
    reader.onload = function (e: any) {
      _this.loadImage(e.target.result);
    };
    var file = (document.querySelector("#file") as HTMLInputElement).files[0];
    if (file && file.size <= Constant.FILE_MAX_SIZE) {
      this.imgValid = true;
      reader.readAsDataURL(file);
    } else {
      this.imgValid = false;
    }
  };

  saveActivePath() {
    this.localStorageService.set('activePath', activePath)
  }
}
