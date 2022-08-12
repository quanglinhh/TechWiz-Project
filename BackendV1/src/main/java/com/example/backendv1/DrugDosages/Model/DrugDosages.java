package com.example.backendv1.DrugDosages.Model;

import com.example.backendv1.UserRole.Model.Medicines.Model.Medicines;
import com.example.backendv1.UserRole.Model.Users;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity



@Table(name = "drug_dosages")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrugDosages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users user;

    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false) // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Medicines medicine;

    @Basic
    @Column(name = "time_per_day")
    private String timePerDay;
    @Basic
    @Column(name = "time_per_week")
    private String timePerWeek;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Basic
    @Column(name = "updated_at", updatable = true)
    private Date updatedAt;

}
