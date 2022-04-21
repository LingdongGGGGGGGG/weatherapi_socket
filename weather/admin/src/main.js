/*
 * @Author: your name
 * @Date: 2022-04-20 23:38:18
 * @LastEditTime: 2022-04-20 23:57:41
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: \前后交互\weather\admin\src\main.js
 */
// main.ts
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'

const app = createApp(App)

app.use(ElementPlus)
app.mount('#app')