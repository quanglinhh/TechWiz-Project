package com.example.backendv1.AppointmentSchedules.Model;

import com.example.backendv1.AppointmentStatus.Model.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "appointment_schedules")
public class AppointmentSchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
//    @JsonIgnore
    private AppointmentStatus status;

    @Basic
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public AppointmentSchedules() {
    }
}
