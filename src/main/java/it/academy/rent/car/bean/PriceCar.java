package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "pricecar")
public class PriceCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nameprice")
    private String namePrice;
    @Column(name = "pricecar")
    private long priceCar;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    public PriceCar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePrice() {
        return namePrice;
    }

    public void setNamePrice(String namePrice) {
        this.namePrice = namePrice;
    }

    public long getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(long priceCar) {
        this.priceCar = priceCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "PriceCar{" +
                "id=" + id +
                ", namePrice='" + namePrice + '\'' +
                ", priceCar=" + priceCar +
                ", car=" + car +
                '}';
    }
}
