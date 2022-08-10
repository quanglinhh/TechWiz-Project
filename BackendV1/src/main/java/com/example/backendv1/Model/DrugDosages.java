package com.example.backendv1.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "drug_dosages", schema = "dbo", catalog = "healthmanage")
public class DrugDosages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "customer_id")
    private long customerId;
    @Basic
    @Column(name = "medicine_id")
    private int medicineId;
    @Basic
    @Column(name = "time_per_day")
    private String timePerDay;
    @Basic
    @Column(name = "time_per_week")
    private String timePerWeek;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getTimePerDay() {
        return timePerDay;
    }

    public void setTimePerDay(String timePerDay) {
        this.timePerDay = timePerDay;
    }

    public String getTimePerWeek() {
        return timePerWeek;
    }

    public void setTimePerWeek(String timePerWeek) {
        this.timePerWeek = timePerWeek;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrugDosages that = (DrugDosages) o;

        if (id != that.id) return false;
        if (customerId != that.customerId) return false;
        if (medicineId != that.medicineId) return false;
        if (quantity != that.quantity) return false;
        if (timePerDay != null ? !timePerDay.equals(that.timePerDay) : that.timePerDay != null) return false;
        if (timePerWeek != null ? !timePerWeek.equals(that.timePerWeek) : that.timePerWeek != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + medicineId;
        result = 31 * result + (timePerDay != null ? timePerDay.hashCode() : 0);
        result = 31 * result + (timePerWeek != null ? timePerWeek.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
