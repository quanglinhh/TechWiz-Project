package com.example.backendv1.UserRole.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Optional;

@Entity
@Table(name = "user_roles", schema = "dbo", catalog = "healthmanage")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserRoles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
//    @Basic
//    @Column(name = "role_id")
//    private Short roleId;
    @Basic
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
//    @Basic
//    @Column(name = "user_id")
//    private Long userId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles rolesByRoleId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users usersByUserId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
//
//    public Short getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Short roleId) {
//        this.roleId = roleId;
//    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (id != userRoles.id) return false;
        if (createdAt != null ? !createdAt.equals(userRoles.createdAt) : userRoles.createdAt != null) return false;
//        if (roleId != null ? !roleId.equals(userRoles.roleId) : userRoles.roleId != null) return false;
        if (updatedAt != null ? !updatedAt.equals(userRoles.updatedAt) : userRoles.updatedAt != null) return false;
//        if (userId != null ? !userId.equals(userRoles.userId) : userRoles.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
//        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
//        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
