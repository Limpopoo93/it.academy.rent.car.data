package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"profileClose", "role"})
@ToString(exclude = {"profileClose", "role"})

@Entity
@Table(name = "m_authenticate")
public class Authenticate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private String login;
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private String password;
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private String email;
    @Column(name = "profile_close")
    private boolean profileClose;
    @Enumerated(EnumType.STRING)
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private Role role;
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

    public String getPassword() {
        return password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getProfileRemote() {
        return profileRemote;
    }

    public void setProfileRemote(Boolean profileRemote) {
        this.profileRemote = profileRemote;
    }
}
