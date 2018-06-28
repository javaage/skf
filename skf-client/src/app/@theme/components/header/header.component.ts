import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common'
import {NbMenuService, NbSidebarService, NbMenuItem} from '@nebular/theme';
import { UserService } from '../../../@core/data/users.service';
import { AnalyticsService } from '../../../@core/utils/analytics.service';
import { TranslateService, LangChangeEvent } from '@ngx-translate/core';
import {NbMenuBag} from "@nebular/theme/components/menu/menu.service";
@Component({
  selector: 'ngx-header',
  styleUrls: ['./header.component.scss'],
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit ,NbMenuBag{
  tag: string;
  item: NbMenuItem;
  lang: string;

  @Input() position = 'normal';

  user: any;

  userMenu = [{ title: 'Log out' ,url:'#/authlogin'}];

  private menuBar : any;

  constructor(private sidebarService: NbSidebarService,
              private menuService: NbMenuService,
              private userService: UserService,
              private analyticsService: AnalyticsService,
              private router : Router,
              private location : Location,
              private activatedRoute : ActivatedRoute,
              public translateService : TranslateService ) {
  }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe((users: any) => this.user = users.user);

    

    // if(sessionStorage.getItem('lang')){
    //   this.lang = sessionStorage.getItem('lang');
    // } else {
    //   this.lang = '';
    // }
  }

  toggleSidebar(): boolean {
    this.sidebarService.toggle(true, 'menu-sidebar');
    return false;
  }

  toggleSettings(): boolean {
    this.sidebarService.toggle(false, 'settings-sidebar');
    return false;
  }

  goToHome() {
    this.menuService.navigateHome();
  }

  startSearch() {
    this.analyticsService.trackEvent('startSearch');
  }



  changeToEnglish() {
    console.log('changeToEnglish');
    sessionStorage.setItem('lang','en');

    this.translateService.use('en').subscribe(observer=>{
      console.log("use('en')");
      console.log(observer);
    });

    //window.location.href = ('/#' + this.location.path() + '?lang=en').replace(/\?.*/g,'?lang=en');
    //window.location.reload();
    //this.router.navigate([this.location.path(),{'lang':'en'}]);
    //this.activatedRoute.queryParams.subscribe((params: Params) => { console.log(params) });
    //this.router.navigateByUrl(('/?lang=en').replace(/\?.*/g,'?lang=en'));
  }

  changeToChinese() {
    console.log('changeToChinese');
    sessionStorage.setItem('lang','zh-CN');

    this.translateService.use('zh-CN').subscribe(observer=>{
      console.log("use('zh-CN')");
      console.log(observer);
    });

    //window.location.href = ('/#' + this.location.path() + '?lang=en').replace(/\?.*/g,'?lang=zh-CN');
    //window.location.reload();
    //this.router.navigate([this.location.path(),{'lang':'zh-CN'}]);
    //this.activatedRoute.queryParams.subscribe((params: Params) => { console.log(params) });
    //this.router.navigateByUrl(('/?lang=zh-CN').replace(/\?.*/g,'?lang=zh-CN'));
  }

}
