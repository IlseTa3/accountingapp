package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.VerzekeringBelegging;

import java.util.List;

public interface VerzekeringBeleggingServicesImpl {

    VerzekeringBelegging createVerzekeringBelegging(VerzekeringBelegging verzekeringBelegging);
    List<VerzekeringBelegging> getAllVerzekeringBeleggingen();

    VerzekeringBelegging getVerzekeringBeleggingById(Long id);

    void updateVerzekeringBeleggingById(Long id, VerzekeringBelegging updateDetails);
    void deleteVerzekeringBeleggingById(Long id);
}
