package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"company, priceCar"})
@ToString(exclude = {"company, priceCar"})

@Entity
@Table(name = "m_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_car")
    private String nameCar;
    @Column(name = "type_fuel")
    private String typeFuel;
    @Column(name = "col_doors")
    private Long colDoors;
    @Column(name = "col_people")
    private Long colPeople;
    @Column(name = "mileage")
    private Long mileage;
    @Column(name = "make_car")
    private String makeCar;
    @Column(name = "type_car")
    private String typeCar;
    @Column(name = "price")
    private Long price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_company", nullable = false)
    private Company company;
    @Column(name = "car_remote")
    private Boolean carRemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }

    public Long getColDoors() {
        return colDoors;
    }

    public void setColDoors(Long colDoors) {
        this.colDoors = colDoors;
    }

    public Long getColPeople() {
        return colPeople;
    }

    public void setColPeople(Long colPeople) {
        this.colPeople = colPeople;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getMakeCar() {
        return makeCar;
    }

    public void setMakeCar(String makeCar) {
        this.makeCar = makeCar;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getCarRemote() {
        return carRemote;
    }

    public void setCarRemote(Boolean carRemote) {
        this.carRemote = carRemote;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
