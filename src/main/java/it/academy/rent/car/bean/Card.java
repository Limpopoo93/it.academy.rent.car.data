package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 1, max = 15)
    @NotNull
    private String nameUser;
    @Column(name = "key_card")
    @Size(min = 1, max = 15)
    @NotNull
    private Long keyCard;
    @Column(name = "car_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carDate;
    @Column(name = "key_security")
    @Size(min = 1, max = 15)
    @NotNull
    private Long keySecurity;
    @Column
    @Size(min = 1, max = 15)
    @NotNull
    private Long keys;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
    @Column(name = "card_remote")
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
