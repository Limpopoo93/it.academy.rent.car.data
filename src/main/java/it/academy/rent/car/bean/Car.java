package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "namecar")
    private String nameCar;
    @Column(name = "typefuel")
    private TypeFuel typeFuel;
    @Column(name = "coldoors")
    private int colDoors;
    @Column(name = "colpeople")
    private int colPeople;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "makecar")
    private String makeCar;
    @Column(name = "typecar")
    private String typeCar;
    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_company", nullable = false)
    private Company company;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public int getColDoors() {
        return colDoors;
    }

    public void setColDoors(int colDoors) {
        this.colDoors = colDoors;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
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

    public int getColPeople() {
        return colPeople;
    }

    public void setColPeople(int colPeople) {
        this.colPeople = colPeople;
    }

    public TypeFuel getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(TypeFuel typeFuel) {
        this.typeFuel = typeFuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameCar='" + nameCar + '\'' +
                ", typeFuel='" + typeFuel + '\'' +
                ", colDoors=" + colDoors +
                ", colPeople=" + colPeople +
                ", mileage=" + mileage +
                ", makeCar='" + makeCar + '\'' +
                ", typeCar='" + typeCar + '\'' +
                ", company=" + company +
                '}';
    }
}
