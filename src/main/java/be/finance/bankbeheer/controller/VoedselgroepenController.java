package be.finance.bankbeheer.controller;

import be.finance.bankbeheer.model.Voedselgroepen;
import be.finance.bankbeheer.services.VoedselgroepenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/betalingen/voedsel")
public class VoedselgroepenController {
    @Autowired
    private VoedselgroepenServices voedselgroepenServices;

    //GET all
    @GetMapping("/")
    public List<Voedselgroepen> getAllBetalingenVoedsel(){
        return voedselgroepenServices.getAllBetalingenVoedsel();
    }

    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Voedselgroepen> getBetalingVoedselById(@PathVariable(value = "id") Long id){
        try
        {
            Voedselgroepen voedsel = voedselgroepenServices.getBetalingVoedselById(id);
            return new ResponseEntity<>(voedsel,HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //POST
    @PostMapping("/")
    public ResponseEntity<String> createBetalingVoedsel(@RequestBody Voedselgroepen voedsel){
        try{
            voedselgroepenServices.createBetalingVoedsel(voedsel);
            return ResponseEntity.ok("Betaling werd succesvol ingevoerd!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Connectieprobleem met de database, probeer later opnieuw");
        }
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBetalingVoedsel(@PathVariable(value = "id") long id, @RequestBody Voedselgroepen updateBetaling){
       try{
           voedselgroepenServices.updateBetalingVoedsel(id,updateBetaling);
           return ResponseEntity.ok("Betaling werd succesvol geupdated!");
       }catch(NoSuchElementException e){
           return ResponseEntity.notFound().build();
       }catch (RuntimeException e){
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Problemen met connectie database! Probeer later opnieuw!");
       }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteBetalingVoedselById(@PathVariable(value = "id")Long id){
        voedselgroepenServices.deleteBetalingVoedselById(id);
        ResponseEntity.ok("Betaling werd succesvol verwijderd!");
    }
}
