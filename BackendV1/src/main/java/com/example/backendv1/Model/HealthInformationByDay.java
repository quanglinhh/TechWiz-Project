package com.example.backendv1.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "health_information_by_day", schema = "dbo", catalog = "HealthManage")
public class HealthInformationByDay {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "customer_id")
    private long customerId;
    @Basic
    @Column(name = "blood_pressure")
    private String bloodPressure;
    @Basic
    @Column(name = "weight")
    private double weight;
    @Basic
    @Column(name = "glucose_level")
    private int glucoseLevel;
    @Basic
    @Column(name = "blood_type")
    private String bloodType;
    @Basic
    @Column(name = "note")
    private String note;
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

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(int glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

        HealthInformationByDay that = (HealthInformationByDay) o;

        if (id != that.id) return false;
        if (customerId != that.customerId) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (glucoseLevel != that.glucoseLevel) return false;
        if (bloodPressure != null ? !bloodPressure.equals(that.bloodPressure) : that.bloodPressure != null)
            return false;
        if (bloodType != null ? !bloodType.equals(that.bloodType) : that.bloodType != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (bloodPressure != null ? bloodPressure.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + glucoseLevel;
        result = 31 * result + (bloodType != null ? bloodType.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
