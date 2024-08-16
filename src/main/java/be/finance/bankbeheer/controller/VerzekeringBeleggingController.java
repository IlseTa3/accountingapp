package be.finance.bankbeheer.controller;

import be.finance.bankbeheer.model.VerzekeringBelegging;
import be.finance.bankbeheer.services.VerzekeringBeleggingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/betalingen/verzekering-beleggingen")
public class VerzekeringBeleggingController {
    @Autowired
    private VerzekeringBeleggingServices verzekeringBeleggingServices;

    //GET all
    @GetMapping("/all")
    public List<VerzekeringBelegging> getAllVerzekeringenEnBeleggingen(){
        return verzekeringBeleggingServices.getAllVerzekeringBeleggingen();
    }
    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<VerzekeringBelegging> getVerzekeringBeleggingById(@PathVariable(value = "id") Long id){
        try
        {
            VerzekeringBelegging verzekeringBelegging = verzekeringBeleggingServices.getVerzekeringBeleggingById(id);
            return new ResponseEntity<>(verzekeringBelegging, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    //POST
    @PostMapping("/new")
    public ResponseEntity<String> createVerzekeringBelegging(@RequestBody VerzekeringBelegging verzekeringBelegging){
        try{
            verzekeringBeleggingServices.createVerzekeringBelegging(verzekeringBelegging);
            return ResponseEntity.ok("Betaling werd succesvol ingevoerd!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Connectieprobleem met de database, probeer later opnieuw");
        }
    }

    //PUT - UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateVerzekeringBelegging(@PathVariable(value = "id") long id, @RequestBody VerzekeringBelegging updateVerzekBel){
        try{
            verzekeringBeleggingServices.updateVerzekeringBeleggingById(id,updateVerzekBel);
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
    public void deleteVerzekeringBeleggingById(@PathVariable(value = "id")Long id){
        verzekeringBeleggingServices.deleteVerzekeringBeleggingById(id);
        ResponseEntity.ok("Betaling werd succesvol verwijderd!");
    }

}
