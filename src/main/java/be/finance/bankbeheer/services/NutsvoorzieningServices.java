package be.finance.bankbeheer.services;

import be.finance.bankbeheer.model.Nutsvoorziening;
import be.finance.bankbeheer.repository.NutsvoorzieningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NutsvoorzieningServices {

    @Autowired
    private NutsvoorzieningRepository nutsvoorzieningRepository;
    //CREATE
    public Nutsvoorziening createBetalingNutsvoorziening(Nutsvoorziening nutsvoorziening){
        return  nutsvoorzieningRepository.save(nutsvoorziening);
    }

    //READ all
    public List<Nutsvoorziening> getAllBetalingenNutsvoorziening(){
        return nutsvoorzieningRepository.findAll();
    }

    //READ by ID
    public Nutsvoorziening getBetalingNutsvoorzieningById(Long id){
        return nutsvoorzieningRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Voorziening werd niet gevonden. Moet nog aangemaakt worden!"));
    }

    //UPDATE by ID
    public Nutsvoorziening updateBetalingNutsvoorziening(Long id, Nutsvoorziening updateDetails){
        Nutsvoorziening updateBestaandeNutsvoorziening = nutsvoorzieningRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Voorziening werd niet gevonden. Maak deze aan!"));
        updateBestaandeNutsvoorziening.setDatum(updateDetails.getDatum());
        updateBestaandeNutsvoorziening.setPeriode(updateDetails.getPeriode());
        updateBestaandeNutsvoorziening.setNaamBedrijf(updateDetails.getNaamBedrijf());
        updateBestaandeNutsvoorziening.setSoortNutsvoorziening(updateDetails.getSoortNutsvoorziening());
        updateBestaandeNutsvoorziening.setKlantnummer(updateDetails.getKlantnummer());
        updateBestaandeNutsvoorziening.setApparaatNr(updateDetails.getApparaatNr());
        updateBestaandeNutsvoorziening.setBedrag(updateDetails.getBedrag());
        updateBestaandeNutsvoorziening.setBetaalperiode(updateDetails.getBetaalperiode());
        return nutsvoorzieningRepository.save(updateBestaandeNutsvoorziening);
    }

    //DELETE by ID
    public void deleteBetalingNutsvoorzieningById(Long id){
        nutsvoorzieningRepository.deleteById(id);
    }
}
