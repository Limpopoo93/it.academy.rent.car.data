package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class CarSearch {
    private Long id;
    private String country;
    @Temporal(TemporalType.DATE)
    private Date dateCheck;
    @Temporal(TemporalType.DATE)
    private Date dateReturn;
    private String town;
    private String typeCar;
    private Long priceCar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(Long priceCar) {
        this.priceCar = priceCar;
    }
}
