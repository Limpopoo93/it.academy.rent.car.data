package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "letter")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text_letter")
    private String textLetter;
    @ManyToOne(fetch = FetchType.LAZY, cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;

    public Letter() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextLetter() {
        return textLetter;
    }

    public void setTextLetter(String textLetter) {
        this.textLetter = textLetter;
    }

    public Authenticate getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Authenticate authenticate) {
        this.authenticate = authenticate;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", textLetter='" + textLetter + '\'' +
                ", authenticate=" + authenticate +
                '}';
    }
}
