package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.DB_COUNTRY;
import static it.academy.rent.car.util.DBConstant.DB_COUNTRY_REMOTE;
import static it.academy.rent.car.util.ErrorConstant.NAME_COUNTRY_EMPTY;
import static it.academy.rent.car.util.ErrorConstant.NAME_COUNTRY_INVALID;
import static it.academy.rent.car.util.InitConstant.COUNTRY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = DB_COUNTRY)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = COUNTRY)
    @Size(min = 1, max = 15, message = NAME_COUNTRY_INVALID)
    @NotEmpty(message = NAME_COUNTRY_EMPTY)
    private String nameCountry;
    @Column(name = DB_COUNTRY_REMOTE)
    private Boolean countryRemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public Boolean getCountryRemote() {
        return countryRemote;
    }

    public void setCountryRemote(Boolean countryRemote) {
        this.countryRemote = countryRemote;
    }
}
