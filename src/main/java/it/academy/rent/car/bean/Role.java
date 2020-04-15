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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
