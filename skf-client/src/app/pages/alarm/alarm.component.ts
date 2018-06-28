import { Component, OnInit } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import { AlarmService } from '../../@core/data/alarm.service';
import  { ConstantsOption } from '../../@core/app.constants';
import  { MethodsService } from '../../@core/utils/methods.service';

declare let $:any;

@Component({
  selector: 'alarm',
  templateUrl: './alarm.component.html',
  styleUrls: ['./alarm.component.scss']
})
export class AlarmComponent implements OnInit {
  // 报警分类参数
  alarmTotalOptions: any[] = [];
  private currentAlarmTab: any = {id: 'default'};
  private isCollapse: boolean = true;

  // 报警列表参数
  private currentPageNum: number = 0;
  private totalPageNum: number = 0;
  private tableLists: any[] = [];
  private currentTableRow: any = {id: 'default'};

  // 报警列表搜索栏部分参数
  private deviceDropDownOptions: any[] = [];
  private currentDeviceFilter: any;
  private sensorDropDownOptions: any[] = [];
  private currentSensorFilter: any;
  private statusDropDownOptions: any[] = [];
  private currentStatusFilter: any;
  private currentSortRowType: string = 'status';
  private isSortByAsc: boolean = true;
  private filterStartTime: string;
  private filterEndTime: string;
  private filterStartScore: string;
  private filterEndScore: string;

  // 报警详情信息
  alarmDetailInfo: any = {};
  private responseSpectrogramOpts:any;
  dangerLevel: string;
  dangerAmountLevel: string;
  dangerLevelOpts: any = {
    dangerLevel: {
      flag: true,
      label: "Danger Level",
      message: ""
    },
    dangerAmountLevel: {
      flag: true,
      label: "Danger Amount Level",
      message: ""
    }
  };
  // 备注
  private notesList: any[] = [];
  private noteMessage: string;
  // 折线图搜索栏
  private thresholdValue: number = 0;
  private chartStartTime: string;
  private chartEndTime: string;
  // 频谱图Tab
  private SPECTROGRAM_TAB: string[] = [];
  private spectrogramTabOptions: any[];
  private currentSpectrogramTab: any;
  // echarts图表
  private lineChartOptions: any;
  private spectrogramOptions: any;
  private lineEchartsInstance: any;
  private spectrogramInstance: any;

  constructor(private alarmService: AlarmService,
              private methods: MethodsService,
              private translate: TranslateService) {}

  ngOnInit() {
    // 获取报警总数信息
    this.getAlarmTotalData();

    // 频谱图Tab国际化
    this.SPECTROGRAM_TAB = ["ALARM_DETAIL_PANEL_TAB1",
      "ALARM_DETAIL_PANEL_TAB2",
      "ALARM_DETAIL_PANEL_TAB3",
      "ALARM_DETAIL_PANEL_TAB4"
    ];

    // 折线图及频谱图初始化
    this.lineChartOptions = this.methods.extendJSONObject(ConstantsOption.echarts.lineChartBaseOptions);
    this.spectrogramOptions = this.methods.extendJSONObject(ConstantsOption.echarts.lineChartBaseOptions);
  }

  /** 报警分类部分Function */
  getAlarmTotalData() {
    console.log("getAlarmTotalData()");

    this.alarmService.getAlarmTotalData().subscribe((data) => {
      console.log("getAlarmTotalData, response:", data);

      if (data && data.length > 0) {
        this.alarmTotalOptions = data;
        // this.currentAlarmTab = this.alarmTotalOptions[0];

        // 获取检索栏下拉框内容
        this.getDropdownFilterData();
      }
    }, (error) => {
      console.log("getAlarmTotalData error:", error);
    });
  }

  onClickAlarmTab(item) {
    if (this.currentAlarmTab.id != item.id) {
      this.isCollapse = false;

      this.currentAlarmTab = item;
      this.currentPageNum = 0;

      // 获取Alarm Table List By filter
      this.getAlarmListData();
    } else {
      this.isCollapse = !this.isCollapse;
    }
    this.currentTableRow = {id: 'default'};
  }


