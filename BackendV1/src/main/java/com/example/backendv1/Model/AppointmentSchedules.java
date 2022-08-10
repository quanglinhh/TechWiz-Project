package com.example.backendv1.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "appointment_schedules", schema = "dbo", catalog = "HealthManage")
public class AppointmentSchedules {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "user_id")
    private long userId;
    @Basic
    @Column(name = "doctor_id")
    private long doctorId;
    @Basic
    @Column(name = "time")
    private Date time;
    @Basic
    @Column(name = "status_id")
    private byte statusId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public byte getStatusId() {
        return statusId;
    }

    public void setStatusId(byte statusId) {
        this.statusId = statusId;
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

        AppointmentSchedules that = (AppointmentSchedules) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (doctorId != that.doctorId) return false;
        if (statusId != that.statusId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (doctorId ^ (doctorId >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (int) statusId;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
