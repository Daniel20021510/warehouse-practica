package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity{

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "min_count", nullable = false)
    private int minCount;

    @Column(name = "inv_number", length = 10, nullable = false)
    private String invNumber;

    @OneToOne(mappedBy = "warehouse")
    private  Product product;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }

    public String getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(String invNumber) {
        this.invNumber = invNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
