package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = {"profile_close", "roles"})
//@ToString(exclude = {"profile_close", "roles"})

@Entity
@Table(name = DB_AUTHENTICATE)
public class Authenticate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isProfileClose() {
        return profileClose;
    }

    public void setProfileClose(boolean profileClose) {
        this.profileClose = profileClose;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getProfileRemote() {
        return profileRemote;
    }

    public void setProfileRemote(Boolean profileRemote) {
        this.profileRemote = profileRemote;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return "Authenticate{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", email='" + email + '\'' +
                ", profileClose=" + profileClose +
                ", roles=" + roles +
                ", profileRemote=" + profileRemote +
                '}';
    }
}
