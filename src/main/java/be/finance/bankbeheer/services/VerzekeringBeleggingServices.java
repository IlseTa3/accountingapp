package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.VerzekeringBelegging;
import be.finance.bankbeheer.repository.VerzekeringBeleggingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VerzekeringBeleggingServices {
    @Autowired
    private VerzekeringBeleggingRepository verzekeringBeleggingRepository;
    //CREATE
    public VerzekeringBelegging createBetalingVerzBel(VerzekeringBelegging verzBel){
        try{
            return verzekeringBeleggingRepository.save(verzBel);
        }catch (Exception e){
            throw new RuntimeException("Fout bij opslaan van betaling in de database");
        }
    }

    //READ all
    public List<VerzekeringBelegging> getAllBetalingenVerzekBel(){
        return verzekeringBeleggingRepository.findAll();
    }

    //READ by ID
    public VerzekeringBelegging getBetalingVerzekBelById(Long id){
        return verzekeringBeleggingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Betaling werd niet gevonden!"));
    }

    //UPDATE by ID
    public ResponseEntity<VerzekeringBelegging> updateBetalingVerzekBel(Long id, VerzekeringBelegging updateDetails){
        VerzekeringBelegging updateBestaandeBetaling = verzekeringBeleggingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Betaling werd niet gevonden"));
        updateBestaandeBetaling.setDatum(updateDetails.getDatum());
        updateBestaandeBetaling.setNaamVerzekering(updateDetails.getNaamVerzekering());
        updateBestaandeBetaling.setBedrag(updateDetails.getBedrag());
        updateBestaandeBetaling.setBetaalperiode(updateDetails.getBetaalperiode());
        return ResponseEntity.ok(updateBestaandeBetaling);
    }

    //DELETE by ID
    public void deleteBetalingVerzekBelegById(Long id){
        verzekeringBeleggingRepository.deleteById(id);
    }
}
