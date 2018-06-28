import { Injectable } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Injectable()
export class CommonService {

  language : string;

  constructor(public activatedRoute : ActivatedRoute) { }

  setLang(translate: TranslateService) {
    // this language will be used as a fallback when a translation isn't found in the current language
    translate.addLangs(['zh-CN', 'en']);
    //translate.setDefaultLang('en');
    // the lang to use, if the lang isn't available, it will use the current loader to get them
    //translate.use('en');
    this.activatedRoute.queryParams.subscribe((params:Params)=>{
      if(sessionStorage.getItem('lang')=='en'){
        console.log(params['lang']);
        translate.setDefaultLang('en');
        this.language = 'en';
      }
      else if(sessionStorage.getItem('lang')=='zh-CN'){
        console.log(params['lang']);
        translate.setDefaultLang('zh-CN');
        this.language = 'zh-CN';
      } else {
        if(this.language!=null){
          translate.setDefaultLang(this.language);
        }else{
          let broswerLang = translate.getBrowserLang();
          console.log(broswerLang);
          if(broswerLang.match(/en/)){
            translate.setDefaultLang('en');
            this.language = 'en';
          }else{
            translate.setDefaultLang('zh-CN');
            this.language = 'zh-CN';
          }
        } 
      }
      // if(params['lang']=='en'){
      //   console.log(params['lang']);
      //   translate.setDefaultLang('en');
      //   this.language = 'en';
      // }
      // else if(params['lang']=='zh-CN'){
      //   console.log(params['lang']);
      //   translate.setDefaultLang('zh-CN');
      //   this.language = 'zh-CN';
      // } else {
      //   if(this.language!=null){
      //     translate.setDefaultLang(this.language);
      //   }else{
      //     let broswerLang = translate.getBrowserLang();
      //     console.log(broswerLang);
      //     if(broswerLang.match(/en/)){
      //       translate.setDefaultLang('en');
      //       this.language = 'en';
      //     }else{
      //       translate.setDefaultLang('zh-CN');
      //       this.language = 'zh-CN';
      //     }
      //   }
        
      // }
    });
  }
}
