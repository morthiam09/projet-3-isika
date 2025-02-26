package com.urbanisationsi.springdata10.service;
import java.util.List;

import com.urbanisationsi.springdata10.dao.AssureRepository;
import com.urbanisationsi.springdata10.dao.ConseillerBancaireRepository;
import com.urbanisationsi.springdata10.modele.Assure;
import com.urbanisationsi.springdata10.modele.ConseillerBancaire;
import com.urbanisationsi.springdata10.modele.Personne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class AssureService implements ApplicationRunner {

    @Autowired
    private AssureRepository assureRepository;
    @Autowired
    private ConseillerBancaireRepository conseillerBancaireRepository;

    private static final Logger log = LoggerFactory.getLogger(AssureService.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Assure> assures = List.of(
            createAssure(1000L, "Martin", "Marie", LocalDate.of(2000, Month.MARCH, 29), 2000L, "Dossier médical de Marie Martin"),
            createAssure(1001L, "Durand", "Paul", LocalDate.of(1995, Month.JULY, 15), 2001L, "Dossier médical de Paul Durand"),
            createAssure(1002L, "Leroy", "Sophie", LocalDate.of(1988, Month.DECEMBER, 5), 2002L, "Dossier médical de Sophie Leroy"));

            List<ConseillerBancaire> conseillers = List.of(
            createConseillerBancaire(3222L, "Dupont", "Jeanne", LocalDate.of(1975, Month.JANUARY, 15), 1001),
            createConseillerBancaire(3223L, "Lefevre", "Jul", LocalDate.of(1980, Month.MAY, 25), 1002),
            createConseillerBancaire(3224L, "Lebeuf", "Sebastian", LocalDate.of(1988, Month.DECEMBER, 5), 1003)
        );

        // nous allons verifier si les données sont valides avant de les sauvegarder
        assures.forEach(assure -> { 
            if (validateAssure(assure)) {
                assureRepository.save(assure);
                log.info("Assuré sauvegardé : {}", assure);
            } else {
                log.error("Données invalides pour l'assuré : {}", assure);
            }
        });
       conseillers.forEach(conseiller -> { 
            if (validateAssure(conseiller)) {
                conseillerBancaireRepository.save(conseiller);
                log.info("Conseiller bancaire sauvegardé : {}", conseiller);
            } else {
                log.error("Données invalides pour le conseiller bancaire : {}", conseiller);
            }
        });

        // rechercher tous les assurés
        List<Assure> allAssures = (List<Assure>) assureRepository.findAll(); // findAll() est une méthode de CrudRepository qui retourne la liste de toutes les entités de la table correspondante
        log.info("Liste des assurés : {}", allAssures);

        // rechercher par numéro personne
        List<Assure> foundAssure = assureRepository.findByNumeroPersonne(1002L);
        log.info("Assuré trouvé avec numéro personne 1002 : {}", foundAssure);

        // rechercher par nom et prénom
        List<Assure> foundAssures = assureRepository.findByNomAndPrenom("Martin", "Marie");
        log.info("Assurés trouvés avec nom Martin et prénom Marie : {}", foundAssures);

        // rechercher par date de naissance
        List<Assure> foundPersonne = assureRepository.findByDateNaissance(LocalDate.of(1995, Month.JULY, 15));
        log.info("Personne trouvée avec date de naissance 1995-07-15 : {}", foundPersonne);

        // rechercher par un dossier médical
        List<Assure> foundPersonne2 = assureRepository.findByDossierMedical("Dossier médical de Sophie Leroy");
        log.info("Personne trouvée avec dossier médical Dossier médical de Sophie Leroy : {}", foundPersonne2);

        // rechercher par un nom ou un prénom
        ConseillerBancaire foundConseiller = conseillerBancaireRepository.findByNomOrPrenom("Dupont", "Jean");
        log.info("Conseiller trouvé avec nom Dupont ou prénom Jean : {}", foundConseiller);

        // rechercher par un numéro de bureau
        ConseillerBancaire foundConseiller2 = conseillerBancaireRepository.findByNumeroBureau(1001L);
        log.info("Conseiller trouvé avec numéro de bureau 1001 : {}", foundConseiller2);

        // rechercher par un nom contenant un chain de caractère
        List<Assure> foundAssuresByNom = assureRepository.findByNomContaining("Martin");
        log.info("Assurés trouvés avec nom contenant Martin : {}", foundAssuresByNom);

        // rechercher par une date de naissance avant une date donnée
        List<Assure> foundAssuresByDate = assureRepository.findByDateNaissanceBefore(LocalDate.of(1990, Month.JANUARY, 1)); 
        log.info("Assurés trouvés avec date de naissance avant 1995-01-01 : {}", foundAssuresByDate);

    }

    private Assure createAssure(Long numeroPersonne, String nom, String prenom, LocalDate dateNaissance, Long numeroAssure, String dossierMedical) {

        if (assureRepository.findByNumeroPersonne(numeroPersonne) == null) {
            log.error("Assuré avec le numéro de personne {} existe déjà", numeroPersonne);
            return null;
        } else {
            Assure assure = new Assure();
            assure.setNumeroPersonne(numeroPersonne);
            assure.setNom(nom);
            assure.setPrenom(prenom);
            assure.setDateNaissance(dateNaissance);
            assure.setNumeroAssure(numeroAssure);
            assure.setDossierMedical(dossierMedical);
            return assure;
        }
    }

    private boolean validateAssure(Personne personne) {
        if (personne == null) {
            return false;
        }
        if (personne.getNumeroPersonne() == null || personne.getNumeroPersonne() <= 0) {
            return false;
        }
        if (personne.getNom() == null || personne.getNom().trim().isEmpty()) {
            return false;
        }
        if (personne.getPrenom() == null || personne.getPrenom().trim().isEmpty()) {
            return false;
        }
        if (personne.getDateNaissance() == null) {
            return false;
        }
        return true;
    }
    private ConseillerBancaire createConseillerBancaire(Long numeroPersonne, String nom, String prenom, LocalDate dateNaissance, int numeroBureau) {

        if (conseillerBancaireRepository.findByNumeroPersonne(numeroPersonne) == null) {
            log.error("Conseiller bancaire avec le numéro de personne {} existe déjà", numeroPersonne);
            return null;
        } else {
            ConseillerBancaire cb = new ConseillerBancaire();
            cb.setNumeroPersonne(numeroPersonne);
            cb.setNom(nom);
            cb.setPrenom(prenom);
            cb.setDateNaissance(dateNaissance);
            cb.setNumeroBureau(numeroBureau);
            return cb;
        }
    }
}