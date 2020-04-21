package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.NAME_TOWN_INVALID;
import static it.academy.rent.car.util.InitConstant.TOWN;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"country"})
@ToString(exclude = {"country"})
@Entity
@Table(name = DB_TOWN)
public class Town {
    @Id
    @SequenceGenerator(name = "townIdSeq", sequenceName = "m_town_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "townIdSeq")
    private Long id;
    @Column(name = TOWN)
    @Size(min = 3, message = NAME_TOWN_INVALID)
    private String nameTown;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_COUNTRY, nullable = false)
    private Country country;
    @Column(name = DB_TOWN_REMOTE)
    private Boolean townRemote;

}
