<template>
 
    <div class ='maincontainer'>
      <Aside :userid="userid" />
      <Main />
</div>

<div class ='button'>
<div v-if="isUserLoggedIn">
      <p>已登录</p>
      <el-button color="#626aef" @click="logout">退出登录</el-button>
    </div>
    <!-- 如果用户未登录，显示登录和注册按钮 -->
    <div v-else>
      <el-button color="#626aef" @click="login">登录</el-button>
      <el-button color="#626aef" @click="register">注册</el-button>
    </div> 
    </div>

</template>


<script setup>
import Main from "../components/mainpage/Main.vue";
import Aside from "../components/mainpage/Aside.vue";
</script>


<style>
/* 根容器样式，用于设置背景或全局样式 */
.app-container {
  width: 100%;
  background-image: linear-gradient(
    0deg,
    #7083b3,
    #0082c8,
    #7689b9
  ); /*背景颜色*/
  min-height: 90vh; /* 最小高度，确保内容撑开整个页面 */
  display: flex;
  flex-direction: column;
}

/* 侧边栏和主要内容区域样式 */
.maincontainer{
  padding: 10px;
  min-height: 88.5vh; /* 最小高度，确保内容撑开整个页面 */
  height: 100%;
  width:100%;
  display: flex;
  justify-content: space-around; /* 将子元素平均分配空间 */
  align-items: center; /* 在竖直方向上均分子元素 */
  align-items: flex-start; /* 顶部对齐 */
  background-color: aliceblue;
}
.button{
  position: absolute;
  top: 2%;
  right: 5%;
}

</style>

<script>
export default {
  methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      logout() {
      this.isUserLoggedIn = false;
      this.$router.push({
        path:"/"
      })
    },
    login() {
      this.$router.push({
        path: "/user/login",
        
      });
    },
    register() {
      this.$router.push({
        path: "/user/register",
      });
    },


    },
  data() {
    return {
      userid: String,
      isUserLoggedIn: false,
    };
  },
  mounted() {
    this.userid = this.$route.query.userID;

    console.log(this.$route.query.userID)
    if (this.$route.query.userID == null) {
      this.isUserLoggedIn = false;
    } else {
      this.isUserLoggedIn = true;
    }
  },
};
</script>
