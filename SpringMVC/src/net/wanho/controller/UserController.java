package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("/testresp")

    @ResponseBody

    public String testResp(){
        return "hello";
    }

}
