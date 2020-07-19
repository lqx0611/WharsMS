package com.lqx.pojo;

public class Container {
    private Integer id;
    private String type;
    private Integer capacity;
    private String shipType;
    private Integer repository;

    public Container() {
    }

    public Container(ContainerShip shipContainer) {
        this.id = shipContainer.getId();
        this.type =shipContainer.getType();
        this.capacity = shipContainer.getCapacity();
        this.shipType = shipContainer.getShipType();
        //this.repository = repository;
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

    public Integer getRepository() {
        return repository;
    }

    public void setRepository(Integer repository) {
        this.repository = repository;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", shipType='" + shipType + '\'' +
                ", repository=" + repository +
                '}';
    }
}