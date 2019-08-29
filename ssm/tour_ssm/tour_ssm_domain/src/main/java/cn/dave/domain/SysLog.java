package cn.dave.domain;

import cn.dave.utils.DateUtils;

import java.util.Date;

/**
 * @program: tour_ssm
 * @description:
 * @author: dave
 * @create: 2019-08-06 16:11
 **/

public class SysLog {
     private String id;
     private Date visitTime;
    private String visitTimeStr;
     private String username;
     private String ip;
     private String url;
     private Long executionTime;
     private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitTimeStr() {
        if (visitTime != null){
            visitTimeStr = DateUtils.date2String(visitTime,"yyyy-MM-dd HH:mm:ss");
        }
        return visitTimeStr;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
