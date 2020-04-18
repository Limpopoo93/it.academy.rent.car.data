package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.*;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"company"})
@ToString(exclude = {"company"})
@Entity
@Table(name = DB_CAR)
public class Car {
    @Id
    @SequenceGenerator(name = "carIdSeq", sequenceName = "m_car_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdSeq")
    private Long id;
    @Column(name = DB_NAME_CAR)
    @Size(min = 2, message = NAME_CAR_INVALID)
    private String nameCar;
    @Column(name = DB_TYPE_FUEL)
    @Size(min = 2, message = TYPE_FUEL_INVALID)
    private String typeFuel;
    @Column(name = DB_COL_DOORS)
    @Size(min = 2, message = COL_DOOR_INVALID)
    private Long colDoors;
    @Column(name = DB_COL_PEOPLE)
    @Size(min = 1, message = COL_PEOPLE_INVALID)
    private Long colPeople;
    @Column
    @Size(min = 1, message = MILEAGE_INVALID)
    private Long mileage;
    @Column(name = DB_MAKE_CAR)
    @Size(min = 2, message = MAKE_CAR_INVALID)
    private String makeCar;
    @Column(name = DB_TYPE_CAR)
    @Size(min = 1, message = TYPE_CAR_INVALID)
    private String typeCar;
    @Column(name = "price")
    @Size(min = 1, message = PRICE_INVALID)
    private Long price;
    @JsonManagedReference
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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
}
