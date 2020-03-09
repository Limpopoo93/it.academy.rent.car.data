package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Authenticate authenticate;
    private List<CategoryCard> categoryCards = new ArrayList<>();

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

    @Override
    public String toString() {
        return "DriveCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", dateMake=" + dateMake +
                ", authenticate=" + authenticate +
                '}';
    }
}
