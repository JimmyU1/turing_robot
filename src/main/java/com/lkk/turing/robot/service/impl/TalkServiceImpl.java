package com.lkk.turing.robot.service.impl;

import com.alibaba.fastjson.JSON;
import com.lkk.turing.robot.model.TalkResponse;
import com.lkk.turing.robot.service.TalkService;
import com.lkk.turing.robot.util.HttpUtil;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Service
public class TalkServiceImpl implements TalkService {
    public static String TURING_URL = "http://www.tuling123.com/openapi/api";
    public static String TURING_KEY = "d9e75bf8208345b987c42c5cc972c7d0";

    @Override
    public TalkResponse getResponse(String content) {
        Map<String, String> body = new HashMap<>();
        body.put("key", TURING_KEY);
        body.put("info", content);
        String resultJson = HttpUtil.doPost(TURING_URL, body);
        TalkResponse response = JSON.parseObject(resultJson, TalkResponse.class);

        String host = "";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        response.setHost(host);
        return response;
    }
}
