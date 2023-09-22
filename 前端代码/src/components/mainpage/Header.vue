<template>
 
    <div class="headbox">
  

    <el-divider direction="vertical"  />
      <h1>企业大数据征信系统</h1>
  </div>
</template>


<script lang="ts">
</script>

<style scoped>
.headbox {
  height: 100%;
  display: flex;
  justify-content: space-around; /* 将子元素平均分配空间 */
  align-items: center; /* 在竖直方向上均分子元素 */
  align-items: flex-start; /* 顶部对齐 */
  background-color: rgb(174, 212, 245);
  padding: 15px 10px ;
}
h1 {
  flex: 1; /* 让标题元素占据剩余的空间 */
  text-align: center;
  font-size: 40px;
  color: #626aef;
  letter-spacing: 5px; /* 增大字间距的值可以根据需要进行调整 */
}

.img {
  width: 8%;
  object-fit: contain;
}

</style>