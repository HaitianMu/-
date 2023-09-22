<template>
    <div class="side">
    <p class="asideword">企业筛选</p>
      <el-select
          clearable
          v-model="area"
          class="m-1"
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
      <el-select
            clearable
            v-model="totalAssets"
            class="m-1"
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
      <el-select
          clearable
          v-model="pureProfit"
          class="m-1"
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
       <el-select
          clearable
          v-model="industryClassfication"
          class="m-1"
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
    </div>
</template>


<script lang="ts" setup>
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

 
<script lang="ts">
import { ElMessage } from 'element-plus';
export default{
    props:{
      userid: String
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
    };
  },
  methods: {
    search: function () {
      if(this.userid==null){
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
          query: { userID:this.userid,fullName: fullName, area:area,registeredAssets:registeredAssets,totalAssets:totalAssets,pureProfit:pureProfit,industryClassfication:industryClassfication }
      })

    },
    overview(){
      if(this.$route.query.userID==null){
        ElMessage("请先登录")
        return
      }
      this.$router.push({
        path:'/overview/national',
        query: {userid:this.userid}
      })
    }
  },
}
</script>




 <style scoped>
.asideword {
  /* 设置水平居中 */
  text-align: center;
  
  /* 设置上下间距 */
  padding: 20px 10px; /* 上下间距为20px，左右间距为10px */

  /* 设置字间距 */
  letter-spacing: 2px; /* 2px的字间距，你可以根据需要进行调整 */
}

  .side {
  margin-top: 73px;
  margin-left: 30px;/* 让容器靠右 */
  margin-right: 0px;
  display: flex;
  flex-direction: column;
  justify-content: start;
  width: 200px; /* 增加容器宽度 */
  height: auto; /* 自适应高度 */
  border-radius: 5px; /* 圆角边框 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */

  
}


.side button {
    margin: 30px;
  margin-bottom: 30px; /* 减小按钮之间的间距 */
  padding: 50px 20px; /* 增加按钮内边距 */
  background-color: #626aef; /* 设置按钮背景颜色 */
  color: #fff; /* 设置按钮文字颜色 */
  border: none; /* 移除按钮边框 */
  border-radius: 3px; /* 圆角按钮 */
  cursor: pointer; /* 鼠标指针样式 */
  transition: background-color 0.3s; /* 添加过渡效果 */
}

.side button:hover {
  background-color: #4444cc; /* 鼠标悬停时的背景颜色 */
}

.m-1{
  margin: 30px ;
}
  </style>
