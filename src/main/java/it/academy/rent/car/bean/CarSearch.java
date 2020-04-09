package it.academy.rent.car.bean;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;

import static it.academy.rent.car.util.ErrorConstant.NAME_COUNTRY_INVALID;
import static it.academy.rent.car.util.ErrorConstant.NAME_TOWN_INVALID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class CarSearch {
    private Long id;
    @Size(min = 3, message = NAME_COUNTRY_INVALID)
    private String country;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy.MM.dd")
    private Date dateCheck;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy.MM.dd")
    private Date dateReturn;
    @Size(min = 3, message = NAME_TOWN_INVALID)
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
