package com.lqx.pojo;

import java.util.Date;

public class ShipInfo {
    private Integer id;
    private String no;
    private String type;
    private String name;
    private String captain;
    private String company;
    private Integer capacity;
    private Integer count;
    private String berthNo;
    private String shipStatus;
    private String startTime;
    private String endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain == null ? null : captain.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(String berthNo) {
        this.berthNo = berthNo == null ? null : berthNo.trim();
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus == null ? null : shipStatus.trim();
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
        return "ShipInfo{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", captain='" + captain + '\'' +
                ", company='" + company + '\'' +
                ", capacity=" + capacity +
                ", count=" + count +
                ", berthNo='" + berthNo + '\'' +
                ", shipStatus='" + shipStatus + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}