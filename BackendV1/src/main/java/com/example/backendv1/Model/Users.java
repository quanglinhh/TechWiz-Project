package com.example.backendv1.Model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
=======
import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.example.backendv1.MedicalHistory.Model.MedicalHistory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;
>>>>>>> 1906c403e9a5f4af0ec2b06dd5daacbf398f6cd7
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
<<<<<<< HEAD
=======
import java.util.HashSet;
import java.util.Set;
>>>>>>> 1906c403e9a5f4af0ec2b06dd5daacbf398f6cd7

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "gender")
    private Short gender;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
<<<<<<< HEAD
    @Basic
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<UserRoles> userRolesById;
=======

    //Luyen: Mapping with table DrugUsages
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Collection<DrugDosages> drugDosagesCollection;

    //Luyen: Mapping with table MedicalHistory
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Collection<MedicalHistory> medicalHistoryCollection;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
>>>>>>> 1906c403e9a5f4af0ec2b06dd5daacbf398f6cd7

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (age != null ? !age.equals(users.age) : users.age != null) return false;
        if (createdAt != null ? !createdAt.equals(users.createdAt) : users.createdAt != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (gender != null ? !gender.equals(users.gender) : users.gender != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (updatedAt != null ? !updatedAt.equals(users.updatedAt) : users.updatedAt != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    public Collection<UserRoles> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRoles> userRolesById) {
        this.userRolesById = userRolesById;
    }
}
