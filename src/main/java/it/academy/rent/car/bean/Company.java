package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"town","authenticate"})
@ToString(exclude = {"town","authenticate"})

@Entity
@Table(name = "m_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_company")
    @Size(min = 1, max = 15)
    @NotNull
    private String nameCompany;
    @Column
    @Size(min = 1, max = 10)
    @NotNull
    private Long reting;
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private String telephone;
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private String email;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_town", nullable = false)
    private Town town;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
    @Column(name = "company_remote")
    private Boolean companyRemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Long getReting() {
        return reting;
    }

    public void setReting(Long reting) {
        this.reting = reting;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }

    public Boolean getCompanyRemote() {
        return companyRemote;
    }

    public void setCompanyRemote(Boolean companyRemote) {
        this.companyRemote = companyRemote;
    }
}
