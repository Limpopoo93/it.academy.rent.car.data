package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.*;
import static it.academy.rent.car.util.InitConstant.COMPANY;
import static it.academy.rent.car.util.InitConstant.PRICE_CAR;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {COMPANY, PRICE_CAR})
@ToString(exclude = {COMPANY, PRICE_CAR})

@Entity
@Table(name = DB_CAR)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = DB_NAME_CAR)
    @Size(min = 1, max = 15 , message = NAME_CAR_INVALID)
    @NotEmpty(message = NAME_CAR_EMPTY)
    private String nameCar;
    @Column(name = DB_TYPE_FUEL)
    @Size(min = 1, max = 10, message = TYPE_FUEL_INVALID)
    @NotEmpty(message = TYPE_FUEL_EMPTY)
    private String typeFuel;
    @Column(name = DB_COL_DOORS)
    @Size(min = 1, max = 7, message = COL_DOOR_INVALID)
    @NotEmpty(message = COL_DOOR_EMPTY)
    private Long colDoors;
    @Column(name = DB_COL_PEOPLE)
    @Size(min = 1, max = 10, message = COL_PEOPLE_INVALID)
    @NotEmpty(message = COL_PEOPLE_EMPTY)
    private Long colPeople;
    @Column
    @Size(min = 1, max = 30, message = MILEAGE_INVALID)
    @NotEmpty(message = MILEAGE_EMPTY)
    private Long mileage;
    @Column(name = DB_MAKE_CAR)
    @Size(min = 1, max = 15, message = MAKE_CAR_INVALID)
    @NotEmpty(message = MAKE_CAR_EMPTY)
    private String makeCar;
    @Column(name = DB_TYPE_CAR)
    @Size(min = 1, max = 15, message = TYPE_CAR_INVALID)
    @NotEmpty(message = TYPE_CAR_EMPTY)
    private String typeCar;
    @Column
    @Size(min = 1, max = 15, message = PRICE_INVALID)
    @NotEmpty(message = PRICE_CAR_EMPTY)
    private Long price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_COMPANY, nullable = false)
    private Company company;
    @Column(name = DB_CAR_REMOTE)
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
