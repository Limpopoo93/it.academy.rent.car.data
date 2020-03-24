package it.academy.rent.car.repository;

import it.academy.rent.car.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select c from Company c join CompanyTown ct on c.id = ct.idCompany join Town tn on ct.idTown = tn.id where tn.id =:id")
    List<Company> findByCompany(@Param("id") Long id);
}
