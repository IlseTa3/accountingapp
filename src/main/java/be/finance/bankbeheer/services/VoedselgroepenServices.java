package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Voedselgroepen;
import be.finance.bankbeheer.repository.VoedselgroepenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VoedselgroepenServices implements VoedselgroepenServicesImpl{
    @Autowired
    private VoedselgroepenRepository voedselgroepenRepository;

    //CREATE
    @Override
    public Voedselgroepen createBetalingVoedsel(Voedselgroepen voedsel) {
        try {
            return voedselgroepenRepository.save(voedsel);
        }catch (Exception e){
            throw new RuntimeException("Fout bij opslaan van betaling in de database");
        }
    }
    //READ all
    @Override
    public List<Voedselgroepen> getAllBetalingenVoedsel() {
        return voedselgroepenRepository.findAll();
    }

    //READ by Id
    @Override
    public Voedselgroepen getBetalingVoedselById(Long id) {
        return voedselgroepenRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Deze betaling werd niet gevonden"));
    }


    //Update by Id
    @Override
    public void updateBetalingVoedsel(Long id, Voedselgroepen updateDetails) {
        Optional<Voedselgroepen> optionalVoedselgroepen = voedselgroepenRepository.findById(id);

        if(optionalVoedselgroepen.isPresent()){
            Voedselgroepen updateBestaandeBetaling   = optionalVoedselgroepen.get();
            updateBestaandeBetaling.setDatumAankoop(updateDetails.getDatumAankoop());
            updateBestaandeBetaling.setNaamWinkel(updateDetails.getNaamWinkel());
            updateBestaandeBetaling.setBedrag(updateDetails.getBedrag());
            updateBestaandeBetaling.setSoortBetaling(updateDetails.getSoortBetaling());
            try{
                voedselgroepenRepository.save(updateBestaandeBetaling);
            }catch(Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Problemen met database connectie. Probeer later opnieuw");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Betaling werd niet gevonden!");
        }

    }


    //DELETE by ID
    @Override
    public void deleteBetalingVoedselById(Long id) {
        voedselgroepenRepository.deleteById(id);
    }


}
