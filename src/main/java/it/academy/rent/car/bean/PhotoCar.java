package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"typePhoto", "car"})
@ToString(exclude = {"typePhoto", "car"})

@Entity
@Table(name = "m_photo_car")
public class PhotoCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_photo")
    private String namePhoto;
    @Lob
    @Column(name = "type_photo")
    @Basic(fetch = FetchType.LAZY)
    private byte[] typePhoto;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
