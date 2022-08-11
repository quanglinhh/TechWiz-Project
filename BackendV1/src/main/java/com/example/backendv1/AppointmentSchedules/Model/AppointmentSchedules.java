package com.example.backendv1.AppointmentSchedules.Model;

import com.example.backendv1.AppointmentStatus.Model.AppointmentStatus;
import com.example.backendv1.Doctor.Doctors;
import com.example.backendv1.UserRole.Model.Users;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "appointment_schedules")
public class AppointmentSchedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users user;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Doctors doctor;

    @Basic
    @Column(name = "time")
    private Date time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    @ToString.Exclude
//    @JsonIgnore
    private AppointmentStatus status;

    @Basic
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public AppointmentSchedules() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppointmentSchedules that = (AppointmentSchedules) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
