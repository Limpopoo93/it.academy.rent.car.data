package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "street")
    private String street;
    @Column(name = "numberstreet")
    private int numberStreet;
    @Column(name = "index")
    private int index;
    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_company", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_town", nullable = false)
    private Town town;

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(int numberStreet) {
        this.numberStreet = numberStreet;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", numberStreet=" + numberStreet +
                ", index=" + index +
                ", company=" + company +
                ", town=" + town +
                '}';
    }


}
