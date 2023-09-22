<template>
    <div class="register-container">
      <el-form class="register-form" :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="userName" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="password" type="password" />
        </el-form-item>
        <el-form-item label="确认密码">
          <el-input v-model="surepassword" type="password" />
        </el-form-item>
        <el-form-item>
        
          <el-button type="primary" round @click="register">注册</el-button>
          <p @click="returnlogin" class="returnlogin">已有账号？点击进行登录</p>

          
        </el-form-item>
      </el-form>
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
        surepassword: "",
        form: {
          userName: "",
          password: "",
          surepassword: "",
        },
      };
    },


    methods: {
      returnlogin:function(){
    this.$router.push({
      path:"/user/login"
    })
      },
      register: function () {
        if (!this.userName || !this.password) {
          ElMessage('用户名或密码为空！');
          return;
        }
        if (this.password !== this.surepassword) {
          ElMessage('请确保两次输入的密码一致');
          return;
        }
        const username = this.userName;
        const password = this.password;
        const userinfo = {
          username: username,
          password: password,
        };
        user.register(userinfo)
          .then((response) => {
            console.log(response.data);
            if(response.data.isLogIn==true){
              ElMessage('注册成功')
              this.$router.push({
                path:'/',
                query: {userID: response.data.userID}
              })
            }
            else{
              ElMessage('注册失败')
            }
          })
      },
    },
  };
  </script>
  
  <style scoped>
  .register-container {
    width: 100%;
    background-image: linear-gradient(0deg, #7083b3, #0082c8,#7689b9 ); /*背景颜色*/
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.register-form {
  width: 400px;
  padding: 20px;
  background-color: aliceblue;
  border-radius: 5px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  margin: 0 auto; /* 水平居中 */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
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

.returnlogin {
  font-size: 5px;
  text-align: right; /* 靠右对齐 */
  color: blue; /* 将字体颜色设置为蓝色 */
  text-decoration: underline; /* 添加下划线 */
}

.returnlogin:hover {
  cursor: pointer; /* 改变鼠标指针样式 */
}

  </style>
  