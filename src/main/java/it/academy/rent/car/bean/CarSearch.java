package it.academy.rent.car.bean;

import java.util.Date;

public class CarSearch {
    private long id;
    private String country;
    //@DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateCheck;
    //@DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateReturn;
    private String town;
    private String typeCar;

    public CarSearch() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateCheck() {
        return dateCheck;
    }

    public void setDateCheck(Date dateCheck) {
        this.dateCheck = dateCheck;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

}
