<template>
  <div class="detailcontainer">


<div class="page_heading">
    <el-row  :gutter="50">
      <el-col :span="12">
        <el-button type="primary" round size="large" @click="back_to_main">返回主界面</el-button>
      </el-col>
      



      <el-col class="carelist" :span="4">
      </el-col>
    </el-row>
    <el-divider/>

<div class="Exe">
    <p >公司高管</p>
</div>

    <el-table :data="leaderlist" class="show" border stripe>


        <el-table-column label="姓名" prop="personName"></el-table-column>
        <el-table-column label="职位" prop="position"></el-table-column>
    </el-table>
    <br>
    <pie-chart v-bind="holderlist" v-if="flagHolder"/>
    <!-- <bar-chart v-bind="testbar" v-if="flagHolder"/> -->
    <br>

    <div class="Exe">
    <p >基本信息</p>
    </div>
    <el-descriptions
   
    direction="vertical"
    :column="4"
    :size="size"
    border
  >
    <el-descriptions-item label="属地">{{info.area}}</el-descriptions-item>
    <el-descriptions-item label="简称">{{info.briefName}}</el-descriptions-item>
    <el-descriptions-item label="法人代表">{{info.legalRepresentative}}</el-descriptions-item>
    <el-descriptions-item label="挂牌日期">{{info.listingDate}}</el-descriptions-item>
    <el-descriptions-item label="全称" :span="2">{{info.fullName}}</el-descriptions-item>
    <el-descriptions-item label="行业" :span="2">{{info.industryClassification}}</el-descriptions-item>
    <el-descriptions-item label="股票代码"> {{info.stockNumber}}</el-descriptions-item>
    <el-descriptions-item label="总资产">{{info.totalAssets}}元</el-descriptions-item>
    <el-descriptions-item label="总负债">{{info.totalDebt}}元</el-descriptions-item>
    <el-descriptions-item label="挂牌日期">{{info.listingDate}}</el-descriptions-item>
    <el-descriptions-item label="每股利润">{{info.profitPerShare}}元</el-descriptions-item>
    <el-descriptions-item label="主营产品">{{info.mainProduct}}</el-descriptions-item>
    <el-descriptions-item label="未分配利润">{{info.undistributedProfit}}元</el-descriptions-item>
    <el-descriptions-item label="营业利润">{{info.businessProfit}}元</el-descriptions-item>

  </el-descriptions>
</div> 
</div>
  

</template>

<script>
import PieChart from '../../components/echarts/PieChart.vue'
import company from '../../utils/company'
import BarChart from '../../components/echarts/BarChart.vue'
export default {
    data(){
        return{
            fullName: "",
            userID:"",
            info:Object,
            leaderlist:[],
            flagHolder:false,
            holderlist:{
              ID:"股东列表",
              rosetype: '',
              //height:'',
              data:[{name:'hqx',value:10},{name:'son of hqx',value:5},{name:'others',value:85}],
              title:"股东列表"
            },
            testbar:{
              xAxisdata:[],
              ydata:[]
            }
        }
    },
    created(){
        this.fullName=this.$route.query.fullName
        this.userID=this.$route.query.userID
        this.details()
    },
    components:{
      PieChart,
      BarChart,
    },
    methods:{
        back_to_main(){
          this.$router.push({
            path:'/',
            query:{userID:this.userID}
          })
        },
        details(){
            console.log(this.fullName)
            var that=this
            //console.log(this.$route.fullName)
            const fullName=this.fullName
            const UserID=this.UserID
            const query={             /*发送请求 */
                fullName:fullName,
                UserId:UserID,
            }
            company.searchDetails(query).then(response=>{
              console.log(response.data)
              this.info=response.data.companyBaseInfo    /*将响应值复制到info，并进行渲染 */
            })
            company.searchHolder(query).then(response=>{
              console.log(response.data)
              that.holderlist.dataset=response.data
              this.flagHolder=!this.flagHolder
            })
            company.searchCompanyAdminister(query).then(response=>{
              console.log(response.data)
              that.leaderlist=response.data
            })
    }
    }
}
</script>

<style>
.detailcontainer{
  height: 100%;
width:100%;
  display: flex;
  justify-content: space-around; /* 将子元素平均分配空间 */
  align-items: center; /* 在竖直方向上均分子元素 */
  align-items: flex-start; /* 顶部对齐 */
  background-color: aliceblue;
  border-radius: 5px; /* 圆角边框 */
}
.page_heading{
  padding: 10px;
  background-color: aliceblue;
  height: 100%;
width:100%;
}
.Exe{
  letter-spacing: 10px; /* 调整字间距的值 */
 font-size: 20px;
  display: flex;
  justify-content: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3); /* 添加阴影效果 */
}

.show{
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3); /* 添加阴影效果 */
}

</style>