package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.InitConstant.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = {"authenticate", "car"})
//@ToString(exclude = {"authenticate", "car"})

@Entity
@Table(name = DB_BUSY_DATE)
public class BusyDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = DATE_CHECK)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy.MM.dd")
    private Date dateCheck;
    @Column(name = DATE_RETURN)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy.MM.dd")
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

    @Override
    public String toString() {
        return "BusyDate{" +
                "id=" + id +
                ", dateCheck=" + dateCheck +
                ", dateReturn=" + dateReturn +
                ", priceCar=" + priceCar +
                ", car=" + car +
                ", authenticate=" + authenticate +
                ", busyDateRemote=" + busyDateRemote +
                '}';
    }
}
