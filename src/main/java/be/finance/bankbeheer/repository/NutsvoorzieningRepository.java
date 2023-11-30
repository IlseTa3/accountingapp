package be.finance.bankbeheer.repository;

import be.finance.bankbeheer.model.Nutsvoorziening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutsvoorzieningRepository extends JpaRepository<Nutsvoorziening,Long> {
}
