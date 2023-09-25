package org.example.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "staff_type")
public class StaffType extends BaseEntity{

    @Column(name = "staff_type_name", length = 20, nullable = false)
    private String staffTypeName;

    @OneToMany(mappedBy = "staffType")
    private Set<StaffStaffTypeRelation> staffStaffTypeRelation;

    public String getStaffTypeName() {
        return staffTypeName;
    }

    public void setStaffTypeName(String staffTypeName) {
        this.staffTypeName = staffTypeName;
    }

    public Set<StaffStaffTypeRelation> getStaffStaffTypeRelation() {
        return staffStaffTypeRelation;
    }

    public void setStaffStaffTypeRelation(Set<StaffStaffTypeRelation> staffStaffTypeRelationSet) {
        this.staffStaffTypeRelation = staffStaffTypeRelationSet;
    }
}
