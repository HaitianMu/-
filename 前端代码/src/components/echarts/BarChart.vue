<template>
   <el-card class="card">
        <base-echart
        id="bar-echart"
        class="bar-echart"
        x= 'center'
        :option="option"
        />
    </el-card>
</template>

<script>
import BaseEchart from "./BaseChart.vue";

export default {
  props: {
    xAxisdata:[],
    ydata:[]
  },
  components: {
    BaseEchart,
  },
  data() {
    return {
      option: {
        grid: {
            right: "10%",
            left: "10%",
        },
        xAxis: {
          type: "category",
          data: this.xAxisdata,
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            type: "bar",
            data:this.ydata,
            showBackground: true,
            backgroundStyle: {
              color: "rgba(180, 180, 180, 0.2)",
            },
          },
        ],
      },
    };
  },
  mounted() {
    
  },
};
</script>
<style scoped>
.card {
    height: 375px;
    width:100%;
    margin-top:20px;
    margin-left: 20px;
    margin-right: 20px ;
    margin-bottom: 20px ;
}
.bar-echart {
    margin: auto;
    width: 1100px;
    height: 600px;
}
</style>