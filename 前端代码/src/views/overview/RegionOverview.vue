<template charset="UTF-8">
  <div class="chart-container">
    <div class="linechart" id="lineChart"></div>

    <div class="word">
      <br />
      <br />
      <p class="totaltitle">
        全国中小企业总数量（家）&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp全国中小企业总收入（亿元）
      </p>
      <p class="totaldata">
        &nbsp&nbsp&nbsp&nbsp6355家&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp10038.02亿
      </p>
      <br />
      <p class="parttitle">
        &nbsp&nbsp{{
          area
        }}企业总数量（家）&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{
          area
        }}企业总收入（亿元）
      </p>
      <p class="partdata">
        &nbsp&nbsp&nbsp&nbsp&nbsp{{
          sumnum
        }}家&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{
          totalprofit
        }}亿&nbsp&nbsp&nbsp&nbsp&nbsp
      </p>
      <br />
      <br />
      <br />

      <br />
      <p class="small-text">（点击两下以显示省份数据）</p>
    </div>

    <div class="gaugechart" id="gaugeChart"></div>

    <div class="barchart2" id="barChart2"></div>
    <div class="map" id="mapChart"></div>
    <div class="barchart1" id="barChart1"></div>
  </div>
</template>
  
  <style scoped>
.chart-container {
  background-color: aliceblue;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: repeat(2, 1fr);
  width: 100%;
  height: 100vh;
  padding: 20px;
}

.word {
  width: auto;
  height: auto;
}

.barchart1 {
  width: auto;
  height: 400px;
}
.barchart2 {
  width: auto;
  height: 400px;
}
.linchart {
  width: auto;
  height: 400px;
}
.gausechart {
  width: auto;
  height: auto;
}
.map {
  width: 600px;
  height: 600px;
}
.word {
  width: auto;
  height: auto;
}

.title {
  text-align: center;
  font-size: 30px;
  color: #6272ed;
  letter-spacing: 3px;
}
.totaltitle {
  text-align: center;
  font-weight: bold; /* 加粗文本 */
  font-size: 18px;
}

.totaldata {
  font-size: 30px;
  text-align: center;
  font-weight: bold; /* 加粗文本 */
  color: #0d55a6;
}
.parttitle {
  text-align: center;
  font-weight: bold; /* 加粗文本 */
  font-size: 18px;
}
.partdata {
  font-size: 30px;
  text-align: center;
  font-weight: bold; /* 加粗文本 */
  color: #0d55a6;
}
.small-text {
  text-align: center;
  vertical-align: bottom; /* 底部对齐 */
  font-size: 5px;
  text-align: center;
}
</style>
  
  
  <script>
import { reactive, ref } from "vue";
import * as echarts from "echarts";
import zhongguo from "@/assets/mapJson/data-city.json";
import axios from "axios";

