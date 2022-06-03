package com.example.metabus.persistence.domain;

public class FacilityGroup {

    private int privateId;
    private  int parentId;
    private String categoryName;

    public FacilityGroup() {

    }

    public FacilityGroup(int privateId, int parentId, String categoryName) {
        this.privateId = privateId;
        this.parentId = parentId;
        this.categoryName = categoryName;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
