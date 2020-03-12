package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "drivecard")
public class DriveCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "country")
    private String country;
    @Column(name = "datemake")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMake;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
      @ManyToMany
      @JoinTable(name = "category_card", joinColumns =
      @JoinColumn(name = "id_categorycard", referencedColumnName = "id"),
              inverseJoinColumns = @JoinColumn(name = "id_drivecard", referencedColumnName = "id"))
    private Set<CategoryCard> categoryCards = new HashSet<>();

    public DriveCard() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateMake() {
        return dateMake;
    }

    public void setDateMake(Date dateMake) {
        this.dateMake = dateMake;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }

    public Set<CategoryCard> getCategoryCards() {
        return categoryCards;
    }

    public void setCategoryCards(Set<CategoryCard> categoryCards) {
        this.categoryCards = categoryCards;
    }

    @Override
    public String toString() {
        return "DriveCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", dateMake=" + dateMake +
                ", authenticate=" + authenticate +
                ", categoryCards=" + categoryCards +
                '}';
    }
}
