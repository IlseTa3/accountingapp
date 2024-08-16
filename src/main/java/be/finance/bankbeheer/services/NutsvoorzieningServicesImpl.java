package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Nutsvoorziening;
import java.util.List;

public interface NutsvoorzieningServicesImpl {

    Nutsvoorziening createNutsvoorziening (Nutsvoorziening nutsvoorziening);

    List<Nutsvoorziening> getAllNutsvoorzieningen();

    Nutsvoorziening getNutsvoorzieningById(Long id);

    void updateNutsvoorziening(Long id, Nutsvoorziening updateDetails);

    void deleteNutsvoorzieningById(Long id);
}
