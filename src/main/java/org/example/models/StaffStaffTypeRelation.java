package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff_staff_type")
public class StaffStaffTypeRelation extends BaseEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable=false)
    private Staff staff;

    @ManyToOne(optional = false)
    @JoinColumn(name = "staff_type_id", referencedColumnName = "id", nullable=false)
    private StaffType staffType;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }
}
