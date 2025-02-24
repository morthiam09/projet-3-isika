package com.urbanisationsi.springdata10.service;

import com.urbanisationsi.springdata10.dao.ConseillerBancaireRepository;
import com.urbanisationsi.springdata10.modele.ConseillerBancaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ConseillerBancaireService {

    @Autowired
    private ConseillerBancaireRepository conseillerBancaireRepository;

    private static final Logger log = LoggerFactory.getLogger(ConseillerBancaireService.class);

    public ConseillerBancaire saveConseillerBancaire(ConseillerBancaire conseillerBancaire) {
        if (validateConseillerBancaire(conseillerBancaire)) {
            ConseillerBancaire savedConseiller = conseillerBancaireRepository.save(conseillerBancaire);
            log.info("Conseiller bancaire sauvegardé : {}", savedConseiller);
            return savedConseiller;
        } else {
            log.error("Données invalides pour le conseiller bancaire : {}", conseillerBancaire);
            return null;
        }
    }

    public List<ConseillerBancaire> findAllConseillersBancaires() {
        List<ConseillerBancaire> conseillers = (List<ConseillerBancaire>) conseillerBancaireRepository.findAll();
        log.info("Liste des conseillers bancaires : {}", conseillers);
        return conseillers;
    }


    private ConseillerBancaire createConseillerBancaire(Long numeroPersonne, String nom, String prenom, LocalDate dateNaissance) {
        ConseillerBancaire conseillerBancaire = new ConseillerBancaire();
        conseillerBancaire.setNumeroPersonne(numeroPersonne);
        conseillerBancaire.setNom(nom);
        conseillerBancaire.setPrenom(prenom);
        conseillerBancaire.setDateNaissance(dateNaissance);
        return conseillerBancaire;
    }

    private boolean validateConseillerBancaire(ConseillerBancaire conseillerBancaire) {
        if (conseillerBancaire == null) {
            return false;
        }
        if (conseillerBancaire.getNumeroPersonne() == null || conseillerBancaire.getNumeroPersonne() <= 0) {
            return false;
        }
        if (conseillerBancaire.getNom() == null || conseillerBancaire.getNom().trim().isEmpty()) {
            return false;
        }
        if (conseillerBancaire.getPrenom() == null || conseillerBancaire.getPrenom().trim().isEmpty()) {
            return false;
        }
        if (conseillerBancaire.getDateNaissance() == null) {
            return false;
        }
        return true;
    }
}