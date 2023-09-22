
<template>
     <el-card class="card">
        <base-echart
        :id="id"
        class="pie-echart2"
        x= 'center'
        width="100%"
        :height="height"
        :option="option"
        />
    </el-card> 
</template>

<script>
import BaseEchart from "./BaseChart.vue";

export default {
  props: {
      dataset:Array,
      title:String,
      ID:String,
      rosetype: String,
      height: String
      //type:Object
  },
  components: {
    BaseEchart,
  },
  data() {
    return {
      id:this.ID,
      option: {
        title: {
          show: true,
          text: this.title,
          // x: "center",
          // y: "top",
        },
        tooltip: {
          trigger: "item",
        },
        
        legend: {
          orient: "vertical",
          left: 'left',
          top: '10%',
        },
        series: [
          {
            name: "Access From",
            type: "pie",
            center: ["50%", "50%"],
            radius: ["20%", "80%"],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: "#fff",
              borderWidth: 2,
            },
            label: {
              show: false,
              position: "center",
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: "bold",
              },
            },
            labelLine: {
              show: false,
            },
            data: this.dataset,
            roseType:this.rosetype
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
/* .card {
     height: 375px; 
    width:100%;
     margin-top:20px;
    margin-left: 20px;
    margin-right: 20px ;
    margin-bottom: 20px ;
} */
.pie-echart2 {
    margin: auto;
    /* width: 1100px;
    height: 600px;  */
}
</style>

