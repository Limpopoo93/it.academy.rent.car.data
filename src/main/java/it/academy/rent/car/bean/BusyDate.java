package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.PRICE_CAR_EMPTY;
import static it.academy.rent.car.util.ErrorConstant.PRICE_INVALID;
import static it.academy.rent.car.util.InitConstant.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {AUTHENTICATE, CAR})
@ToString(exclude = {AUTHENTICATE, CAR})

@Entity
@Table(name = DB_BUSY_DATE)
public class BusyDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = DATE_CHECK)
    @Temporal(TemporalType.DATE)
    private Date dateCheck;
    @Column(name = DATE_RETURN)
    @Temporal(TemporalType.DATE)
    private Date dateReturn;
    @Column(name = PRICE_CAR)
    @Size(min = 1, max = 15 , message = PRICE_INVALID)
    @NotEmpty(message = PRICE_CAR_EMPTY)
    private Long priceCar;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_CAR, nullable = false)
    private Car car;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_AUTHENTICATE, nullable = false)
    private Authenticate authenticate;
    @Column(name = BUSY_DATE_REMOTE)
    private Boolean busyDateRemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }

    public Boolean getBusyDateRemote() {
        return busyDateRemote;
    }

    public void setBusyDateRemote(Boolean busyDateRemote) {
        this.busyDateRemote = busyDateRemote;
    }

    public Long getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(Long priceCar) {
        this.priceCar = priceCar;
    }
}
