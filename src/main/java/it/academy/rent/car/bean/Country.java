package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.DB_COUNTRY;
import static it.academy.rent.car.util.DBConstant.DB_COUNTRY_REMOTE;
import static it.academy.rent.car.util.ErrorConstant.NAME_COUNTRY_INVALID;
import static it.academy.rent.car.util.InitConstant.COUNTRY;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = DB_COUNTRY)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = COUNTRY)
    @Size(min = 3, message = NAME_COUNTRY_INVALID)
    private String nameCountry;
    @Column(name = DB_COUNTRY_REMOTE)
    private Boolean countryRemote;

}
