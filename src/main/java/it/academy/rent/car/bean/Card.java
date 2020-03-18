package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nameuser")
    private String nameUser;
    @Column(name = "keycard")
    private int keyCard;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carDate;
    @Column(name = "keysecurity")
    private int keySecurity;
    @Column(name = "keys")
    private int keys;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;

    public Card() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getKeyCard() {
        return keyCard;
    }

    public void setKeyCard(int keyCard) {
        this.keyCard = keyCard;
    }

    public Date getCarDate() {
        return carDate;
    }

    public void setCarDate(Date carDate) {
        this.carDate = carDate;
    }

    public int getKeySecurity() {
        return keySecurity;
    }

    public void setKeySecurity(int keySecurity) {
        this.keySecurity = keySecurity;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", nameUser='" + nameUser + '\'' +
                ", keyCard=" + keyCard +
                ", carDate=" + carDate +
                ", keySecurity=" + keySecurity +
                ", keys=" + keys +
                ", authenticate=" + authenticate +
                '}';
    }


}
