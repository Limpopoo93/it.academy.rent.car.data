package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"authenticate", "car"})
@ToString(exclude = {"authenticate", "car"})

@Entity
@Table(name = "m_busy_date")
public class BusyDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_check")
    @Temporal(TemporalType.DATE)
    private Date dateCheck;
    @Column(name = "date_return")
    @Temporal(TemporalType.DATE)
    private Date dateReturn;
    @Column(name = "price_car")
    @Size(min = 1, max = 15)
    @NotNull
    private Long priceCar;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
    @Column(name = "busy_date_remote")
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
