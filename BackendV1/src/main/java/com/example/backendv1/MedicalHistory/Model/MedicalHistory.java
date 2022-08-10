package com.example.backendv1.MedicalHistory.Model;
import com.example.backendv1.Model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "medical_history", schema = "dbo", catalog = "HealthManage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users user;

    @Basic
    @Column(name = "medical_record")
    private String medicalRecord;
    @Basic
    @Column(name = "allergy")
    private String allergy;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
}
