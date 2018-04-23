package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HsY
 * @create 2018-04-23 15:33
 * @desc 页面展示controller
 **/
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){

        return "index";
    }

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){

        return page;
    }

}
