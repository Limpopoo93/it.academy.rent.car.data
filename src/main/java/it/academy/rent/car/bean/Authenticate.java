package it.academy.rent.car.bean;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

import static it.academy.rent.car.util.DBConstant.DB_AUTHENTICATE;
import static it.academy.rent.car.util.DBConstant.DB_PROFILE_CLOSE;
import static it.academy.rent.car.util.ErrorConstant.*;
import static it.academy.rent.car.util.InitConstant.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {PROFILE_CLOSE, ROLE})
@ToString(exclude = {PROFILE_CLOSE, ROLE})

@Entity
@Table(name = DB_AUTHENTICATE)
public class Authenticate implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 1, max = 20, message = LOGIN_INVALID)
    @NotEmpty(message = LOGIN_EMPTY)
    private String login;

    @Column
    @Size(min = 1, max = 150, message = PASSWORD_INVALID)
    @NotEmpty(message = PASSWORD_EMPTY)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column
    @Size(min = 1, max = 15)
    private String email;

    @Column(name = DB_PROFILE_CLOSE)
    private boolean profileClose;

    @Enumerated(EnumType.STRING)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
}
