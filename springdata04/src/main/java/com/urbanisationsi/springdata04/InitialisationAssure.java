package com.urbanisationsi.springdata04;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.urbanisationsi.springdata04.modele.Assure;
import com.urbanisationsi.springdata04.service.AssureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class InitialisationAssure implements ApplicationRunner {
    @Autowired
    private AssureService assureService;

    private Logger log = LoggerFactory.getLogger(InitialisationAssure.class);
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Assure> assures = List.of(
            createAssure(1000L, "Quraishi", "Jalal", LocalDate.of(2000, Month.MARCH, 29), 2000L, "Dossier médical de Jalal Quraishi"),
            createAssure(1001L, "Tamo", "Raoul", LocalDate.of(1995, Month.JULY, 15), 2001L, "Dossier médical de Raoul Tamo"),
            createAssure(1002L, "Thaim", "Mor", LocalDate.of(1988, Month.DECEMBER, 5), 2002L, "Dossier médical de Sophie Leroy"));

        // nous allons verifier si les données sont valides avant de les sauvegarder
        assures.forEach(assure -> { 
            if (validateAssure(assure)) {
                assureService.saveAssure(assure);
                log.info("Assuré sauvegardé : {}", assure);
            } else {
                log.error("Données invalides pour l'assuré : {}", assure);
            }
        });

        // rechercher tous les assurés
        List<Assure> allAssures = (List<Assure>) assureService.findAll(); // findAll() est une méthode de CrudRepository qui retourne la liste de toutes les entités de la table correspondante
        log.info("Liste des assurés : {}", allAssures);

        // rechercher par numéro personne
        List<Assure> foundAssure = assureService.findByNumeroPersonne(1002L);
        log.info("Assuré trouvé avec numéro personne 1002 : {}", foundAssure);

        // rechercher par nom et prénom
        List<Assure> foundAssures = assureService.findByNomAndPrenom("Martin", "Marie");
        log.info("Assurés trouvés avec nom Martin et prénom Marie : {}", foundAssures);

        // rechercher par date de naissance
        List<Assure> foundPersonne = assureService.findByDateNaissance(LocalDate.of(1995, Month.JULY, 15));
        log.info("Personne trouvée avec date de naissance 1995-07-15 : {}", foundPersonne);

        // rechercher par un dossier médical
        List<Assure> foundPersonne2 = assureService.findByDossierMedical("Dossier médical de Sophie Leroy");
        log.info("Personne trouvée avec dossier médical Dossier médical de Sophie Leroy : {}", foundPersonne2);

        // rechercher par un nom contenant un chain de caractère
        List<Assure> foundAssuresByNom = assureService.findByNomContaining("Martin");
        log.info("Assurés trouvés avec nom contenant Martin : {}", foundAssuresByNom);

        // rechercher par une date de naissance avant une date donnée
        List<Assure> foundAssuresByDate = assureService.findByDateNaissanceBefore(LocalDate.of(1990, Month.JANUARY, 1)); 
        log.info("Assurés trouvés avec date de naissance avant 1995-01-01 : {}", foundAssuresByDate);
    }

    private Assure createAssure(Long numeroPersonne, String nom, String prenom, LocalDate dateNaissance, Long numeroAssure, String dossierMedical) {

        if (assureService.findByNumeroPersonne(numeroPersonne) != null) {
            log.error("Assuré avec le numéro de personne {} existe déjà", numeroPersonne);
            return null;
        } 
        Assure assure = new Assure();
        assure.setNumeroPersonne(numeroPersonne);
        assure.setNom(nom);
        assure.setPrenom(prenom);
        assure.setDateNaissance(dateNaissance);
        assure.setNumeroAssure(numeroAssure);
        assure.setDossierMedical(dossierMedical);
        return assure;

    }

    private boolean validateAssure(Assure assure) {
        if (assure == null) {
            return false;
        }
        if (assure.getNumeroPersonne() == null || assure.getNumeroPersonne() <= 0) {
            return false;
        }
        if (assure.getNom() == null || assure.getNom().trim().isEmpty()) {
            return false;
        }
        if (assure.getPrenom() == null || assure.getPrenom().trim().isEmpty()) {
            return false;
        }
        if (assure.getDateNaissance() == null) {
            return false;
        }
        if (assure.getNumeroAssure() == null || assure.getNumeroAssure() <= 0) {
            return false;
        }
        if (assure.getDossierMedical() == null || assure.getDossierMedical().trim().isEmpty()) {
            return false;
        }
        return true;
    }
}