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
    private String roleName;

    public Role() {
    }

    public Role(Long userId, String roleName) {
        this.userId = userId;
        this.roleName = roleName;

    }

}
