package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Huur;
import be.finance.bankbeheer.model.Voedselgroepen;

import java.util.List;

public interface HuurServicesImpl {
    Huur createBetalingHuur(Huur huur);
    List<Huur> getAllBetalingenHuur();
    Huur getBetalingHuurById(Long id);
    void updateBetalingHuur(Long id, Huur updateDetails);
    void deleteBetalingHuurById(Long id);
}