  /** 预警列表部分Function */
  getAlarmListData() {
    // 获取Alarm Table List By filter
    let params = {
      warningType: this.currentAlarmTab.id,
      sortByRowType: this.currentSortRowType,
      isSortByAsc: this.isSortByAsc,
      currentPageNum: this.currentPageNum + 1,
      selectDevice: this.currentDeviceFilter.id,
      selectSensor: this.currentSensorFilter.id,
      selectStatus: this.currentStatusFilter.id,
      startTime: this.filterStartTime,
      endTime: this.filterEndTime,
      startScore: this.filterStartScore,
      endScore: this.filterEndScore
    };
    this.getAlarmListInfo(params);
  }

  getAlarmListInfo(params) {
    console.log("getAlarmListData() params: ", params);

    this.alarmService.getAlarmListData(params).subscribe((data) => {
      console.log("getAlarmListData, response:", data);

      if (data && data.tableList) {
        this.tableLists = data.tableList;

        if (data.tableList.length > 0) {
          // 报警类型（1：总值报警，2：轴承报警）
		      for (let i = 0; i < data.tableList.length; i++) {
            if (data.tableList[i].type == 1) {
              data.tableList[i].typeValue = this.translate.instant("ALARM_TYPE1");
            } else if (data.tableList[i].type == 2) {
              data.tableList[i].typeValue = this.translate.instant("ALARM_TYPE2");
            }
          }

          // this.currentTableRow = this.tableLists[0];

          // // 获取第一行的详细信息
          // let params = {
          //   startDate: this.chartStartTime,
          //   endDate: this.chartEndTime,
          //   thresholdValue: this.thresholdValue ? this.thresholdValue : 0,
          //   rowId: this.currentTableRow.id
          //   alarmType: this.currentTableRow.type
          // };
          // this.getAlarmDetailData(params);
        }

        this.totalPageNum = data.totalPageNum;
      }
    }, (error) => {
      console.log("getAlarmListData error:", error);
    });
  }

  pageChange(pageNum) {
    this.currentPageNum = pageNum;

    // 获取Alarm Table List By filter
    this.getAlarmListData();
  }

  onClickSort(rowType) {
    if (this.currentSortRowType == rowType) {
      this.isSortByAsc = !this.isSortByAsc;
    } else {
      this.currentSortRowType = rowType;
      this.isSortByAsc = true;
    }

    // 获取Alarm Table List By filter
    this.getAlarmListData();
  }

  onClickTableRow(row){
    if (this.currentTableRow.id != row.id) {
      this.currentTableRow = row;

      // 时间选择搜索栏赋默认值
      // alarmTime在两个月之内，起始时间为三个月前的时间
      // alarmTime不在两个月之内，起始时间为alarmTime之前的一个月的时间
      this.chartStartTime = this.methods.getChartSearchBarStartTime(row.alarmTime);
      this.chartEndTime = this.methods.dateFormat(new Date(), 'yyyy-MM-dd');

      let params = {
        startDate: this.chartStartTime,
        endDate: this.chartEndTime,
        thresholdValue: this.thresholdValue ? this.thresholdValue : 0,
        rowId: row.id,
        alarmType: row.type
      };
      this.getAlarmDetailData(params);

      // if (this.currentAlarmTab.status != 'processed') {
        // 获取备注列表
        let opts = {
          rowId: row.id,
          alarmType: row.type
        };
        this.getNotesListData(opts);
      // }
    }
  }


  /** 搜索栏部分Function */
  getDropdownFilterData() {
    console.log("getDropdownFilterData()");

    this.alarmService.getDropdownFilterData().subscribe((data) => {
      console.log("getDropdownFilterData, response:", data);

      if (data) {
        if (data.device) {
          // 联动下拉框
          this.deviceDropDownOptions = data.device;
          this.currentDeviceFilter = this.deviceDropDownOptions[0];

          this.getSensorDropDownData();
        }
        if (data.status) {
          // 状态下拉框
          this.statusDropDownOptions = data.status;
          this.currentStatusFilter = this.statusDropDownOptions[0];
        }

        // // 获取Alarm Table List By filter
        // this.getAlarmListData();
      }
    }, (error) => {
      console.log("getDropdownFilterData error:", error);
    });
  }

