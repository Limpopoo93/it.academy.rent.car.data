package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "m_roles")
public class Role {
    @Id
    @SequenceGenerator(name = "rolesIdSeq", sequenceName = "m_roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolesIdSeq")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "type_role")
    private String role;

    public Role() {
    }

    public Role(Long userId, String role) {
        this.userId = userId;
        this.role = role;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
