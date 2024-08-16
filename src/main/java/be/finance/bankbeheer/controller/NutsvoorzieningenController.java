package be.finance.bankbeheer.controller;

import be.finance.bankbeheer.model.Nutsvoorziening;
import be.finance.bankbeheer.services.NutsvoorzieningServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/betalingen/nutsvoorzieningen")
public class NutsvoorzieningenController {
    @Autowired
    private NutsvoorzieningServices nutsvoorzieningServices;

    //GET ALL
    @GetMapping("/all")
    public List<Nutsvoorziening> getAllNutsvoorzieningen(){
        return nutsvoorzieningServices.getAllNutsvoorzieningen();
    }
    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Nutsvoorziening> getNutsvoorzieningById(@PathVariable(value = "id")Long id){
        try
        {
            Nutsvoorziening nutsvoorziening = nutsvoorzieningServices.getNutsvoorzieningById(id);
            return new ResponseEntity<>(nutsvoorziening, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //POST
    @PostMapping("/new")
    public ResponseEntity<String> createNutsvoorziening(@RequestBody Nutsvoorziening nutsvoorziening){
        try{
            nutsvoorzieningServices.createNutsvoorziening(nutsvoorziening);
            return ResponseEntity.ok("Betaling nutsvoorziening werd succesvol ingevoerd!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Connectieprobleem met database, probeer later opnieuw");
        }
    }
    //UPDATE - PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBetalingNutsvoorziening(@PathVariable(value="id")long id,
                                                        @RequestBody Nutsvoorziening updateNutsvoorziening){
        try{
            nutsvoorzieningServices.updateNutsvoorziening(id,updateNutsvoorziening);
            return ResponseEntity.ok("Betaling werd succesvol geupdated!");
        }catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Problemen met connectie, probeer later opnieuw.");
        }
    }

    //DELETE

    @DeleteMapping("/{id}")
    public void deleteBetalingNutsvoorzieningById(@PathVariable(value="id")Long id){
        nutsvoorzieningServices.deleteNutsvoorzieningById(id);
        ResponseEntity.ok("Nutsvoorziening werd succesvol verwijderd!");
    }
}
