package com.urbanisationsi.springapirest.controlleur;



import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.urbanisationsi.springapirest.exceptionsmetier.AssureIntrouvableException;
import com.urbanisationsi.springapirest.modele.Assure;
import com.urbanisationsi.springapirest.service.AssureService;
import com.urbanisationsi.springapirest.service.ConseillerBancaireService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/assure")
@Transactional // pour gérer les transactions, c'est à dire que toutes les méthodes de ce controlleur seront exécutées dans une transaction. Si une méthode échoue, toutes les opérations effectuées par cette méthode seront annulées.
public class AssureControlleur {

    @Autowired
    private AssureService assureService;

    private static final Logger log = LoggerFactory.getLogger(ConseillerBancaireService.class);

    @GetMapping(path = "numero/{numeroAssure}") 
    public List<Assure> rechercherAssureNumeroAssure(@PathVariable Long numeroAssure) { 
 
        List<Assure> assures = assureService.findByNumeroAssure(numeroAssure); 
 
        // if (assures.isEmpty()) throw new 
        //AssureIntrouvableException("L'assure avec le // numero " + numeroAssure + " n'existe pas !"); 
 
        log.info("--------------------------- Récupération de l'assuré avec numéro assuré = {}", numeroAssure); 
 
        return assures;
    }

    @GetMapping(path = "/lister") 
    public @ResponseBody Iterable<Assure> getAllAssures() { 
           log.info("--------------------------- Appel à getAllAssures()"); 
           return assureService.findAll(); 
       }

    @PostMapping(path = "/ajouter") 
    public Assure creerAssure(@Valid @RequestBody Assure assure) { 
 
        if (assure == null) 
            throw new AssureIntrouvableException("L'assure est  null !"); 
        return assureService.saveAssure(assure); 
    }

    @DeleteMapping(path = "/supprimer/{numeroAssure}") 
    public void supprimerAssurer(@PathVariable Long numeroAssure) { 
        assureService.deleteAssure(numeroAssure); 
    } 

    @PutMapping(path = "/modifier") 
    public void modifierAssure(@RequestBody Assure assure) { 
 
        assureService.updateAssure(assure); 
    } 
 
    @PatchMapping("/{id}/{nom}") 
    public ResponseEntity<Assure> modifierAssure(@PathVariable Integer id, @PathVariable String nom) { 
        try { 
            Assure assure = assureService.findById(id).get(); 
            assure.setNom(nom); 
            return new ResponseEntity<Assure>(assureService.saveAssure(assure), HttpStatus.OK); 
        } catch (Exception e) { 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        } 
    } 

    @GetMapping(path = "/{nom}/{prenom}")
    public List<Assure> rechercherAssureNomPrenom(@PathVariable String nom, @PathVariable String prenom) {
        List<Assure> assures = assureService.findByNomAndPrenom(nom, prenom);
        if (assures.isEmpty())
            throw new AssureIntrouvableException("L'assure avec le nom " + nom + " et le prenom " + prenom + " n'existe pas !");
        return assures;
    }

    @GetMapping(path = "/{dateNaissance}")
    public List<Assure> rechercherAssureDateNaissance(@PathVariable LocalDate dateNaissance) {
        List<Assure> assures = assureService.findByDateNaissance(dateNaissance);
        if (assures.isEmpty())
            throw new AssureIntrouvableException("L'assure avec la date de naissance " + dateNaissance + " n'existe pas !");
        return assures;
    }
}
