package org.example.models;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "consignment_note")
public class ConsignmentNote extends BaseEntity{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "consignmentNote")
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    private Set<Product> products;

    @OneToOne()
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private  Staff staff;

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
