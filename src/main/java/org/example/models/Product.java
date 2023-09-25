package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToOne()
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToOne(optional = false)
    @JoinColumn(name = "consignment_note_id", referencedColumnName = "id")
    private ConsignmentNote consignmentNote;

    @OneToOne()
    @Cascade(org.hibernate.annotations.CascadeType.REFRESH)
    @JoinColumn(name = "sales_history_id", referencedColumnName = "id")
    private SalesHistory salesHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public ConsignmentNote getConsignmentNote() {
        return consignmentNote;
    }

    public void setConsignmentNote(ConsignmentNote consignmentNote) {
        this.consignmentNote = consignmentNote;
    }

    public SalesHistory getSalesHistory() {
        return salesHistory;
    }

    public void setSalesHistory(SalesHistory salesHistory) {
        this.salesHistory = salesHistory;
    }
}