export default {
  data() {
    return {
      sumnum: ref("808"),
      area: ref("北京"),
      totalprofit: ref("1052.33"),
      barChart1Title: "",
      barChart2Title: "北京",
      lineChartTitle: "北京",
      gaugeChartTitle: "北京",
      industryPureProfit: [], //name，value
      industrycompany: [], //name，value

      barChart2yAxis: [
        "其他金融业",
        "航空运输业 ",
        "专用设备制造业",
        "互联网和相关服务 ",
        "软件和信息技术服务业",
        "计算机、通信和其他电子设备制造业",
      ],
      barChart2Series: [15.14, 7.36, 6.74, 4.3, 3.49, 2.27],

      lineChartXAxis: [
        "软件和信息技术服务业",
        "商务服务业 ",
        "互联网和相关服务",
        "计算机、通信和其他电子设备制造业 ",
        "专用设备制造业",
        "专业技术服务业",
      ],
      lineChartSeries: [257, 84, 49, 44, 38, 29],
      gaugeChartrate: 0,
    };
  },
  mounted() {
    // 初始化柱状图1“全国中小企业数量前七省份的平均利润和平均营收”
    const barChart1 = echarts.init(document.getElementById("barChart1"));
    // 配置和数据设置
    const option1 = {
      title: {
        text: this.barChart1Title + "中小企业数量（家）前六省份的平均营收", // 添加图表标题
        left: "center", // 标题居中
        textStyle: {
          fontSize: 16, // 标题字体大小
        },
      },

      tooltip: {
        // 添加tooltip配置项
        trigger: "axis", // 设置触发方式为axis
        formatter: function (params) {
          // 自定义tooltip的显示内容
          const xAxisValue = params[0].name; // 获取横轴数据
          const yAxisValue = params[0].value; // 获取纵轴数据
          return `地区：${xAxisValue}<br>企业平均营收：${yAxisValue}亿元`;
        },
      },
      xAxis: {
        type: "category",
        data: ["广东省", "北京市", "江苏省", "浙江省", "上海市", "山东省"],
      },

      yAxis: {
        name: "亿元",
        type: "value",
      },
      series: [
        {
          data: [1.26, 1.3, 1.36, 1.92, 3.89, 1.12],
          type: "bar",
          showBackground: true,
          backgroundStyle: {
            color: "rgba(180, 180, 180, 0.2)",
          },
          itemStyle: {
            color: "#3398DB", // 修改柱形颜色
          },
        },
      ],
    };
    barChart1.setOption(option1);

    // 初始化柱状图2   全国/各省数量排名前五的行业的平均营收
    const barChart2 = echarts.init(document.getElementById("barChart2"));
    // 配置和数据设置
    const option2 = {
      title: {
        text: this.barChart2Title + "平均利润（亿元）排名前六的行业",
        left: "center", // 标题居中
        textStyle: {
          fontSize: 16, // 标题字体大小
        },
      },
      tooltip: {
        trigger: "axis",
        axisPointer: {
          type: "shadow",
        },
      },
      legend: {
        show: false, // 将show属性设置为false以隐藏图例
      },
      grid: {
        left: "3%",
        right: "4%",
        bottom: "3%",
        containLabel: true,
      },
      xAxis: {
        type: "value",
        boundaryGap: [0, 0.01],
        axisLabel: {
          textStyle: {
            fontSize: 14, // 修改坐标轴标签字体大小
            color: "#666", // 修改坐标轴标签颜色
          },
        },
      },
      yAxis: {
        type: "category",
        data: this.barChart2yAxis,
        axisLabel: {
          textStyle: {
            fontSize: 14, // 修改坐标轴标签字体大小
            color: "#666", // 修改坐标轴标签颜色
          },
        },
      },
      grid: {
        left: "3%",
        right: "4%",
        bottom: "3%",
        containLabel: true,
        backgroundColor: "#f4f4f4", // 修改图表背景颜色
      },

      series: [
        {
          name: "亿元",
          type: "bar",
          data: this.barChart2Series,
          itemStyle: {
            color: "#3398DB", // 修改柱形颜色
          },
        },
      ],
    };
    barChart2.setOption(option2);

    // 初始化折线图
    const lineChart = echarts.init(document.getElementById("lineChart"));
    // 配置和数据设置
    const option3 = {
      animation: true, // 启用动画
      title: {
        text: this.lineChartTitle + "企业数量（家）排名前六行业", // 添加图表标题
        left: "center", // 标题居中
        textStyle: {
          fontSize: 16, // 标题字体大小
        },
      },

      tooltip: {
        // 添加tooltip配置项
        trigger: "axis", // 设置触发方式为axis
        formatter: function (params) {
          // 自定义tooltip的显示内容
          const xAxisValue = params[0].name; // 获取横轴数据
          const yAxisValue = params[0].value; // 获取纵轴数据
          return `行业：${xAxisValue}<br>数量：${yAxisValue}`;
        },
      },

      xAxis: {
        type: "category",
        data: this.lineChartXAxis,
        splitLine: {},
      },

      yAxis: {
        type: "value",
        splitLine: {
          lineStyle: {
            color: "rgba(255, 255, 255, 0.2)",
          },
        },
      },
      series: [
        {
          data: this.lineChartSeries,
          type: "line",
          lineStyle: {
            color: "rgba(102, 204, 255, 0.8)", // 设置线条颜色
            width: 2, // 设置线条宽度
          },
          itemStyle: {
            color: "rgba(102, 204, 255, 0.8)", // 设置数据点颜色
            borderColor: "white", // 设置数据点边框颜色
            borderWidth: 2, // 设置数据点边框宽度
          },
          // 添加数据点动画
          markPoint: {
            data: [
              { type: "max", name: "最大值" },
              { type: "min", name: "最小值" },
            ],
          },
        },
      ],
    };
    lineChart.setOption(option3);

    // 初始化仪表盘
    const gaugeChart = echarts.init(document.getElementById("gaugeChart"));
    // 配置和数据设置
    const option4 = {
      title: {
        text:
          this.gaugeChartTitle +
          "企业健康状况" +
          "\n" +
          "（总资产-总负债）/总资产（全国企业）", // 添加图表标题
        left: "center", // 标题居中
        textStyle: {
          fontSize: 16, // 标题字体大小
        },
      },
      series: [
        {
          type: "gauge",
          startAngle: 180,
          endAngle: 0,
          center: ["50%", "75%"],
          radius: "90%",
          min: 0,
          max: 1,
          splitNumber: 8,
          axisLine: {
            lineStyle: {
              width: 6,
              color: [
                [0.25, "#FF6E76"],
                [0.5, "#FDDD60"],
                [0.75, "#58D9F9"],
                [1, "#7CFFB2"],
              ],
            },
          },
          pointer: {
            icon: "path://M12.8,0.7l12,40.1H0.7L12.8,0.7z",
            length: "12%",
            width: 20,
            offsetCenter: [0, "-60%"],
            itemStyle: {
              color: "auto",
            },
          },
          axisTick: {
            length: 12,
            lineStyle: {
              color: "auto",
              width: 2,
            },
          },
          splitLine: {
            length: 20,
            lineStyle: {
              color: "auto",
              width: 5,
            },
          },
          axisLabel: {
            color: "#464646",
            fontSize: 20,
            distance: -60,
            rotate: "tangential",
            formatter: function (value) {
              //强大（Strong）稳健（Robust） 平衡（Balanced）脆弱（Weak）
              if (value === 0.125) {
                return "脆弱";
              } else if (value === 0.375) {
                return "平衡";
              } else if (value === 0.625) {
                return "稳健";
              } else if (value === 0.875) {
                return "强大";
              }
              return "";
            },
          },
          title: {
            offsetCenter: [0, "-10%"],
            fontSize: 20,
          },
          detail: {
            fontSize: 30,
            offsetCenter: [0, "-35%"],
            valueAnimation: true,
            formatter: function (value) {
              return Math.round(value * 100) + "";
            },
            color: "inherit",
          },
          data: [
            {
              value: 0.41,
              name: "",
            },
          ],
        },
      ],
    };
    gaugeChart.setOption(option4);

    //操作this
    var $this = this;

    // 初始化中国地图
    const mapChart = echarts.init(document.getElementById("mapChart"));
    // 配置和数据设置
    const option5 = {
      // 背景颜色
      backgroundColor: "#F0f8ff",
      // 提示浮窗样式
      tooltip: {
        show: true,
        trigger: "item",
        alwaysShowContent: false,
        backgroundColor: "#0C121C",
        borderColor: "rgba(0, 0, 0, 0.16);",
        hideDelay: 100,
        triggerOn: "mousemove",
        enterable: true,
        textStyle: {
          color: "#DADADA",
          fontSize: "12",
          width: 20,
          height: 30,
          overflow: "break",
        },
        showDelay: 100,
      },
      // 地图配置
      geo: {
        map: "china",
        label: {
          // 通常状态下的样式
          normal: {
            show: false, //取消文本标签
            textStyle: {
              color: "#fff",
            },
          },
          // 鼠标放上去的样式
          emphasis: {
            textStyle: {
              color: "#0C121C",
            },
          },
        },
        // 地图区域的样式设置
        itemStyle: {
          normal: {
            borderColor: "rgba(147, 235, 248, 1)",
            borderWidth: 1,
            areaColor: {
              type: "radial",
              x: 0.5,
              y: 0.5,
              r: 0.8,
              colorStops: [
                {
                  offset: 0,
                  color: "rgba(147, 235, 248, 0)", // 0% 处的颜色
                },
                {
                  offset: 1,
                  color: "rgba(147, 235, 248, .2)", // 100% 处的颜色
                },
              ],
              globalCoord: false, // 缺省为 false
            },
            shadowColor: "rgba(128, 217, 248, 1)",
            shadowOffsetX: -2,
            shadowOffsetY: 2,
            shadowBlur: 10,
          },
          // 鼠标放上去高亮的样式
          emphasis: {
            areaColor: "#389BB7",
            borderWidth: 0,
          },
        },
      },
    };
    echarts.registerMap("china", zhongguo);
    mapChart.setOption(option5);

    //地图的点击事件
    mapChart.on("click", function (params) {
      $this.area = params.name;
      axios({
        method: "POST",
        url: "http://localhost:8082/company/areaAnalysis",
        data: {
          name: params.name,
        },
      }).then(
        (response) => {
          $this.sumnum = response.data.data.companyNumber; //最上面的文字内容(某省的企业数量)
          //$this.sumnum=333333
          var tem;
          tem = response.data.data.totalBusinessIncome / 100000000;

          $this.totalprofit = tem.toFixed(2);

          this.gaugeChartrate =
            (response.data.data.totalAssets - response.data.data.totalDebt) /
            response.data.data.totalAssets;

          this.industryPureProfit = response.data.data.industryPureProfit.slice(
            0,
            6
          );
          this.barChart2yAxis = this.industryPureProfit.map(
            (item) => item.name
          );
          this.barChart2Series = this.industryPureProfit.map(
            (item) => item.value / 100000000
          );

          this.industrycompany = response.data.data.industryCompany.slice(0, 6);
          this.lineChartXAxis = this.industrycompany.map((item) => item.name);
          this.lineChartSeries = this.industrycompany.map((item) => item.value);

          console.log(response.data.data);
          console.log(barChart2Series);

          return response.data;
        },
        (error) => {
          alert("error");
          console.log(error.message);
        }
      );

      console.log("我踏马被点了" + params.name);

      //更新barchart1
      barChart2.setOption({
        title: {
          text: params.name + "净利润(亿元)排名前六的行业",
        },
        yAxis: {
          type: "category",
          data: this.barChart2yAxis,
        },

        series: [
          {
            name: "亿元",
            type: "bar",
            data: this.barChart2Series,
          },
        ],
      });

      lineChart.setOption({
        title: {
          text: params.name + "数量（家）排名前六的行业",
        },
        xAxis: {
          type: "category",
          data: this.lineChartXAxis,
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: this.lineChartSeries,
            type: "line",
          },
        ],
      });

      gaugeChart.setOption({
        title: {
          text:
            params.name +
            "企业健康状况" +
            "\n" +
            "（总资产-总负债）/总资产（全省企业）", //强大（Strong）稳健（Robust） 平衡（Balanced）脆弱（Weak）
        },
        series: [
          {
            data: [
              {
                value: this.gaugeChartrate,
                name: "Grade Rating",
              },
            ],
          },
        ],
      });
      (this.lineChartTitle = params.name), (this.gaugeChartTitle = params.name);
    });
  },
};
</script>
  
