package be.finance.bankbeheer.repository;

import be.finance.bankbeheer.model.Voedselgroepen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoedselgroepenRepository extends JpaRepository<Voedselgroepen,Long> {
}
