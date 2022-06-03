package com.example.metabus.persistence.domain;

public class GroupOfFacility {

    private int groupId;
    private Facility facilityId;

    public GroupOfFacility() {

    }

    public GroupOfFacility(int groupId, Facility facilityId) {
        this.groupId = groupId;
        this.facilityId = facilityId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

}
