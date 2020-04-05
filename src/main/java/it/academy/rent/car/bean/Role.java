package it.academy.rent.car.bean;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

import static it.academy.rent.car.util.DBConstant.*;

@Entity
@Table(name = DB_ROLE)
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    @Column(name = DB_TYPE_ROLE)
    private String name;
    @Transient
    @ManyToMany(mappedBy = DB_ROLES)
    private Set<Authenticate> authenticates;
    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Authenticate> getAuthenticates() {
        return authenticates;
    }

    public void setAuthenticates(Set<Authenticate> authenticates) {
        this.authenticates = authenticates;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
