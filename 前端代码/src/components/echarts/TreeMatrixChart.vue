
<template>
  <el-card class="card">
    <base-echart
      class="treeMatrix-echart2"
      x="center"
      width="100%"
      :id="id"
      :height="height"
      :option="option"
    />
  </el-card>
</template>

<script>
import BaseEchart from "./BaseChart.vue";

export default {
  props: {
    dataset: Array,
    title: String,
    ID: String,
    height: String,
    breadcrumbtag: Boolean,
    upperlabeltag: Boolean,
    //type:Object
  },
  components: {
    BaseEchart,
  },
  data() {
    return {
      id: this.ID,
      option: {
        //datazoom: [],
        title: {
          show: true,
          text: this.title,
          x: "center",
          // y: "top",
        },
        tooltip: {
          trigger: "item",
        },

        legend: {
          orient: "vertical",
          left: "left",
          top: "10%",
        },
        series: [
          {
            type: "treemap",
            roam: false,
            nodeClick: false,
            breadcrumb: {
              show: false,
            },
            itemStyle: {
              borderColor: "#fff",
            },
            upperLabel: {
              show: this.upperlabeltag,
            },
            levels: [
              {
                itemStyle: {
                  borderColor: "#777",
                  borderWidth: 0,
                  gapWidth: 1,
                },
                upperLabel: {
                  show: false,
                },
              },
              {
                itemStyle: {
                  borderColor: "#555",
                  borderWidth: 5,
                  gapWidth: 1,
                },
                emphasis: {
                  itemStyle: {
                    borderColor: "#ddd",
                  },
                },
              },
              {
                colorSaturation: [0.35, 0.5],
                itemStyle: {
                  borderWidth: 5,
                  gapWidth: 1,
                  borderColorSaturation: 0.6,
                },
              },
            ],

            data: this.dataset,
          },
        ],
      },
    };
  },
};
</script> 

<style scoped>
.treeMatrix-echart2 {
  margin: auto;
  width: 1100px;
  height: 600px;
}
</style>