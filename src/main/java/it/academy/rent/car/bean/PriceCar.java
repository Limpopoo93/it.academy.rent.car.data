package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"car"})
@ToString(exclude = {"car"})

@Entity
@Table(name = "m_price_car")
public class PriceCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_price")
    private String namePrice;
    @Column(name = "price_car")
    private Long priceCar;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePrice() {
        return namePrice;
    }

    public void setNamePrice(String namePrice) {
        this.namePrice = namePrice;
    }

    public Long getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(Long priceCar) {
        this.priceCar = priceCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
