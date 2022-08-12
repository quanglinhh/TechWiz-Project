package com.example.backendv1.HealthInformationByDay.Model;
import com.example.backendv1.UserRole.Model.Users;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@Table(name = "health_information_by_day", schema = "dbo", catalog = "HealthManage")
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
    @JsonIgnore
    private Users user;
    @Basic
    @Column(name = "blood_pressure")
//    @NotEmpty(message = "BloodPressure is mandatory")
    private String bloodPressure;
    @Basic
    @Column(name = "weight")
//    @NotBlank(message = "Weight is mandatory")
//    @Min(value = 0, message = "Weight not less than 0")
//    @Max(value = 150, message = "Weight not greater than 150")
    private double weight;
    @Basic
    @Column(name = "glucose_level")
//    @NotBlank(message = "Glucose Level is mandatory")
//    @Min(value = 1, message = "Glucose Level not less than 1")
//    @Max(value = 4, message = "Glucose Level not greater than 4")
    private int glucoseLevel;
    @Basic
    @Column(name = "blood_type")
//    @NotBlank(message = "Blood Type is mandatory")
    private String bloodType;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy/MM/dd")
    @CreationTimestamp
//    @NotBlank(message = "Create_at date is mandatory")
    private Date createdAt;
    @Basic
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy/MM/dd")
    @UpdateTimestamp
//    @NotBlank(message = "Update_at date is mandatory")
    private Date updatedAt;

}
