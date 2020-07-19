package com.lqx.pojo;

import java.util.Date;

public class BerthTime {
    private Integer id;
    private String startTime;
    private String endTime;

    public BerthTime(ShipInfo shipInfo) {
        this.startTime = shipInfo.getStartTime();
        this.endTime = shipInfo.getEndTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BerthTime{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}