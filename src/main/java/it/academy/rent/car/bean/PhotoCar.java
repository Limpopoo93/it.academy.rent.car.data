package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "photocar")
public class PhotoCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "namephoto")
    private String namePhoto;
    @Lob
    @Column(name = "typephoto")
    @Basic(fetch = FetchType.LAZY)
    private byte[] typePhoto;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    public PhotoCar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    public byte[] getTypePhoto() {
        return typePhoto;
    }

    public void setTypePhoto(byte[] typePhoto) {
        this.typePhoto = typePhoto;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "PhotoCar{" +
                "id=" + id +
                ", namePhoto='" + namePhoto + '\'' +
                ", typePhoto=" + Arrays.toString(typePhoto) +
                ", car=" + car +
                '}';
    }
}
