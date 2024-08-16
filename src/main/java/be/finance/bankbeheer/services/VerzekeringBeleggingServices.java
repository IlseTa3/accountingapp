package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.VerzekeringBelegging;
import be.finance.bankbeheer.repository.VerzekeringBeleggingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VerzekeringBeleggingServices implements VerzekeringBeleggingServicesImpl {
    @Autowired
    private VerzekeringBeleggingRepository verzekeringBeleggingRepository;

    //CREATE
    @Override
    public VerzekeringBelegging createVerzekeringBelegging(VerzekeringBelegging verzekeringBelegging) {
        try{
            return verzekeringBeleggingRepository.save(verzekeringBelegging);
        }catch (Exception e){
            throw new RuntimeException("Fout bij opslaan in database.");
        }
    }

    //READ All
    @Override
    public List<VerzekeringBelegging> getAllVerzekeringBeleggingen() {
        return verzekeringBeleggingRepository.findAll();
    }

    @Override
    public VerzekeringBelegging getVerzekeringBeleggingById(Long id) {
        return verzekeringBeleggingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Verzekering/belegging werd niet gevonden"));
    }

    @Override
    public void updateVerzekeringBeleggingById(Long id, VerzekeringBelegging updateDetails) {
        Optional<VerzekeringBelegging> optionalVerzekBel = verzekeringBeleggingRepository.findById(id);
        if(optionalVerzekBel.isPresent()){
            VerzekeringBelegging updateVerzekBel = optionalVerzekBel.get();
            updateVerzekBel.setDatum(updateDetails.getDatum());
            updateVerzekBel.setNaamVerzekering(updateDetails.getNaamVerzekering());
            updateVerzekBel.setVerzekeringsnr(updateDetails.getVerzekeringsnr());
            updateVerzekBel.setBedrag(updateDetails.getBedrag());
            updateVerzekBel.setBetaalperiode(updateDetails.getBetaalperiode());
            updateVerzekBel.setPeriode(updateDetails.getPeriode());
            updateVerzekBel.setSoortBetaling(updateDetails.getSoortBetaling());
            try{
                verzekeringBeleggingRepository.save(updateVerzekBel);
            }catch(Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Problemen met database connectie. Probeer later opnieuw!");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Betaling werd niet gevonden!");
        }
    }

    @Override
    public void deleteVerzekeringBeleggingById(Long id) {
        verzekeringBeleggingRepository.deleteById(id);
    }
}
