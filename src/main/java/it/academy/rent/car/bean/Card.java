package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.*;
import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {AUTHENTICATE})
@ToString(exclude = {AUTHENTICATE})

@Entity
@Table(name = DB_CARD)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = DB_NAME_USER)
    @Size(min = 1, max = 15, message = NAME_USER_INVALID)
    @NotEmpty(message = NAME_USER_EMPTY)
    private String nameUser;
    @Column(name = DB_KEY_CARD)
    @Size(min = 1, max = 15, message = KEY_CARD_INVALID)
    @NotEmpty(message = KEY_CARD_EMPTY)
    private Long keyCard;
    @Column(name = DB_CAR_DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date carDate;
    @Column(name = DB_KEY_SECURITY)
    @Size(min = 1, max = 15, message = KEY_SECURITY_INVALID)
    @NotEmpty(message = KEY_SECURITY_EMPTY)
    private Long keySecurity;
    @Column
    @Size(min = 1, max = 15, message = KEYS_INVALID)
    @NotEmpty(message = KEYS_EMPTY)
    private Long keys;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_AUTHENTICATE, nullable = false)
    private Authenticate authenticate;
    @Column(name = DB_CARD_REMOTE)
    private Boolean cardRemote;

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

    public Boolean getCardRemote() {
        return cardRemote;
    }

    public void setCardRemote(Boolean cardRemote) {
        this.cardRemote = cardRemote;
    }
}
