package com.littlepage.airplaneticketsystem.aspect;

import lombok.Data;
/**
 * Encapsulate the RequestLog
 *
 *
 *
 *
 * url & ip: the request url & ip from front end
 * classMethod: the invoked class methods
 * args: the args from front end
 */
@Data
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }
}
