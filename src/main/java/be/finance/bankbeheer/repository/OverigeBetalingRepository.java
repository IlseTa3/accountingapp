package be.finance.bankbeheer.repository;

import be.finance.bankbeheer.model.OverigeBetaling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverigeBetalingRepository extends JpaRepository<OverigeBetaling,Long> {
}
