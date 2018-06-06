package com.lkk.turing.robot.model;

import java.io.Serializable;

public class TalkResponse implements Serializable {
    private Integer code;
    private String text;
    private String host;

    public TalkResponse() {
    }

    public TalkResponse(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "TalkResponse{" +
                "code=" + code +
                ", text='" + text + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
