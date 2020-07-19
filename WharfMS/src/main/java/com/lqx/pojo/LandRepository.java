package com.lqx.pojo;

public class LandRepository {
    private Integer id;

    private String name;

    private Integer size;

    private String containerType;

    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LandRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", containerType='" + containerType + '\'' +
                ", count=" + count +
                '}';
    }
}