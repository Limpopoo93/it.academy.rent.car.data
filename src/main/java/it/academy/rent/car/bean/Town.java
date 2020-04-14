package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.NAME_TOWN_INVALID;
import static it.academy.rent.car.util.InitConstant.TOWN;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"country"})
@ToString(exclude = {"country"})

@Entity
@Table(name = DB_TOWN)
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTown() {
        return nameTown;
    }

    public void setNameTown(String nameTown) {
        this.nameTown = nameTown;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getTownRemote() {
        return townRemote;
    }

    public void setTownRemote(Boolean townRemote) {
        this.townRemote = townRemote;
    }
}
