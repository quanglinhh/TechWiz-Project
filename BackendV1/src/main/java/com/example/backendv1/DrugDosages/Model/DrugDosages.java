package com.example.backendv1.DrugDosages.Model;

import com.example.backendv1.Medicines.Model.Medicines;
import com.example.backendv1.UserRole.Model.Users;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
    @Column(name = "time_per_day", nullable = false)
    private String timePerDay;
    @Basic
    @Column(name = "time_per_week", nullable = false)
    private String timePerWeek;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Basic
    @Column(name = "updated_at", updatable = true)
    @UpdateTimestamp
    private Date updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugDosages that = (DrugDosages) o;
        return  this.getUser().getId() == that.getUser().getId()
                && this.getMedicine().getId() == that.getMedicine().getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, medicine);
    }
}
