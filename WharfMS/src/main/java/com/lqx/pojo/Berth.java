package com.lqx.pojo;

public class Berth {
    private Integer id;

    private String berthNo;

    private Integer size;

    private String dayRate;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(String berthNo) {
        this.berthNo = berthNo == null ? null : berthNo.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDayRate() {
        return dayRate;
    }

    public void setDayRate(String dayRate) {
        this.dayRate = dayRate == null ? null : dayRate.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}