package org.example.DTOs;

import org.example.models.StaffStaffTypeRelation;

import java.util.Set;

public class StaffDTO {

    private String firstName;

    private String lastName;

    private String middleName;

    private Set<StaffStaffTypeRelation> staffType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Set<StaffStaffTypeRelation> getStaffType() {
        return staffType;
    }

    public void setStaffType(Set<StaffStaffTypeRelation> staffType) {
        this.staffType = staffType;
    }
}
