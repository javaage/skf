import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { DataService } from '../../../@core/data/data.service';
import { NgModel } from '@angular/forms';
import { LocalStorageService } from 'angular-2-local-storage';
import { activePath } from '../activePath';
import { Constant } from '../../../@core/data/constant';
import { AlarmService } from '../../../@core/data/alarm.service';
import { MethodsService } from '../../../@core/utils/methods.service';
import { DatePipe } from '@angular/common';
import  { ConstantsOption } from '../../../@core/app.constants';

@Component({
  selector: 'component-detail',
  templateUrl: './component-detail.component.html',
  styleUrls: ['./component-detail.component.scss']
})
export class ComponentDetailComponent implements OnInit {
  componentScore: any = {};
  alarmDetailInfo: any = {};
  responseSpectrogramOpts: any;
  spectrogramTabOptions: any[];
  currentSpectrogramTab: any;
  //currentTableRow: any = { id: 'default' };
  spectrogramOptions: any;
  lineChartOptions: any;
  lineEchartsInstance: any;
  spectrogramInstance: any;
  chartStartTime: string;
  chartEndTime: string;
  thresholdValue: number = 0;

  constructor(private dataService: DataService,
    private alarmService: AlarmService,
    private translate: TranslateService,
    private methods: MethodsService,
    private activatedRoute: ActivatedRoute,
    private localStorageService: LocalStorageService,
    private datePipe : DatePipe,
    private router: Router) {
  }

  ngOnInit() {
    activePath.load(this.localStorageService.get('activePath'));
    if (!activePath.componentCode) {
      this.router.navigate(['/pages/device/dashboard']);
      return;
    }

    this.componentScore.code = activePath.componentCode;
    this.lineChartOptions = this.methods.extendJSONObject(ConstantsOption.echarts.lineChartBaseOptions);
    this.spectrogramOptions = this.methods.extendJSONObject(ConstantsOption.echarts.lineChartBaseOptions);

    if (this.componentScore.code) {
      this.dataService.getComponentScoreByID(this.componentScore.code).subscribe((reult: any) => {
        if (reult.code == 1) {
          this.componentScore = reult.data;

          // 时间选择搜索栏赋默认值
          // alarmTime在两个月之内，起始时间为三个月前的时间
          // alarmTime不在两个月之内，起始时间为alarmTime之前的一个月的时间

          let threeMonthBf = (new Date()).setMonth(new Date().getMonth() - 3);

          this.chartStartTime = this.datePipe.transform(threeMonthBf,'yyyy-MM-dd');
          this.chartEndTime = this.datePipe.transform(new Date(),'yyyy-MM-dd');

          let params = {
            startDate: this.chartStartTime,
            endDate: this.chartEndTime,
            thresholdValue: this.thresholdValue ? this.thresholdValue : 0,
            rowId: this.componentScore.code,
            alarmType: 2
          };
          this.getAlarmDetailData(params);
        }
      });
    }
  }

  onClickSpectrogramTab(item) {
    if (this.currentSpectrogramTab.id != item.id) {
      this.currentSpectrogramTab = item;

      // 画频谱图
      this.drawSpectrogramGraph(this.responseSpectrogramOpts);
    }
  }

  getAlarmDetailData(params) {
    console.log("getAlarmDetailData() params: ", params);

    this.alarmService.getAlarmDetailData(params).subscribe((data) => {
      console.log("getAlarmDetailData, response:", data);

      if (data) {
        // 预警描述国际化
        this.generateDescMessage(data);
        this.alarmDetailInfo = data;

        this.responseSpectrogramOpts = data.spectrogram;
        // 频谱图Tab赋值
        this.spectrogramTabOptions = data.spectrogram.spectrogramTab;
        // for (let i = 0; i < data.spectrogram.spectrogramTab.length; i++) {
        //   data.spectrogram.spectrogramTab[i].name = this.SPECTROGRAM_TAB[i];
        // }
        // this.currentSpectrogramTab = this.spectrogramTabOptions[0];
        this.currentSpectrogramTab = {
          id: 'default',
          value: data.spectrogram.defectFreqOrder
        };

        // 画折线图
        this.drawLineGraph(data.lineChart);
        // 画频谱图
        this.drawSpectrogramGraph(data.spectrogram);
      }
    }, (error) => {
      console.log("getAlarmDetailData error:", error);
    });
  }

  generateDescMessage(data) {
    if (this.componentScore.calss == "A") {
      data.descriptionMsg = this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE1");
    } else if (this.componentScore.calss == "B") {
      data.descriptionMsg = `${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_1")}
        ${data.description.val3}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_4")}
        ${Number(data.description.val1).toFixed(3)}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_2")}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_3")}`;
    } else if (this.componentScore.calss == "C") {
      data.descriptionMsg = `${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_1")}
        ${data.description.val3}        
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_4")}        
        ${Number(data.description.val1).toFixed(3)}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_2")}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE3_3")}`;
    }
  }

  drawLineGraph(data) {
    for (let i = 0, len = data.xAxisData.length; i < len; i++) {
      let timestamp = data.xAxisData[i];
      data.xAxisData[i] = this.methods.dateFormat(new Date(timestamp), "yyyy-MM-dd hh:mm:ss");
    }
    data.markPointCoord[0] = this.methods.dateFormat(new Date(data.markPointCoord[0]), "yyyy-MM-dd hh:mm:ss");

    // 图表option数据赋值
    this.lineChartOptions.xAxis[0].data = data.xAxisData;
    this.lineChartOptions.yAxis[0].data = data.yAxisData;
    this.lineChartOptions.series[0].data = data.yAxisData;
    this.lineChartOptions.series[0].markPoint.data[0].coord = data.markPointCoord;
    this.lineChartOptions.series[0].markPoint.data[0].value = data.markPointCoord[1];

    // 绘制折线图
    if (this.lineEchartsInstance) {
      this.lineEchartsInstance.resize();
      this.lineEchartsInstance.clear();
      this.lineEchartsInstance.setOption(this.lineChartOptions);
    }
  }

