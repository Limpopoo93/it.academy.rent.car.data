package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "namecompany")
    private String nameCompany;
    @Column(name = "reting")
    private int reting;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @ManyToMany
    @JoinTable(name = "company_town", joinColumns =
    @JoinColumn(name = "id_company", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_town", referencedColumnName = "id"))
    private Set<Town> townSet = new HashSet<>();

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getReting() {
        return reting;
    }

    public void setReting(int reting) {
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

    public Set<Town> getTownSet() {
        return townSet;
    }

    public void setTownSet(Set<Town> townSet) {
        this.townSet = townSet;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", nameCompany='" + nameCompany + '\'' +
                ", reting=" + reting +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", townSet=" + townSet +
                '}';
    }
}