  getSensorDropDownData() {
    for (let i = 0, len = this.deviceDropDownOptions.length; i < len; i++) {
      if (this.currentDeviceFilter.id == this.deviceDropDownOptions[i].id) {
        this.sensorDropDownOptions = this.deviceDropDownOptions[i].data;
        this.currentSensorFilter = this.sensorDropDownOptions[0];
      }
    }
  }

  onDeviceChange(item) {
    this.currentDeviceFilter = item;
    this.getSensorDropDownData();
  }

  onSensorChange(item) {
    this.currentSensorFilter = item;
  }

  onStatusChange(item) {
    this.currentStatusFilter = item;
  }

  onTableFilterSubmit() {
    // 获取Alarm Table List By filter
    this.getAlarmListData();
  }


  /** 点击Table Row展开部分Function */
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
    if (this.currentTableRow.status == "A") {
      data.descriptionMsg = this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE1");
    } else if (this.currentTableRow.status == "B") {
      data.descriptionMsg = `${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_1")}
        ${data.description.val3}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_4")}
        ${Number(data.description.val1).toFixed(3)}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_2")}
        ${this.translate.instant("ALARM_DETAIL_PANEL_DESCRIBE2_3")}`;
    } else if (this.currentTableRow.status == "C") {
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

  drawSpectrogramGraph(data) {
    if (data.yAxisData.length > 0) {
      let xAxisData = [];
      let gap = data.xAxisMax / (data.yAxisData.length - 1);
      for (let i = 0, len = data.yAxisData.length; i < len; i++) {
        xAxisData[i] = Number(gap*i).toFixed(2);
      }
      // 根据选择的Tab计算频谱图标记点
      let markPointCoord = this.generateMarkPointCoord(data, xAxisData);

      // 图表option数据赋值
      this.spectrogramOptions.tooltip.formatter =  function (params) {
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
          markPointCoord.push({coord: [xAxisData[j], data.yAxisData[j]]});
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

  onClickLineChartSearch() {
    let params = {
      startDate: this.chartStartTime,
      endDate: this.chartEndTime,
      thresholdValue: this.thresholdValue,
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type
    };
    this.getAlarmDetailData(params);
  }

  onClickSpectrogramTab(item) {
    if (this.currentSpectrogramTab.id != item.id) {
      this.currentSpectrogramTab = item;

      // 画频谱图
      this.drawSpectrogramGraph(this.responseSpectrogramOpts);
    }
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
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type,
      markPointVal: (new Date(event.name)).getTime()
    };
    this.getSpectrogramData(params);
  }


  /** 添加备注，备注列表Function */
  getNotesListData(params) {
    console.log("getNotesListData() params: ", params);

    this.alarmService.getNotesListData(params).subscribe((data) => {
      console.log("getNotesListData, response:", data);

      if (data) {
        this.notesList = data;
      }
    }, (error) => {
      console.log("getNotesListData error:", error);
    });
  }

  onClickNoteYesBtn() {
    console.log("onClickNoteYesBtn(), noteMessage:", this.noteMessage);

    let body = {
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type,
      warningType: this.currentAlarmTab.id,
      noteMsg: this.noteMessage
    };
    this.alarmService.saveNoteMessage(body).subscribe((data) => {
      console.log("saveNoteMessage, response:", data);

      // 重新获取备注列表信息
      this.getNotesListData(body);
      this.noteMessage = "";
    }, (error) => {
      console.log("saveNoteMessage, error:", error);

      // TODO(just for test, as post method aways response failed)
      this.getNotesListData(body);
      this.noteMessage = "";
    });
  }

  onClickNoteNoBtn() {
    console.log("onClickNoteNoBtn()");

    this.noteMessage = "";
  }


  // 未处理的报警
  onClickProcessBtn() {
    console.log("onClickProcessBtn()");

    let body = {
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type
    };
    this.alarmService.doAlarmProcess(body).subscribe((data) => {
      console.log("doAlarmProcess, response:", data);

      // 获取报警总数信息
      this.getAlarmTotalData();
    }, (error) => {
      console.log("doAlarmProcess, error:", error);
    });
  }

  // 处理中的报警
  onClickStopProcessBtn() {
    console.log("onClickStopProcessBtn()");

    let body = {
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type
    };
    this.alarmService.stopAlarmProcess(body).subscribe((data) => {
      console.log("stopAlarmProcess, response:", data);

      // 获取报警总数信息
      this.getAlarmTotalData();
    }, (error) => {
      console.log("stopAlarmProcess, error:", error);
    });
  }

  // 已处理的报警
  onClickReProcessBtn() {
    console.log("onClickReProcessBtn()");

    let body = {
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type
    };
    this.alarmService.reHandleAlarmProcess(body).subscribe((data) => {
      console.log("reHandleAlarmProcess, response:", data);

      // 获取报警总数信息
      this.getAlarmTotalData();
    }, (error) => {
      console.log("reHandleAlarmProcess, error:", error);
    });
  }
  saveAlarmDangerLevel() {
    console.log("new danger amount level:", this.dangerAmountLevel);
    console.log("new danger level:", this.dangerLevel);

    let checkFlag = this.doCheck();
    if (checkFlag) {
      // 关闭弹出框
      $('#dangerLevelModalCenter').modal('hide');

      // 将更改后的值写入数据库
      let body = {
        rowId: this.currentTableRow.id,
        alarmType: this.currentTableRow.type,
        dangerLevel: this.dangerLevel,
        dangerAmountLevel: this.dangerAmountLevel
      };
      this.alarmService.saveAlarmDangerLevel(body).subscribe((data) => {
        console.log("saveAlarmDangerLevel, response:", data);

       	if (data.status == "success") {
       	  alert("save success");
			    let params = {
	          startDate: this.chartStartTime,
	          endDate: this.chartEndTime,
	          thresholdValue: this.thresholdValue ? this.thresholdValue : 0,
	          rowId: this.currentTableRow.id,
	          alarmType: this.currentTableRow.type
	        };
	        this.getAlarmDetailData(params);
		    }
      }, (error) => {
        console.log("saveAlarmDangerLevel, error:", error);
      });

      // 清空输入框
      this.dangerLevel = "";
      this.dangerAmountLevel = "";
    }

  }
  doCheck() {
    let retVal = true;
    this.dangerLevelOpts = {
      dangerLevel: {
        flag: true,
        label: "Danger Level",
        message: ""
      },
      dangerAmountLevel: {
        flag: true,
        label: "Danger Amount Level",
        message: ""
      }
    };
    if (!this.dangerLevel) {
      this.dangerLevelOpts.dangerLevel.flag = false;
      this.dangerLevelOpts.dangerLevel.message = `Please make sure ${this.dangerLevelOpts.dangerLevel.label} is not empty.`;
      retVal = false;
    }
    if (!this.dangerAmountLevel) {
      this.dangerLevelOpts.dangerAmountLevel.flag = false;
      this.dangerLevelOpts.dangerAmountLevel.message = `Please make sure ${this.dangerLevelOpts.dangerLevel.label} is not empty.`;
      retVal = false;
    }

    return retVal;
  }
  onClickProcessedDelBtn() {
    console.log("onClickProcessedDelBtn()");

    let body = {
      rowId: this.currentTableRow.id,
      alarmType: this.currentTableRow.type
    };
    this.alarmService.deleteAlarmProcess(body).subscribe((data) => {
      console.log("deleteAlarmProcess, response:", data);

      // 获取报警总数信息
      this.getAlarmTotalData();
    }, (error) => {
      console.log("deleteAlarmProcess, error:", error);
    });
  }
}
