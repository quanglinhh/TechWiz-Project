package com.example.backendv1.MedicalHistory.Specialist;
import com.example.backendv1.Doctor.Doctors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Entity
@Table(name = "specialists")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Specialists {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "specialists")
    @EqualsAndHashCode.Exclude //
    @ToString.Exclude //
    @JsonIgnore
    Collection<Doctors> doctorsCollection;
    public Specialists(long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialists that = (Specialists) o;

        if (id != that.id) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
