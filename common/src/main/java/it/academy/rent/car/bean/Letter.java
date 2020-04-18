package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.TEXT_INVALID;

@Data
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"authenticate"})
@ToString(exclude = {"authenticate"})
@Entity
@Table(name = DB_LETTER)
public class Letter {
    @Id
    @SequenceGenerator(name = "letterIdSeq", sequenceName = "m_letter_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "letterIdSeq")
    private Long id;
    @Column(name = DB_TEXT_LETTER)
    @Size(min = 5, message = TEXT_INVALID)
    private String textLetter;
    @JsonManagedReference
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
