package be.finance.bankbeheer.repository;

import be.finance.bankbeheer.model.Huur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuurRepository extends JpaRepository<Huur,Long> {
}
