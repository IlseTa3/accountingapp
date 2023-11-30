package be.finance.bankbeheer.controller;

import be.finance.bankbeheer.model.Huur;
import be.finance.bankbeheer.services.HuurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("betalingen/huur")
public class HuurController {
    @Autowired
    private HuurServices huurServices;

    //GET all
    @GetMapping("/")
    public List<Huur> getAllBetalingenHuur(){return huurServices.getAllBetalingenHuur();}

    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Huur> getBetalingHuurById(@PathVariable(value = "id")Long id){
        try{
            Huur huur = huurServices.getBetalingHuurById(id);
            return new ResponseEntity<>(huur, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/")
    public ResponseEntity<String> createBetalingHuur(@RequestBody Huur huur){
        try{
            huurServices.createBetalingHuur(huur);
            return ResponseEntity.ok("Betaling werd succesvol uitgevoerd");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Probleem met connectie database, gelieve later opnieuw te proberen!");
        }
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBetalingHuur(@PathVariable(value = "id")Long id, @RequestBody Huur updateBetaling){
        try{
            huurServices.updateBetalingHuur(id,updateBetaling);
            return ResponseEntity.ok("Update werd succesvol uitgevoerd");
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Connectieprobleem met server. Probeer later opnieuw");
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteBetalingHuurById(@PathVariable(value = "id")Long id){
        huurServices.deleteBetalingHuurById(id);
        ResponseEntity.ok("Betaling werd succesvol verwijderd!");
    }
}
