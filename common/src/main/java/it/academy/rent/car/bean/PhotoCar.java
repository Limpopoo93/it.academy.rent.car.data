package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.NAME_PHOTO_INVALID;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"car", "typePhoto"})
@ToString(exclude = {"car", "typePhoto"})
@Entity
@Table(name = DB_PHOTO_CAR)
public class PhotoCar {
    @Id
    @SequenceGenerator(name = "photoCarIdSeq", sequenceName = "m_photoCar_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photoCarIdSeq")
    private Long id;
    @Column(name = DB_NAME_PHOTO)
    @Size(min = 3, message = NAME_PHOTO_INVALID)
    private String namePhoto;
    @Lob
    @Column(name = DB_TYPE_PHOTO)
    @Basic(fetch = FetchType.LAZY)
    private byte[] typePhoto;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_CAR, nullable = false)
    private Car car;
    @Column(name = DB_PHOTO_CAR_REMOTE)
    private Boolean photoCarRemote;

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

    public Boolean getPhotoCarRemote() {
        return photoCarRemote;
    }

    public void setPhotoCarRemote(Boolean photoCarRemote) {
        this.photoCarRemote = photoCarRemote;
    }
}
