
/**导航组件 */

<template>
    <div class="aside" style="height: 100%; width: 100%;">
      <el-row class="tac" style="height: 100%; width: 100%;">
       
          <el-menu 
            default-active="this.$route.path" router
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
           
            background-color="rgb(174, 212, 245)"
            text-color="#626aef"
            active-text-color="#141414"
            style="height: 100%; width: 100%;">
            <el-menu-item class='el-menu-item' @click="mainp">
              <i class="el-icon-home"></i>
              <span slot="title">主页</span>
            </el-menu-item>
            <el-divider class="nadiv" />

            <el-menu-item  class='el-menu-item' @click="searchView">
              <i class="el-icon-menu"></i>
              <span slot="title">企业查询</span>
            </el-menu-item>
            <el-divider class="nadiv" />

            <el-menu-item class='el-menu-item'  @click="overviewNational">
              <i class="el-icon-document"></i>
              <span slot="title">全国概览</span>
            </el-menu-item>
             <el-divider class="nadiv" />

            <el-menu-item class='el-menu-item'  @click="overviewRegion">
              <i class="el-icon-setting"></i>
              <span slot="title">地区概览</span>
            </el-menu-item>
            <el-divider class="nadiv" />
            
          </el-menu>
      
      </el-row>
    </div>
  </template>
  
  <script>
  
  export default {
      methods: {
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },
        mainp(){
          this.$router.push({
            path:'/',
            query:{userID:this.$route.query.userID}
          })
        },
        overviewRegion(){
          this.$router.push({
            path:'/overview/region',
            query:{userID:this.$route.query.userID}
          })
        },
        overviewNational(){
          this.$router.push({
            path:'/overview/national',
            query:{userID:this.$route.query.userID}
          })
        },
        searchView(){
          this.$router.push({
            path:'/searchresult',
            query:{userID:this.$route.query.userID}
          })
        },
      }
    }
  </script>
  
  <style>
  .el-menu-item {
    border-radius: 5px;
    padding: 10px 20px;
    font-weight: bold;

}

.nadiv{
  margin: 1px 0 0;
  border-top: 0;
  background-color:#141414;
}
</style>