package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Set;

import static it.academy.rent.car.util.DBConstant.DB_AUTHENTICATE;
import static it.academy.rent.car.util.DBConstant.DB_PROFILE_CLOSE;
import static it.academy.rent.car.util.ErrorConstant.*;
import static it.academy.rent.car.util.InitConstant.PROFILE_REMOTE;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"roles"})
@ToString(exclude = {"roles"})
@Entity
@Table(name = DB_AUTHENTICATE)
public class Authenticate {
    @Id
    @SequenceGenerator(name = "authenticateIdSeq", sequenceName = "m_authenticate_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authenticateIdSeq")
    private Long id;

    @Column
    @Size(min = 5, message = LOGIN_INVALID)
    private String login;

    @Column
    @Size(min = 1, message = PASSWORD_INVALID)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column
    @Size(min = 1, max = 15)
    @Email(message = EMAIL_INVALID)
    private String email;

    @Column(name = DB_PROFILE_CLOSE)
    private boolean profileClose;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "id")
    private Set<Role> roles = Collections.emptySet();

    @Column(name = PROFILE_REMOTE)
    private Boolean profileRemote;

}
