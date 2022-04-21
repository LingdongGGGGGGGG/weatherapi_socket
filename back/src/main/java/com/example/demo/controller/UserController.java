package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;

/*
控制器类
spring一般用于前后端分离开发，所以在springboot中一般都是直接返回字符串了
 */
@RestController //@RestController=@Controller+@ResponseBody

public class UserController {
    @RequestMapping("test")
    @CrossOrigin
public String test1(){
        String a1="";
        try {
            //Https请求用SSLSocketFactory，如果是Http使用Socket
            Socket socket = null;
            try {
//                socket = SSLSocketFactory.getDefault().createSocket("t.weather.sojson.com",80);//https
                socket = new Socket("t.weather.sojson.com", 80);//http
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //注意\r\n代表换行
            bw.write("GET /api/weather/city/101030100 HTTP/1.1\r\n");
            //这里第二个\r\n代表空行，空行是http协议里要求的，不能省略
            bw.write("Host: t.weather.sojson.com\r\n\r\n");
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String readLine = null;
                if ((readLine = br.readLine()) != null) {
                    System.out.println(readLine);
                    a1+=readLine;
                } else {
                    break;
                }
                System.out.println(a1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(a1);
        return a1;
    }
}
