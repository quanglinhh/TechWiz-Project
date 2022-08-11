package com.example.backendv1.HealthInformationByDay.Model;
import com.example.backendv1.UserRole.Model.Users;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "health_information_by_day")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthInformationByDay {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users user;
    @Basic
    @Column(name = "blood_pressure")
    private String bloodPressure;
    @Basic
    @Column(name = "weight")
    private double weight;
    @Basic
    @Column(name = "glucose_level")
    private int glucoseLevel;
    @Basic
    @Column(name = "blood_type")
    private String bloodType;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "updated_at")
    private Date updatedAt;


}
