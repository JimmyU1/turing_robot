package com.lkk.turing.robot.service;

import com.lkk.turing.robot.model.TalkResponse;

public interface TalkService {
    TalkResponse getResponse(String content);
}
