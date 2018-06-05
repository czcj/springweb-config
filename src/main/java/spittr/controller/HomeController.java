package spittr.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spittr.pojo.Spittle;
import spittr.service.SpittrService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SpittrService spittrService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/home2",method = RequestMethod.GET)
    public String home2(){
        return "redirect:/home3";
    }
    @RequestMapping(value = "/home3",method = RequestMethod.GET)
    public String home3(){
        return "home3";
    }
    @RequestMapping(value = "/home1",method = RequestMethod.GET)
    public String home1(){
        return "redirect:/home2";
    }
    @RequestMapping(value = "/getSpittles" ,method = RequestMethod.GET)
    @ResponseBody
    public String getSpittles(){
        List<Spittle> spittles = spittrService.getSpittles();
        return JSON.toJSONString(spittles);
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String toRegister(){
        spittrService.test();
        return "register";
    }
}
