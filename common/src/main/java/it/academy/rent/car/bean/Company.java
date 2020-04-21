package it.academy.rent.car.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import static it.academy.rent.car.util.DBConstant.*;
import static it.academy.rent.car.util.ErrorConstant.*;

@Data
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DB_COMPANY)
public class Company {
    @Id
    @SequenceGenerator(name = "companySeq", sequenceName = "m_company_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyIdSeq")
    private Long id;
    @Column(name = DB_NAME_COMPANY)
    @Size(min = 3, message = NAME_COMPANY_INVALID)
    private String nameCompany;
    @Column
    private Long reting;
    @Column
    @Size(min = 4, message = TELEPHONE_INVALID)
    private String telephone;
    @Column
    private String email;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_TOWN, nullable = false)
    private Town town;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = DB_ID_AUTHENTICATE, nullable = false)
    private Authenticate authenticate;
    @Column(name = DB_COMPANY_REMOTE)
    private Boolean companyRemote;

}
