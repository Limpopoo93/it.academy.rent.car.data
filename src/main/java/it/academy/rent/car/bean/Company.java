package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.*;
import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;
import static it.academy.rent.car.util.InitConstant.TOWN;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {TOWN, AUTHENTICATE})
@ToString(exclude = {TOWN, AUTHENTICATE})

@Entity
@Table(name = DB_COMPANY)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = DB_NAME_COMPANY)
    @Size(min = 1, max = 15, message = NAME_COMPANY_INVALID)
    @NotEmpty(message = NAME_COMPANY_EMPTY)
    private String nameCompany;
    @Column
    @Size(min = 1, max = 10, message = RETING_INVALID)
    @NotEmpty(message = RETING_EMPTY)
    private Long reting;
    @Column
    @Size(min = 1, max = 15, message = TELEPHONE_INVALID)
    @NotEmpty(message = TELEPHONE_EMPTY)
    private String telephone;
    @Column
    @Size(min = 1, max = 15, message = EMAIL_INVALID)
    @NotEmpty(message = EMAIL_EMPTY)
    private String email;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_TOWN, nullable = false)
    private Town town;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_AUTHENTICATE, nullable = false)
    private Authenticate authenticate;
    @Column(name = DB_COMPANY_REMOTE)
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
