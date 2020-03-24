package it.academy.rent.car.bean;

import javax.persistence.*;

@Entity
@Table(name = "companytown")
public class CompanyTown {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "id_company")
    private long idCompany;
    @Column(name = "id_town")
    private long idTown;

    public CompanyTown() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public long getIdTown() {
        return idTown;
    }

    public void setIdTown(long idTown) {
        this.idTown = idTown;
    }

    @Override
    public String toString() {
        return "CompanyTown{" +
                "id=" + id +
                ", idCompany=" + idCompany +
                ", idTown=" + idTown +
                '}';
    }
}
