package com.lqx.pojo;

public class ContainerShip {
    private Integer id;

    private String type;

    private Integer capacity;

    private String shipType;

    private String shipNo;

    public ContainerShip() {
    }


    public ContainerShip(Container container) {
        this.id = container.getId();
        this.type = container.getType();
        this.capacity = container.getCapacity();
        this.shipType = container.getShipType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType == null ? null : shipType.trim();
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo == null ? null : shipNo.trim();
    }
}