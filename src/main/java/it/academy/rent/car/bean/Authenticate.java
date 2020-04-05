package it.academy.rent.car.bean;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"profileClose", "role"})
@ToString(exclude = {"profileClose", "role"})

@Entity
@Table(name = "m_authenticate")
public class Authenticate implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private String login;

    @Column
    @Size(min = 1, max = 150)
    @NotNull
    private String password;

    @Transient
    private String passwordConfirm;

    @Column
    @Size(min = 1, max = 15)
    private String email;

    @Column(name = "profile_close")
    private boolean profileClose;

    @Enumerated(EnumType.STRING)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Column(name = "profile_remote")
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
