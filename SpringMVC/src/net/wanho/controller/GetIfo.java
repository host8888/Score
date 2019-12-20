package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GetIfo{
    @RequestMapping("/data")
    @ResponseBody
    public String  Data(@RequestParam("user") String name){
        System.out.println(name);
        return name;
    }
}
