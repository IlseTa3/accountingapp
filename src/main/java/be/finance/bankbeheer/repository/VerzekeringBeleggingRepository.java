package be.finance.bankbeheer.repository;

import be.finance.bankbeheer.model.VerzekeringBelegging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerzekeringBeleggingRepository extends JpaRepository<VerzekeringBelegging,Long> {
}