  drawSpectrogramGraph(data) {
    if (data.yAxisData.length > 0) {
      let xAxisData = [];
      let gap = data.xAxisMax / (data.yAxisData.length - 1);
      for (let i = 0, len = data.yAxisData.length; i < len; i++) {
        xAxisData[i] = Number(gap * i).toFixed(2);
      }
      // 根据选择的Tab计算频谱图标记点
      let markPointCoord = this.generateMarkPointCoord(data, xAxisData);

      // 图表option数据赋值
      this.spectrogramOptions.tooltip.formatter = function (params) {
        let axisValue = params[0].axisValue;
        let retVal = '';
        // 选择点所对应的x轴数组下标
        let selectValueIndex = xAxisData.indexOf(Number(axisValue).toFixed(2));
        if (selectValueIndex > 0) {
          let count = 1, multiIndex = selectValueIndex;
          // 展示所选择点所对应的1,2,3,4,5倍的值，最多展示五条
          while ((multiIndex < xAxisData.length) && (count < 6)) {
            retVal += `<span style="font-size: 20px; color: #D53A35;"> ● </span>
                       <span>${xAxisData[multiIndex]}: ${data.yAxisData[multiIndex]}</span>
                       </br>`;
            multiIndex = selectValueIndex * (++count);
          }
        }
        return retVal;
      };
      this.spectrogramOptions.grid = { bottom: 90 };
      this.spectrogramOptions.xAxis[0].data = xAxisData;
      this.spectrogramOptions.xAxis[0].name = this.translate.instant("ALARM_DETAIL_PANEL_XAXIS_NAME");
      this.spectrogramOptions.yAxis[0].data = data.yAxisData;
      this.spectrogramOptions.yAxis[0].name = this.translate.instant("ALARM_DETAIL_PANEL_YAXIS_NAME");
      this.spectrogramOptions.yAxis[0].nameGap = 45;
      this.spectrogramOptions.series[0].data = data.yAxisData;
      this.spectrogramOptions.series[0].markPoint.symbol = 'diamond';
      this.spectrogramOptions.series[0].markPoint.symbolSize = '15';
      this.spectrogramOptions.series[0].markPoint.data = markPointCoord;
    }

    // 绘制折线图
    if (this.spectrogramInstance) {
      this.spectrogramInstance.resize();
      this.spectrogramInstance.clear();
      this.spectrogramInstance.setOption(this.spectrogramOptions);
    }
  }

  generateMarkPointCoord(data, xAxisData) {
    let markPointCoord = [];

    let markCount: number = Number((Number(data.xAxisMax) / this.currentSpectrogramTab.value).toFixed(0));
    markCount = markCount > 5 ? 5 : markCount;
    for (let i = 0; i < markCount; i++) {
      let target = this.currentSpectrogramTab.value * (i + 1);
      for (let j = 0; j < xAxisData.length; j++) {
        if ((xAxisData[j] == target)) {
          markPointCoord.push({ coord: [xAxisData[j], data.yAxisData[j]] });
        } else {
          if (xAxisData[j] < target && xAxisData[j+1] > target) {
            if (Number(xAxisData[j]) + Number(xAxisData[j+1]) >= 2 * target) {
              markPointCoord.push({coord: [xAxisData[j], data.yAxisData[j]]});
            } else {
              markPointCoord.push({coord: [xAxisData[j+1], data.yAxisData[j+1]]});
            }
          }
        }
      }
    }
    return markPointCoord;
  }

  onChartInit(instance, type) {
    console.log("onChartInit() instance: ", instance);

    if (type == 'line') {
      this.lineEchartsInstance = instance;
    } else {
      this.spectrogramInstance = instance;
    }
  }

  onlineChartClick(event) {
    console.log("onlineChartClick() event: ", event);

    // 点击折线图的某一点后重新刷新频谱图
    let params = {
      rowId: this.componentScore.code,
      alarmType: 2,
      markPointVal: (new Date(event.name)).getTime()
    };
    this.getSpectrogramData(params);
  }

  getSpectrogramData(params) {
    console.log("getSpectrogramData() params: ", params);

    this.alarmService.getSpectrogramData(params).subscribe((data) => {
      console.log("getSpectrogramData, response:", data);

      if (data) {
        this.responseSpectrogramOpts = data;

        // 频谱图Tab赋值
        // this.spectrogramTabOptions = data.spectrogramTab;
        // for (let i = 0; i < data.spectrogramTab.length; i++) {
        //   data.spectrogramTab[i].name = this.SPECTROGRAM_TAB[i];
        // }
        // this.currentSpectrogramTab = this.spectrogramTabOptions[0];
        this.currentSpectrogramTab = {
          id: 'default',
          value: data.defectFreqOrder
        };

        // 画频谱图
        this.drawSpectrogramGraph(data);
      }
    }, (error) => {
      console.log("getSpectrogramData error:", error);
    });
  }

  onClickLineChartSearch() {
    let params = {
      startDate: this.chartStartTime,
      endDate: this.chartEndTime,
      thresholdValue: this.thresholdValue ? this.thresholdValue : 0,
      rowId: this.componentScore.code,
      alarmType: 2
    };

    this.getAlarmDetailData(params);
  }

  goBack(){
    this.router.navigate(['/pages/device/assemble']);
  }
}

