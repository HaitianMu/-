<template>
  <div class="allcontainer">
    <el-header class="header">
      <el-row>
        <el-col :span="16">
          <el-button type="primary" @click="back_to_main"> 返回主页 </el-button>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="to_region"> 地区概览 </el-button>
        </el-col>
      </el-row>
    </el-header>
    <pie-chart  class="companyAssets" v-bind="companyAssets" v-if="cAflag" />
    <pie-chart class="companyAssets" v-bind="companyBad" v-if="cBflag"/>
    <tree-matrix-chart class="companyAssets" v-bind="industryAssets" v-if="iAflag"/>
    <tree-matrix-chart class="companyAssets" v-bind="industryPureProfit" v-if="iPPflag"/>
  </div>
</template>

<style scoped>
.allcontainer{
  width:100%;
  background-color:aliceblue;
  padding:10px
}
.companyAssets{
  background-color: aliceblue;
  margin: 20px 100px ;
}
</style>

<script>
import BarChart from "../../components/echarts/BarChart.vue";
import PieChart from "../../components/echarts/PieChart.vue";
import TreeMatrixChart from "../../components/echarts/TreeMatrixChart.vue";
import company from "../../utils/company";
export default {
  components: {
    BarChart,
    PieChart,
    TreeMatrixChart,
  },
  data() {
    return {
      userID: "",
      cNflag:false,
      iPPflag:false,
      iAflag:false,
      cAflag:false,
      cBflag:false,
      companyNumber: {
        ID:"全国上市企业数量(家)概览",
        title: "全国各地上市企业数量(家)概览",
        height: "100vh",
        breadcrumbtag: true,
        upperlabeltag: true,
        dataset: [{name:"A",value:10,children:[{name:"A",value:10}]},{name:"B",value:5,children:[{name:"B",value:5}]}],
      },
      companyBad: {
        ID:"全国上市企业失信数量(家)概览",
        title: "全国各地上市企业失信数量(家)概览",
        height: "100vh",
        //breadcrumbtag: false,
        //upperlabeltag: false,
        rosetype: 'angle',
        dataset: [{name:"A",value:10,children:[{name:"A",value:10}]},{name:"B",value:5,children:[{name:"B",value:5}]}],
      },
      companyAssets: {
        ID:"全国各地企业资产(元)概览",
        title: "全国各地企业资产(元)概览",
        breadcrumbtag: false,
        upperlabeltag: false,
        dataset: [{name:"A",value:10},{name:"B",value:3}],
        height: "100vh",
        rosetype: 'angle',
      },
      industryAssets: {
        title: "全国各行业资产(元)概览",
        ID:"全国各行业资产(元)概览",
        dataset: [{name:"A",value:10},{name:"B",value:5}],
        //rosetype: 'angle',
        height: "100vh",
      },
      industryPureProfit: {
        ID: "全国各行业净利润(元)概览",
        title: "全国各行业净利润(元)概览",
        dataset: [{name:"A",value:10},{name:"B",value:5}],
        //rosetype:'angle',
        height: "100vh",
      },
    };
  },
  methods: {
    back_to_main() {
      this.$router.push({
        path: "/",
        query: { userID: this.$route.query.userID },
      });
    },
    to_region(){
      this.$router.push({
        path:"/overview/region",
        query: { userID: this.userID },
      })
    }
  },
  mounted() {
    this.userID = this.$route.query.userID;
  },
  created() {
    company.searchall().then((response) => {
      console.log(response.data);
     
      this.industryAssets.dataset=response.data.data.industryPureAssets.slice(0,15)//取数据中的前十五条绘制直方图
      this.industryPureProfit.dataset=response.data.data.industryPureProfit.slice(0,15)//取数据中的前十五条绘制直方图
      this.companyAssets.dataset=response.data.data.areaAssets.slice(0,10)//取数据中的前十条绘制饼状图
      this.companyBad.dataset=response.data.data.areaBad.slice(0,10)//取数据中的前十条绘制饼状图
      this.cBflag=!this.cBflag
      this.cNflag=!this.cNflag
      this.iPPflag=!this.iPPflag
      this.iAflag=!this.iAflag
      this.cAflag=!this.cAflag
    });
  },
};
</script>
