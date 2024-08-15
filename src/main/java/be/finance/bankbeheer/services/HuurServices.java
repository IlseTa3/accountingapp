package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Huur;
import be.finance.bankbeheer.repository.HuurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HuurServices implements HuurServicesImpl{

    @Autowired
    private HuurRepository huurRepository;

    //CREATE
    @Override
    public Huur createBetalingHuur(Huur huur) {
        return huurRepository.save(huur);
    }

    //READ all
    @Override
    public List<Huur> getAllBetalingenHuur() {
        return huurRepository.findAll();
    }

    //READ by ID
    @Override
    public Huur getBetalingHuurById(Long id) {
        return huurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Deze betaling werd niet gevonden"));
    }

    @Override
    public void updateBetalingHuur(Long id, Huur updateDetails) {
        Optional<Huur> optionalHuur = huurRepository.findById(id);

        if (optionalHuur.isPresent()){
            Huur updateBestaandeHuur = optionalHuur.get();
            updateBestaandeHuur.setDatum(updateDetails.getDatum());
            updateBestaandeHuur.setSoortHuur(updateDetails.getSoortHuur());
            updateBestaandeHuur.setPeriode(updateDetails.getPeriode());
            updateBestaandeHuur.setBedrag(updateDetails.getBedrag());
            updateBestaandeHuur.setSoortBetaling(updateDetails.getSoortBetaling());
            updateBestaandeHuur.setBetaalperiode(updateDetails.getBetaalperiode());
            try{
                huurRepository.save(updateBestaandeHuur);
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Probleem met connectie server, probeer later nog eens");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Deze betaling werd niet gevonden");
        }


    }

    @Override
    public void deleteBetalingHuurById(Long id) {
        huurRepository.deleteById(id);
    }

}
