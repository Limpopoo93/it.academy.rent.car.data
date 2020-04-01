package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"authenticate"})
@ToString(exclude = {"authenticate"})

@Entity
@Table(name = "m_letter")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text_letter")
    private String textLetter;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
    @Column(name = "letter_remote")
    private Boolean letterRemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getLetterRemote() {
        return letterRemote;
    }

    public void setLetterRemote(Boolean letterRemote) {
        this.letterRemote = letterRemote;
    }
}
