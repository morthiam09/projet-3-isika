package com.urbanisationsi.springapirest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.urbanisationsi.springapirest.dao.AssureRepository;
import com.urbanisationsi.springapirest.dao.GarantieRepository;
import com.urbanisationsi.springapirest.dao.ProduitRepository;
import com.urbanisationsi.springapirest.modele.Assure;

@Configuration
public class InitialisationApiRest {

    @Bean 
    CommandLineRunner init(ProduitRepository produitRepository, 
GarantieRepository garantieRepository, 
            AssureRepository assureRepository) { 
 
        return args -> {

            List<Assure> assures = List.of(
                creaAssure(100L, 1000L, "Martin", "Marie", LocalDate.of(2000, Month.MARCH, 29), "Asthmatique"),
                creaAssure(200L, 2000L, "Tamo", "Raoul", LocalDate.of(1990, Month.JANUARY, 19), "Néant"),
                creaAssure(300L, 3000L, "Quarashi", "Jalal", LocalDate.of(2000, Month.MARCH, 29), "Asthmatique"),
                creaAssure(400L, 4000L, "Roy", "Alexia", LocalDate.of(1990, Month.JANUARY, 19), "Néant"),
                creaAssure(500L, 5000L, "Merini", "Manel", LocalDate.of(2000, Month.MARCH, 29), "Asthmatique")
            );
            assures.forEach(assure -> {
                if (!isExist(assureRepository, assure.getNumeroPersonne()) && allInputAreValid(assure)) {
                    assureRepository.save(assure);
                }
            });
        };
    }

    private boolean isExist(AssureRepository assureRepository, Long numeroPersonne) {
        return assureRepository.findByNumeroPersonne(numeroPersonne).size() > 0;
    }

    private boolean allInputAreValid(Assure assure) {
        return assure.getNumeroPersonne() != null && assure.getNumeroAssure() != null && assure.getNom() != null
                && assure.getPrenom() != null && assure.getDateNaissance() != null && assure.getDossierMedical() != null;
    }

    private Assure creaAssure(Long numeroPersonne, Long numeroAssure, String nom, String prenom, LocalDate dateNaissance,String dossierMedical) {
        Assure assure = new Assure();
        assure.setNumeroPersonne(numeroPersonne);
        assure.setNumeroAssure(numeroAssure);
        assure.setNom(nom);
        assure.setPrenom(prenom);
        assure.setDateNaissance(dateNaissance);
        assure.setDossierMedical(dossierMedical);
        return assure;
    }
    
}
