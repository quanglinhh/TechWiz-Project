package com.example.backendv1.AppointmentStatus.Model;
import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "appointment_status")
@Getter
@Setter
@ToString
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
    @Column(name = "created_at", updatable = false)
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
    @ToString.Exclude
    private Collection<AppointmentSchedules> appointmentSchedules;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppointmentStatus that = (AppointmentStatus) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
