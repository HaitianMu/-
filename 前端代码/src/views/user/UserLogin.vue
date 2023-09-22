<template>
  <div class="mybackground">
    <div class="login-container">
      <el-form class="login-form" :model="form" label-width="60px">
        <el-form-item label="用户名">
          <el-input v-model="userName" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="password" type="password" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" round @click="login">登录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primaty" round @click="register">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
    
  </template>
  
  <script>
  import user from "../../utils/user.js";
  import { ElMessage } from "element-plus";
  
  export default {
    data() {
      return {
        userName: "",
        password: "",
        form: {
          userName: "",
          password: "",
        },
      };
    },
    methods: {
      login: function () {
        if (!this.userName || !this.password) {
          ElMessage('用户名或密码为空！');
          return;
        }
        const username = this.userName;
        const password = this.password;
        const userinfo = {
          username: username,
          password: password,
        };
        user.login(userinfo)
          .then((response) => {
            console.log(response.data);
            if(response.data.isLogIn==true){
              ElMessage('登录成功')
              this.$router.push({
                path:'/',
                query: {userID: response.data.userID}
              })
            }
            else{
              ElMessage('登录失败')
            }
          })
          .catch(error=>{
            ElMessage('登录失败')
            console.log(error)
          })
           
      },
      register: function () {
        this.$router.push({ path: '/user/register' });
      },
    },
  };
  </script>
  
  <style scoped>
  .mybackground {
    width: 100%;
    background-image: linear-gradient(0deg, #7083b3, #0082c8,#7689b9 ); /*背景颜色*/
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center; 
}

.login-container {
  width: 400px;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: aliceblue;
  border-radius: 5px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  padding: 20px;
  
}

.login-form {
  width: 100%;
}

.el-form-item {
  margin-bottom: 20px;
}

.el-button {
  width: 100%;
  background-color: #4a90e2; /* 设置按钮背景颜色 */
  color: #fff; /* 设置按钮文字颜色 */
  border: none; /* 移除按钮边框 */
  border-radius: 5px; /* 圆角按钮 */
  transition: background-color 0.3s; /* 添加过渡效果 */
}

.el-button:hover {
  background-color: #357ebd; /* 鼠标悬停时的背景颜色 */
}
  </style>