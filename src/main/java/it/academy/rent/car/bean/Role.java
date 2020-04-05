package it.academy.rent.car.bean;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_role")
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    @Column(name = "type_role")
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
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
