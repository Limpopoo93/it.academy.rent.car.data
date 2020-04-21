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
    private Integer colDoors;
    @Column(name = DB_COL_PEOPLE)
    private Integer colPeople;
    @Column
    private Integer mileage;
    @Column(name = DB_MAKE_CAR)
    @Size(min = 2, message = MAKE_CAR_INVALID)
    private String makeCar;
    @Column(name = DB_TYPE_CAR)
    @Size(min = 1, message = TYPE_CAR_INVALID)
    private String typeCar;
    @Column(name = "price")
    private Long price;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_COMPANY, nullable = false)
    private Company company;
    @Column(name = DB_CAR_REMOTE)
    private Boolean carRemote;
}
