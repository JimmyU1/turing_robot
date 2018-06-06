package com.lkk.turing.robot.controller;

import com.lkk.turing.robot.model.TalkResponse;
import com.lkk.turing.robot.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "robot")
public class RobotController {

    @Autowired
    protected TalkService talkService;

    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "talk", method = RequestMethod.GET,  produces="application/json")
    @ResponseBody
    public TalkResponse talk(String info){
        return talkService.getResponse(info);
    }
}
