package com.lqx.pojo;

public class Ship {
    private Integer id;
    private String no;
    private String type;
    private String name;
    private String captain;
    private String company;
    private Integer capacity;
    private Integer count;
    private Integer status;
    private String berthNo;
    private Integer timeId;

    public Ship() {
    }

    public Ship(ShipInfo shipInfo){
        this.id = shipInfo.getId();
        this.no = shipInfo.getNo();
        this.type = shipInfo.getType();
        this.name = shipInfo.getName();
        this.captain = shipInfo.getCaptain();
        this.company = shipInfo.getCompany();
        this.capacity = shipInfo.getCapacity();
        this.count = shipInfo.getCount();
        if(shipInfo.getShipStatus().equals("1")){
            this.status = 1;
        }else {
            this.status = 0;
        }
        this.berthNo = shipInfo.getBerthNo();
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(String berthNo) {
        this.berthNo = berthNo == null ? null : berthNo.trim();
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", captain='" + captain + '\'' +
                ", company='" + company + '\'' +
                ", capacity=" + capacity +
                ", count=" + count +
                ", status=" + status +
                ", berthNo='" + berthNo + '\'' +
                ", timeId=" + timeId +
                '}';
    }
}