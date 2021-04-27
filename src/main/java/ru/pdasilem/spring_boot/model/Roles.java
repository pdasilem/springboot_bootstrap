package ru.pdasilem.spring_boot.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany
   private Set<UserModel> userModelSet;

    public Roles() {};

    public Roles(String role, Set<UserModel> userModelSet) {
        this.role = role;
        this.userModelSet = userModelSet;
    }
    public Roles(Long id, String role) {
        this.id = id;
        this.role = role;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserModel> getUserModelSet() {
        return userModelSet;
    }

    public void setUserModelSet(Set<UserModel> userModelSet) {
        this.userModelSet = userModelSet;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
