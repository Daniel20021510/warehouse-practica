package org.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "sales_history")
public class SalesHistory extends BaseEntity{

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @OneToOne(mappedBy = "salesHistory")
    private Product product;

    @OneToOne(mappedBy = "salesHistory")
    private Staff staff;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
