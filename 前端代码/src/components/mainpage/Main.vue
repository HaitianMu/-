<template>
  <div class="main">
    <div class="search">
      <el-input v-model="fullName" class="input" placeholder="请输入企业名称关键字" />
      <el-button color="#626aef" @click="search" class="search-button">搜索</el-button>
    </div>
      <tree-matrix-chart  class="companyNumber" v-bind="companyNumber" v-if="cNflag"/>
  </div>
</template>




<script lang="ts" setup>

</script>



<script lang="ts">
import { ElMessage } from 'element-plus';
import TreeMatrixChart from "../../components/echarts/TreeMatrixChart.vue";
import company from "../../utils/company";


export default {
  components: {
    TreeMatrixChart,
  },
  data() {
    return {
      UserID: "",
      fullName: "",
      area: "",
      registeredAssets: "",
      totalAssets: "",
      pureProfit: "",
      industryClassfication: "",


      cNflag:false,
      iPPflag:false,
      iAflag:false,
      cAflag:false,
      cBflag:false,
      companyNumber: {
        ID:"全国上市企业数量概览",
        title: "全国各地上市企业数量概览",
        height: "100vh",
        breadcrumbtag: true,
        upperlabeltag: true,
        dataset: [{name:"A",value:10,children:[{name:"A",value:10}]},{name:"B",value:5,children:[{name:"B",value:5}]}],
      },
    };
  },
created() {
    company.searchall().then((response) => {
      console.log(response.data);
      this.companyNumber.dataset=response.data.data.areaCompany.slice(0,15)
      console.log(response.data.data.areaCompany.length)
      this.cNflag=!this.cNflag
    });
  },
  methods: {
    search: function () {
      if(this.$route.query.userID==null){
        ElMessage("请先登录")
        return
      }
      const fullName = this.fullName;
      const area = this.area;
      const registeredAssets = this.registeredAssets;
      const totalAssets = this.totalAssets;
      const pureProfit = this.pureProfit;
      const industryClassfication = this.industryClassfication;

      this.$router.push({
          path:'/searchresult',
          query: { userID:this.$route.query.userID,fullName: fullName, area:area,registeredAssets:registeredAssets,totalAssets:totalAssets,pureProfit:pureProfit,industryClassfication:industryClassfication }
      })
    },
  },
};
</script>

  <style scoped>
/* 根容器样式 */
.main {
  max-width: 100%;
  margin: 0 auto;
  padding: 20px;
}

/* 搜索框样式 */
.search {
  display: flex;
  width: 1000px;
  align-items: center;
  margin-bottom: 20px;
  background-color: #626aef;
}

.input {
  flex: 1;
  margin-right: 10px;
  border-radius: 5px; /* 圆角边框 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}

.search-button {
  background-color: #626aef;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 添加阴影效果 */
}

.search-button:hover {
  background-color: #4952cc;
}

/* 关注列表样式 */
.like {
  width: 800px;
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.like h3 {
  font-size: 24px;
  color: #333;
  margin-bottom: 10px;
}

/* 表格样式 */
.el-table {
  width: 100%;
}

/* 表格列样式 */
.el-table-column {
  text-align: center;
}

/* 表格数据行样式 */
.el-table-row {
  background-color: #f9f9f9;
}

/* 鼠标悬停时的表格行样式 */
.el-table-row:hover {
  background-color: #e2e2e2;
}
.companyNumber{
background-color: aliceblue;
height: 80%;
}
</style>