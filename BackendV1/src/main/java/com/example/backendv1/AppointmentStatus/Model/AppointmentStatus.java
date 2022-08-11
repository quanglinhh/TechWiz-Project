package com.example.backendv1.AppointmentStatus.Model;

import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(
            mappedBy = "status",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Collection<AppointmentSchedules> appointmentSchedules;
}
