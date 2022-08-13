package com.example.backendv1.Doctor;
import com.example.backendv1.AppointmentSchedules.Model.AppointmentSchedules;
import com.example.backendv1.HealthFacility.HealthFacilities;
import com.example.backendv1.Specialist.Specialists;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Specialists specialists;

    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "health_facilities_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private HealthFacilities healthFacilities;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Collection<AppointmentSchedules> appointmentSchedules;

    @Basic
    @Column(name = "gender")
    private byte gender;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctors doctors = (Doctors) o;
        if (id != doctors.id) return false;
        if (gender != doctors.gender) return false;
        if (!Objects.equals(name, doctors.name)) return false;
        if (!Objects.equals(image, doctors.image)) return false;
        if (!Objects.equals(address, doctors.address)) return false;
        return Objects.equals(phone, doctors.phone);
    }

    @Override
    public int hashCode() {
        int result = 31 + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
