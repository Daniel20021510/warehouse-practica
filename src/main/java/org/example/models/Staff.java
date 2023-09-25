package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff extends BaseEntity{

    @Column(name = "first_name", length = 255, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = false)
    private String lastName;

    @Column(name = "middle_name", length = 255, nullable = false)
    private String middleName;

    @OneToMany(mappedBy = "staff")
    private Set<StaffStaffTypeRelation> staffType;

    @OneToOne()
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    @JoinColumn(name = "sales_history_id", referencedColumnName = "id")
    private SalesHistory salesHistory;

    @OneToOne(mappedBy = "staff")
    private ConsignmentNote consignmentNote;

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

    public void setStaffType(Set<StaffStaffTypeRelation> staffStaffTypeRelationSet) {
        this.staffType = staffStaffTypeRelationSet;
    }

    public SalesHistory getSalesHistory() {
        return salesHistory;
    }

    public void setSalesHistory(SalesHistory salesHistory) {
        this.salesHistory = salesHistory;
    }

    public ConsignmentNote getConsignmentNote() {
        return consignmentNote;
    }

    public void setConsignmentNote(ConsignmentNote consignmentNote) {
        this.consignmentNote = consignmentNote;
    }
}
