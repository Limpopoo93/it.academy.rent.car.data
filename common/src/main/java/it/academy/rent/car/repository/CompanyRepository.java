package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select cm from Company cm where cm.authenticate.id = :id")
    Company findByIdAndAuthenticate(@Param("id") Long id);

    Company findByNameCompanyAndEmail(String nameCompany, String email);

    Company findByNameCompany(String nameCompany);

}
