package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "letter")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "letter")
    private String letter;
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

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
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
                ", letter='" + letter + '\'' +
                ", authenticate=" + authenticate +
                '}';
    }
}
