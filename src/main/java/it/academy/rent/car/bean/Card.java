package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"authenticate"})
@ToString(exclude = {"authenticate"})

@Entity
@Table(name = "m_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_user")
    private String nameUser;
    @Column(name = "key_card")
    private Long keyCard;
    @Column(name = "car_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carDate;
    @Column(name = "key_security")
    private Long keySecurity;
    @Column(name = "keys")
    private Long keys;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;

    public Long getId() {
        return id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public Long getKeyCard() {
        return keyCard;
    }

    public Date getCarDate() {
        return carDate;
    }

    public Long getKeySecurity() {
        return keySecurity;
    }

    public Long getKeys() {
        return keys;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setKeyCard(Long keyCard) {
        this.keyCard = keyCard;
    }

    public void setCarDate(Date carDate) {
        this.carDate = carDate;
    }

    public void setKeySecurity(Long keySecurity) {
        this.keySecurity = keySecurity;
    }

    public void setKeys(Long keys) {
        this.keys = keys;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }
}
