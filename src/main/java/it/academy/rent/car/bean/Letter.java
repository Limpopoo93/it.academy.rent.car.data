package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.TEXT_EMPTY;
import static it.academy.rent.car.util.ErrorConstant.TEXT_INVALID;
import static it.academy.rent.car.util.InitConstant.AUTHENTICATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {AUTHENTICATE})
@ToString(exclude = {AUTHENTICATE})

@Entity
@Table(name = DB_LETTER)
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = DB_TEXT_LETTER)
    @Size(min = 1, max = 50, message = TEXT_INVALID)
    @NotEmpty(message = TEXT_EMPTY)
    private String textLetter;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_AUTHENTICATE, nullable = false)
    private Authenticate authenticate;
    @Column(name = DB_LETTER_REMOTE)
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
