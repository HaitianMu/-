<script>
import company from "../../utils/company";

export default {
  data() {
    return {
      totalresult:0,
      UserID: "",
      fullName: "",
      area: "",
      registeredAssets: 0,
      totalAssets: 0,
      pureProfit: 0,
      industryClassfication: "",
      companylist: [],
      current_page: 1,
      page_size: 15,
    };
  },
  created(){
    
    this.fullName=this.$route.query.fullName
    this.userID=this.$route.query.userID
    this.area=this.$route.query.area
    this.totalAssets=this.$route.query.totalAssets
    this.pureProfit=this.$route.query.pureProfit
    this.industryClassfication=this.$route.query.industryClassfication
    this.search()



  },
  methods: {
    returnback:function(){
      this.$router.push({
        path:"/",
        query:{userID:this.userID}
      })
    },

    
    search: function () {
      var _this = this;
      
      let fullName = "";
      if(this.fullName!=null){
        fullName=this.fullName
      }
      const area = this.area;
      const registeredAssets = this.registeredAssets;
      const totalAssets = this.totalAssets;
      const pureProfit = this.pureProfit;
      const industryClassfication = this.industryClassfication;
      const current_page = this.current_page;
      const page_size = this.page_size;
      const data = {
        fullName: fullName,
        area: area,
        registeredAssets: registeredAssets,
        totalAssets: totalAssets,
        pureProfit: pureProfit,
        industryClassfication: industryClassfication,
        page: current_page,
        pagesize: page_size,
      };
      company.searchCompany(data).then((response) => {
        console.log(response.data);
        _this.companylist = response.data.data.records;
        _this.totalresult=response.data.data.total;
        console.log("companylist:"+_this.companylist);
        console.log(response.data.total)
        console.log(_this.totalresult)
      });
    },
    find_datail(names) {
      this.$router.push({
        path: "/companydetails",
        query: { fullName: names, userID: this.userID },
      });

    },
    print(company) {
      console.log(company);
    },
  },
};
</script>

<template>
 <div class="container">
  <div class="searchblank"> 
    <el-row :gutter="50">
      <el-col :span="4">
        <el-button @click="returnback" type="primary" size="large">返回主界面</el-button>
      </el-col>
      <el-col class="searchinput" :span="16">
        <el-input v-model="fullName"></el-input>
      </el-col>
      <el-col class="searchbutton" :span="4">
        <el-button type="primary" @click="search" size="large"
          >搜索企业</el-button>
      </el-col>
    </el-row>
  <br>
    <el-row class="searchmark" :gutter="20">
      <el-col :span="6">
        <el-select
          clearable
          v-model="area"
          class="m-0"
          placeholder="地区"
          size="large"
          @change="search"
        >
          <el-option
            v-for="item in Areaoptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-col>

      <el-col :span="6">
          <el-select
            clearable
            v-model="totalAssets"
            class="m-2"
            placeholder="总资产"
            size="large"
            @change="search"
          >
            <el-option
              v-for="item in totalAssetsoptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
      </el-col>
      <el-col :span="6">
        <el-select
          clearable
          v-model="pureProfit"
          class="m-3"
          placeholder="净利润"
          size="large"
          @change="search"
        >
          <el-option
            v-for="item in pureProfitsoptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-col>
      <el-col :span="6">
        <el-select
          clearable
          v-model="industryClassfication"
          class="m-4"
          placeholder="行业分类"
          size="large"
          @change="search"
        >
          <el-option
            v-for="item in industryClassficationsoptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-col>
    </el-row>
  </div>

  <div class="show">
  <el-table :data="companylist"  border stripe>
    <el-table-column type="index"></el-table-column>
    <el-table-column label="公司全称" prop="fullName"></el-table-column>
    <el-table-column label="股票代码" prop="stockNumber"></el-table-column>
    <el-table-column label="注册日期" prop="listingDate"></el-table-column>
    <el-table-column label="详情">
      <template v-slot="scope">
        <el-button type="primary" round @click="find_datail(scope.row.fullName)"
          >查看详情</el-button
        >
      </template>
    </el-table-column>
  </el-table>
  
  </div>
  <div class="pagination">
    <!-- <el-switch v-model="pageshow" /> -->
    <hr class="my-4" />
    <el-pagination
      v-model:current-page="current_page"
      v-model:page-size="page_size"
      :total="totalresult"
      layout="prev, pager, next,jumper"
      @current-change="search"
    />
  </div>
</div>
</template>

<style scoped>
.container{
  height: 100%;
  width:100%;
 background-color: aliceblue;
}
.searchinput {
  height: 40px;
}


.searchblank{
  padding: 10px;
}
.show{
  padding: 10px;
}
.pagination{
  padding: 10px 0 0;
}
</style>

<script setup>
import { ref } from "vue";

const value = ref("");
const pageshow = ref(false);
const Areaoptions = [
  {
    value: "重庆",
    label: "重庆",
  },
  {
    value: "上海",
    label: "上海",
  },
  {
    value: "北京",
    label: "北京",
  },
  {
    value: "江苏",
    label: "江苏",
  },
];

const totalAssetsoptions = [
  {
    value: "1亿以下",
    label: "1亿以下",
  },
  {
    value: "1到3亿",
    label: "1到3亿",
  },
  {
    value: "3到5亿",
    label: "3到5亿",
  },
  {
    value: "5到7亿",
    label: "5到7亿",
  },
  {
    value: "7到10亿",
    label: "7到10亿",
  },
  {
    value: "10亿以上",
    label: "10亿以上",
  },
];
const pureProfitsoptions = [
  {
    value: "1亿以下",
    label: "1亿以下",
  },
  {
    value: "1到3亿",
    label: "1到3亿",
  },
  {
    value: "3到5亿",
    label: "3到5亿",
  },
  {
    value: "5到7亿",
    label: "5到7亿",
  },
  {
    value: "7到10亿",
    label: "7到10亿",
  },
  {
    value: "10亿以上",
    label: "10亿以上",
  },
];
const industryClassficationsoptions = [
  {
    value: "软件和信息技术服务业",
    label: "软件和信息技术服务业",
  },
  
  {
    value: "专用设备制造业",
    label: "专用设备制造业",
  },
  {
    value: "化学原料和化学制品制造业",
    label: "化学原料和化学制品制造业",
  },
  {
    value: "资本市场服务",
    label: "资本市场服务",
  },
  {
    value: "计算机、通信和其他电子设备制造业",
    label: "计算机、通信和其他电子设备制造业",
  },
  {
    value: "其它金融业",
    label: "其它金融业",
  },
  {
    value: "电器机械和器材制造业",
    label: "电器机械和器材制造业",
  },
  {
    value: "通用设备制造",
    label: "通用设备制造",
  },
];
</script>


