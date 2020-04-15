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
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class CarSearch {
    private Long id;
    @Size(min = 3, message = NAME_COUNTRY_INVALID)
    private String country;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date dateCheck;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date dateReturn;
    @Size(min = 3, message = NAME_TOWN_INVALID)
    private String town;
    private String typeCar;
    private Long priceCar;

}
