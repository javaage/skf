export const ConstantsOption: any = {
  echarts: {
    lineChartBaseOptions: {
      tooltip : {
        trigger: 'axis'
      },
      toolbox: {
        show : false,
        feature : {
          mark : {show: true},
          dataView : {show: true, readOnly: false},
          magicType : {show: true, type: ['line', 'bar']},
          restore : {show: true},
          saveAsImage : {show: true}
        }
      },
      animation : false,
      dataZoom: {
        show: true,
        start : 0
      },
      calculable : false,
      xAxis : [
        {
          name:'',
          nameLocation : 'center',
          nameGap : 30,
          nameTextStyle: {
            color : '#02BF82',
            fontSize : 16
          },
          type : 'category',
          boundaryGap : false,
          data : [],
          splitLine : {
            show:false
          },
          axisLabel : {
            textStyle:{
              fontSize:14
            }
          },
        }
      ],
      yAxis : [
        {
          splitLine:{show: false},
          name:'',
          nameLocation : 'center',
          nameGap : 30,
          nameTextStyle: {
            color : '#02BF82',
            fontSize : 16
          },
          type : 'value',
          axisLabel : {
            formatter: '{value}',
            textStyle:{
              fontSize:14
            }
          },
          data : []
        }
      ],
      series : [
        {
          name:'',
          type:'line',
          showSymbol: false,
          symbolSize: 10,
          data: [],
          markPoint : {
            symbolSize: 50,
            label : {
              show : true
            },
            data : [
              {
                name: '告警',
                coord: []
              }
            ]
          },
          itemStyle : {
            normal : {
              lineStyle:{
                color:'#02BF82'
              }
            }
          }
        }
      ]
    }
  }
};
