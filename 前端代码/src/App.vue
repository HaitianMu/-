<script setup>
import { RouterLink, RouterView } from 'vue-router';
import Header from "/src/components/mainpage/Header.vue";
import Aside1 from "/src/components/mainpage/Aside1.vue";

</script>

<template>
  
  <div class="app-container">

    <div><Header /></div>

  <el-divider class="divider1" ></el-divider>

  <div class="box">  
     <div  class="Navigation"><Aside1/></div>  
     <el-divider class="divide2" direction="vertical" ></el-divider>


     <RouterView/>
</div>

    </div>

</template>

<style scoped>
.divider1{
  height: 1px;
  border-top: 0;
  margin: 0 0 0;
  padding: 0;
  border-style:"inset";
  background-color: #141414
}
.divide2{
  margin: 0 0 0 ;
  width: 1px;
  height: 100%;
  min-height: 88.5vh; /* 最小高度，确保内容撑开整个页面 */
}
.appstyle{
  width: 100%;
}
.app-container {
  width: 100%;
  background-image: linear-gradient(
    0deg,
    #7083b3,
    #0082c8,
    #7689b9
  ); /*背景颜色*/
  min-height: 100vh; /* 最小高度，确保内容撑开整个页面 */
  display: flex;
  flex-direction: column;
}

/* 侧边栏和主要内容区域样式 */
.box {
  height: 100%;
  display: flex;
  justify-content: space-around; /* 将子元素平均分配空间 */
  align-items: center; /* 在竖直方向上均分子元素 */
  align-items: flex-start; /* 顶部对齐 */
  background-color: rgb(174, 212, 245);
}

.Navigation{
width: 8%;
height: 100%;
}
</style>
