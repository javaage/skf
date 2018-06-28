import {Injectable} from '@angular/core';

// declare var $: any;

@Injectable()
export class MethodsService {
  constructor() {}

  isEmptyOrNull(obj) {
    /// <summary>
    /// Retrieve true when object is empty, undefined or null.
    /// </summary>
    /// <param name='obj'>Object to be checked</param>
    /// <returns type='boolean'>True when object is empty, undefined or null.</returns>
    /// <doc>myPerformance.factory:methods#isEmptyOrNull</doc>
    return ((obj === undefined) ||
      (obj === null) ||
      (obj === '') ||
      (obj.length === 0) // Arrays
    );
  };
  urlFormat(url: string, params: string) {
    /// <summary>
    /// Format url using string.format way to match parameters.
    /// </summary>
    /// <returns type='string'>String parsed.</returns>
    /// <doc>myPerformance.factory:methods#urlFormat</doc>
    var args = arguments, url = '', baseUrl = '', qs = '', qsFormatted = '', splitted, vars = [], hash, i;
    if (this.isEmptyOrNull(args)) {
      return '';
    }
    if (args.length === 1) {
      url = args[0];
    }
    else {
      url = args[0].replace(/\{(\d+)\}/g, function (match, number) {
        return args[parseInt(number, 10) + 1] !== undefined ? encodeURIComponent(args[parseInt(number, 10) + 1]) : '';
      });
    }
    // Remove empty qs parameters
    if (url.indexOf('?') >= 0) {
      splitted = url.split('?');
      baseUrl = splitted[0];
      if (splitted.length > 1) {
        qs = splitted[1].split('&');
        for (i = 0; i < qs.length; i++) {
          if (qs[i].indexOf('=') >= 0) {
            hash = qs[i].split('=');
            vars.push({ code: hash[0], value: hash[1] });
          }
          else {
            vars.push({ code: qs[i], value: '' });
          }
        }
        // Fill qsFormatted using vars and removing empty values
        for (i = 0; i < vars.length; i++) {
          if (vars[i].value && vars[i].value !== '') {
            qsFormatted = qsFormatted + ((qsFormatted === '') ? '?' : '&') + vars[i].code + '=' + vars[i].value;
          }
        }
      }
    }
    else {
      baseUrl = url;
    }
    return baseUrl + qsFormatted;
  };

  extendJSONArray(data: any) {
    return JSON.parse(JSON.stringify(data));
    // return $.extend([], true, data);
  }

  extendJSONObject(data: any) {
    return JSON.parse(JSON.stringify(data));
    // return $.extend({}, true, data);
  }

  dateFormat(date: any, format: string) {
    var o = {
      'M+': date.getMonth() + 1,                 //月份
      'd+': date.getDate(),                    //日
      'h+': date.getHours(),                   //小时
      'm+': date.getMinutes(),                 //分
      's+': date.getSeconds(),                 //秒
      'q+': Math.floor((date.getMonth() + 3) / 3), //季度
      'S': date.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(format))
      format = format.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
    for (var k in o)
      if (new RegExp('(' + k + ')').test(format))
        format = format.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)));
    return format;
  }

  getChartSearchBarStartTime(date: string) {
    let alarmDate = new Date(date);
    let alarmTime = alarmDate.getTime();
    let nowDate = new Date();
    let twoMonthBfTime = (new Date()).setMonth(nowDate.getMonth() - 2);
    let twoMonthAfTime = (new Date()).setMonth(nowDate.getMonth() + 2);
    let threeMonthBf = (new Date()).setMonth(nowDate.getMonth() - 3);

    if (alarmTime > twoMonthBfTime && alarmTime < twoMonthAfTime) {
      return this.dateFormat(new Date(threeMonthBf), 'yyyy-MM-dd');
    } else {
      let oneMonthBfAlarmTime = alarmDate.setMonth(alarmDate.getMonth() - 1);
      return this.dateFormat(new Date(oneMonthBfAlarmTime), 'yyyy-MM-dd');
    }
  }
}
