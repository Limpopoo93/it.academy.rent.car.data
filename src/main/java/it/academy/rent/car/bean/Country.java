package it.academy.rent.car.bean;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "m_country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "country")
    private String nameCountry;
    @Column(name = "country_remote")
    private Boolean countryRemote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public Boolean getCountryRemote() {
        return countryRemote;
    }

    public void setCountryRemote(Boolean countryRemote) {
        this.countryRemote = countryRemote;
    }
}
