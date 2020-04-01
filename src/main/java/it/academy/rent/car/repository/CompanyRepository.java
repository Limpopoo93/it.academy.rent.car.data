package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
   // @Query("select c from Company c  join Town tn on c.town.id = tn.id where tn.id =:id and c.delete = true ")
   // List<Company> findByIdByTown(@Param("id") Long id);
    @Query("select cm from Company cm where cm.id = :id")
    Company findByLId(@Param("id") Long id);
    @Query("select cm from Company cm where cm.authenticate.id = :id")
    Company findByIdAndAuthenticate(@Param("id") Long id);
    Company findByNameCompanyAndEmail(@Param("nameCompany") String nameCompany, @Param("email") String email);
    Company findByNameCompany(@Param("nameCompany") String nameCompany);
}
