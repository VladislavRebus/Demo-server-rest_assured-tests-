package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyControllers {

    @GetMapping(value = "age",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String getAge(@RequestParam (name = "d",required = false,defaultValue = "123") String d){
        return "{\"age\":"+d+"}";
    }

    @GetMapping(value = "name",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String getName(@RequestParam (name = "n",required = false,defaultValue = "vasya") String d){
       if(d.contains("oleg")){
           return "{\"name\":\"super "+d+"\"}";
       }
          return "{\"name\":\""+d+"\"}";
    }

    @PostMapping(value = "child",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getChild(@RequestParam (name = "c",required = false) String c){
        if(c != null && !c.isEmpty()){
            return "{\"child\": { \"boys\":\""+c+"\"}}";
        }
        return "{\"child\": { \"girls\":4}}";
    }

}
