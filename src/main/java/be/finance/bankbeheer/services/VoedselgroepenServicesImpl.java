package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Voedselgroepen;

import java.util.List;

public interface VoedselgroepenServicesImpl {
    Voedselgroepen createBetalingVoedsel(Voedselgroepen voedsel);
    List<Voedselgroepen> getAllBetalingenVoedsel();
    Voedselgroepen getBetalingVoedselById(Long id);

    void updateBetalingVoedsel(Long id, Voedselgroepen updateDetails);
    void deleteBetalingVoedselById(Long id);
}
