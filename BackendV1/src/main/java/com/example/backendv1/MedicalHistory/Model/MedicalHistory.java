package com.example.backendv1.MedicalHistory.Model;
import com.example.backendv1.UserRole.Model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity


@Table(name = "medical_history")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Basic
    @Column(name = "medical_record") //note all the diseases of a user here
    private String medicalRecord;
    @Basic
    @Column(name = "allergy") //note all the allergic item for a user here
    private String allergy;

    @Basic
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
    public MedicalHistory(long id, Users user, String medicalRecord, String allergy) {
        this.id = id;
        this.user = user;
        this.medicalRecord = medicalRecord;
        this.allergy = allergy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalHistory that = (MedicalHistory) o;
        return this.user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getEmail());
    }
}
