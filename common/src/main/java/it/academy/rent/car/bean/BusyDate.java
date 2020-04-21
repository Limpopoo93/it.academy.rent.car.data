package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.InitConstant.*;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"authenticate", "car"})
@ToString(exclude = {"authenticate", "car"})
@Entity
@Table(name = DB_BUSY_DATE)
public class BusyDate {
    @Id
    @SequenceGenerator(name = "busyDateIdSeq", sequenceName = "m_busyDate_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "busyDateIdSeq")
    private Long id;
    @Column(name = DATE_CHECK)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date dateCheck;
    @Column(name = DATE_RETURN)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private Date dateReturn;
    @Column(name = PRICE_CAR)
    private Long priceCar;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = DB_ID_CAR, nullable = false)
    private Car car;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = DB_ID_AUTHENTICATE, nullable = false)
    private Authenticate authenticate;
    @Column(name = BUSY_DATE_REMOTE)
    private Boolean busyDateRemote;

}
