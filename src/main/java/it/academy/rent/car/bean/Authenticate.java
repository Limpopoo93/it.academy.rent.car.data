package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "authenticate")
public class Authenticate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "profileenable")
    private boolean profileEnable;
    @Column(name = "profileclose")
    private boolean profileClose;
    @Column(name = "role")
    private Role role;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public Authenticate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isProfileEnable() {
        return profileEnable;
    }

    public void setProfileEnable(boolean profileEnable) {
        this.profileEnable = profileEnable;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Authenticate{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profileEnable=" + profileEnable +
                ", profileClose=" + profileClose +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
