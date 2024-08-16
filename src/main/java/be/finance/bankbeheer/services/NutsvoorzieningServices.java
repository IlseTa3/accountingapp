package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Nutsvoorziening;
import be.finance.bankbeheer.repository.NutsvoorzieningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class NutsvoorzieningServices implements NutsvoorzieningServicesImpl{

    @Autowired
    private NutsvoorzieningRepository nutsvoorzieningRepository;


    //CREATE
    @Override
    public Nutsvoorziening createNutsvoorziening(Nutsvoorziening nutsvoorziening) {
        try{
            return nutsvoorzieningRepository.save(nutsvoorziening);
        }catch (Exception e){
            throw new RuntimeException("Fout bij opslaan in database.");
        }
    }

    //READ all
    @Override
    public List<Nutsvoorziening> getAllNutsvoorzieningen() {
        return nutsvoorzieningRepository.findAll();
    }

    //READ by ID
    @Override
    public Nutsvoorziening getNutsvoorzieningById(Long id) {
        return nutsvoorzieningRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Deze betaling werd niet gevonden."));
    }

    //UPDATE by ID
    @Override
    public void updateNutsvoorziening(Long id, Nutsvoorziening updateDetails) {
        Optional<Nutsvoorziening> optionalNutsvoorziening = nutsvoorzieningRepository.findById(id);
        if(optionalNutsvoorziening.isPresent()){
            Nutsvoorziening updateNutsvoorziening = optionalNutsvoorziening.get();
            updateNutsvoorziening.setDatum(updateDetails.getDatum());
            updateNutsvoorziening.setPeriode(updateDetails.getPeriode());
            updateNutsvoorziening.setNaamBedrijf(updateDetails.getNaamBedrijf());
            updateNutsvoorziening.setSoortNutsvoorziening(updateDetails.getSoortNutsvoorziening());
            updateNutsvoorziening.setKlantnummer(updateDetails.getKlantnummer());
            updateNutsvoorziening.setApparaatNr(updateDetails.getApparaatNr());
            updateNutsvoorziening.setBedrag(updateDetails.getBedrag());
            updateNutsvoorziening.setBetaalperiode(updateDetails.getBetaalperiode());
            updateNutsvoorziening.setSoortBetaling(updateDetails.getSoortBetaling());
            try
            {
                nutsvoorzieningRepository.save(updateNutsvoorziening);
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Problemen met connectie.");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nutsvoorziening werd niet gevonden!");
        }
    }


    //DELETE by ID
    @Override
    public void deleteNutsvoorzieningById(Long id) {
        nutsvoorzieningRepository.deleteById(id);
    }
}
