package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.OverigeBetaling;
import be.finance.bankbeheer.repository.OverigeBetalingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OverigeBetalingServices {
    @Autowired
    private OverigeBetalingRepository overigeBetalingRepository;
    //CREATE
    public OverigeBetaling createOverigeBetaling(OverigeBetaling betaling){
        return overigeBetalingRepository.save(betaling);
    }

    //READ all
    public List<OverigeBetaling> getAllOverigeBetalingen(){
        return overigeBetalingRepository.findAll();
    }

    //READ by ID
    public OverigeBetaling getOverigeBetalingById(Long id){
        return overigeBetalingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Betaling werd niet gevonden!"));
    }

    //UPDATE by ID
    public OverigeBetaling updateOverigeBetaling(Long id, OverigeBetaling updateDetails){
        OverigeBetaling updateBestaandeBetaling = overigeBetalingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Betaling werd niet gevonden!"));
        updateBestaandeBetaling.setDatum(updateDetails.getDatum());
        updateBestaandeBetaling.setPeriode(updateDetails.getPeriode());
        updateBestaandeBetaling.setLeveranciers(updateDetails.getLeverancier());
        updateBestaandeBetaling.setKlantnr(updateDetails.getKlantnr());
        updateBestaandeBetaling.setBedrag(updateDetails.getBedrag());
        updateBestaandeBetaling.setSoortBetaling(updateDetails.getSoortBetaling());
        updateBestaandeBetaling.setBetaalperiode(updateDetails.getBetaalperiode());
        return overigeBetalingRepository.save(updateBestaandeBetaling);

    }

    //DELETE by ID
    public void deleteOverigeBetalingById(Long id){
        overigeBetalingRepository.deleteById(id);
    }
}
