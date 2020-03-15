package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "busydate")
public class BusyDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "datecheck")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCheck;
    @Column(name = "datereturn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReturn;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;

    public BusyDate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "BusyDate{" +
                "id=" + id +
                ", dateCheck=" + dateCheck +
                ", dateReturn=" + dateReturn +
                ", car=" + car +
                ", authenticate=" + authenticate +
                '}';
    }


}
