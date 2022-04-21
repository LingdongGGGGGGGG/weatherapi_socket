<!--
 * @Author: your name
 * @Date: 2022-04-20 23:38:18
 * @LastEditTime: 2022-04-21 01:25:10
 * @LastEditors: DESKTOP-TE06U1V
 * @Description: In User Settings Edit
 * @FilePath: \前后交互\weather\admin\src\App.vue
-->


<template>
<div id="container">
<!-- 点击请求api -->
<el-button color="#626aef" :dark="isDark" @click="getWeather()" size="large" style="margin:0 auto">获取天气</el-button>
<!-- 表格 -->
<div style="margin:0 80px;">
  <el-table :data="tableData" border style="width: auto;padding:0;">
    <el-table-column prop="ymd" label="日期" width="180" />
    <el-table-column prop="week" label="星期" width="160" />
    <el-table-column prop="high" label="最高气温" width="160" />
    <el-table-column prop="low" label="最低气温" width="160" />
    <el-table-column prop="type" label="天气" width="120" />
    <el-table-column prop="sunrise" label="日出时间" width="120"/>
    <el-table-column prop="sunset" label="日落时间" width="120" />
  <el-table-column prop="aqi" label="空气质量指数" width="120"/>
  <el-table-column prop="fx" label="风向" width="120"/>
  <el-table-column prop="fl" label="风力" width="120"/>
  </el-table>
  </div>
  <!-- 加载 -->
  <div class="loader" v-if="load"></div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "App",
  data() {
    return {
      tableData: [],
      load:false
    };
  },
  methods: {
    getWeather(){
      this.load=true;
      let self = this;
       axios.get('http://localhost:8014/test').then(res=>{
          console.log(res);
           var i=res.data.indexOf("forecast");
          var i1=res.data.indexOf("yesterday");
          self.tableData =  res.data.slice(i+10,i1-2);
          self.tableData  =  eval('(' + self.tableData + ')');
          self.load=false;
          })
    }
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.el-table-column{
position: relative;
left: -10px;
}
#container{
width: 100vw;
height: 100vh;
}
.loader {
  position: relative;

  width: 2.5em;

  height: 2.5em;

  transform: rotate(165deg);

}

.loader:before, .loader:after {
  content: '';

  position: absolute;

  top: 50%;

  left: 50%;

  display: block;

  width: 0.5em;

  height: 0.5em;

  border-radius: 0.25em;

  transform: translate(-50%, -50%);

}

.loader:before {
  animation: before 2s infinite;

}

.loader:after {
  animation: after 2s infinite;

}



@keyframes before {
  0% {
    width: 0.5em;

    box-shadow: 1em -0.5em rgba(225, 20, 98, 0.75), -1em 0.5em rgba(111, 202, 220, 0.75);

  }

  35% {
    width: 2.5em;

    box-shadow: 0 -0.5em rgba(225, 20, 98, 0.75), 0 0.5em rgba(111, 202, 220, 0.75);

  }

  70% {
    width: 0.5em;

    box-shadow: -1em -0.5em rgba(225, 20, 98, 0.75), 1em 0.5em rgba(111, 202, 220, 0.75);

  }

  100% {
    box-shadow: 1em -0.5em rgba(225, 20, 98, 0.75), -1em 0.5em rgba(111, 202, 220, 0.75);

  }

}

@keyframes after {
  0% {
    height: 0.5em;

    box-shadow: 0.5em 1em rgba(61, 184, 143, 0.75), -0.5em -1em rgba(233, 169, 32, 0.75);

  }

  35% {
    height: 2.5em;

    box-shadow: 0.5em 0 rgba(61, 184, 143, 0.75), -0.5em 0 rgba(233, 169, 32, 0.75);

  }

  70% {
    height: 0.5em;

    box-shadow: 0.5em -1em rgba(61, 184, 143, 0.75), -0.5em 1em rgba(233, 169, 32, 0.75);

  }

  100% {
    box-shadow: 0.5em 1em rgba(61, 184, 143, 0.75), -0.5em -1em rgba(233, 169, 32, 0.75);

  }

}

/**

 * Attempt to center the whole thing!

 */

html,

body {
  height: 100%;

}



.loader {
  position: absolute;

  top: calc(50% - 1.25em);

  left: calc(50% - 1.25em);

}
</style>

