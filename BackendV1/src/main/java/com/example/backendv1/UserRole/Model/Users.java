package com.example.backendv1.UserRole.Model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.example.backendv1.DrugDosages.Model.DrugDosages;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

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

    @Basic
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<UserRoles> userRolesById;

    //Luyen: Mapping with table DrugUsages
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Collection<DrugDosages> drugDosagesCollection;

    public Collection<DrugDosages> getDrugDosagesCollection() {
        return drugDosagesCollection;
    }

    public void setDrugDosagesCollection(Collection<DrugDosages> drugDosagesCollection) {
        this.drugDosagesCollection = drugDosagesCollection;
    }

    public Collection<MedicalHistory> getMedicalHistoryCollection() {
        return medicalHistoryCollection;
    }

    public void setMedicalHistoryCollection(Collection<MedicalHistory> medicalHistoryCollection) {
        this.medicalHistoryCollection = medicalHistoryCollection;
    }

    //Luyen: Mapping with table MedicalHistory
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private MedicalHistory medicalHistory;


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
        if (!Objects.equals(email, users.email)) return false;
        if (!Objects.equals(phone, users.phone)) return false;
        return Objects.equals(username, users.username);
    }

    @Override
    public int hashCode() {
        int result = 31 + (email != null ? email.hashCode() : 0);
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
