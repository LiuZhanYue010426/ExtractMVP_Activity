package com.example.exceptiopn;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class ServerException extends RuntimeException{
    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
