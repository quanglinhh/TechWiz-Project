package com.example.backendv1.Doctor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Doctors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "speciality_id")
    private long specialityId;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "health_facilities_id")
    private long healthFacilitiesId;
    @Basic
    @Column(name = "gender")
    private byte gender;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(long specialityId) {
        this.specialityId = specialityId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getHealthFacilitiesId() {
        return healthFacilitiesId;
    }

    public void setHealthFacilitiesId(long healthFacilitiesId) {
        this.healthFacilitiesId = healthFacilitiesId;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
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

        Doctors doctors = (Doctors) o;

        if (id != doctors.id) return false;
        if (specialityId != doctors.specialityId) return false;
        if (healthFacilitiesId != doctors.healthFacilitiesId) return false;
        if (gender != doctors.gender) return false;
        if (name != null ? !name.equals(doctors.name) : doctors.name != null) return false;
        if (image != null ? !image.equals(doctors.image) : doctors.image != null) return false;
        if (address != null ? !address.equals(doctors.address) : doctors.address != null) return false;
        if (phone != null ? !phone.equals(doctors.phone) : doctors.phone != null) return false;
        if (createdAt != null ? !createdAt.equals(doctors.createdAt) : doctors.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(doctors.updatedAt) : doctors.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (specialityId ^ (specialityId >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (int) (healthFacilitiesId ^ (healthFacilitiesId >>> 32));
        result = 31 * result + (int) gender;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
