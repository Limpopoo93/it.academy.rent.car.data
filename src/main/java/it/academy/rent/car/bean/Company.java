package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"town"})
@ToString(exclude = {"town"})

@Entity
@Table(name = "m_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_company")
    private String nameCompany;
    @Column(name = "reting")
    private Long reting;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_town", nullable = false)
    private Town town;

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
}
