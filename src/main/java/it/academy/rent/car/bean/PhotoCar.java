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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
