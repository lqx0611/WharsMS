package com.lqx.pojo;

public class ShipRepository {
    private Integer id;
    private Integer size;
    private String containerType;
    private String shipNo;
    private Integer count;

    public ShipRepository() {
    }

    public ShipRepository(Ship ship) {
        this.size = ship.getCapacity();
        if(ship.getType().equals("小型货轮")){
            this.containerType = "小型货柜";
        }else if(ship.getType().equals("中型货轮")){
            this.containerType = "中型货柜";
        }else {
            this.containerType = "大型货柜";
        }
        this.shipNo = ship.getNo();
        this.count = ship.getCount();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType == null ? null : containerType.trim();
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo == null ? null : shipNo.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShipRepository{" +
                "id=" + id +
                ", size=" + size +
                ", containerType='" + containerType + '\'' +
                ", shipNo='" + shipNo + '\'' +
                ", count=" + count +
                '}';
    }
}