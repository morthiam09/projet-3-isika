package com.urbanisationsi.springdataH2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.urbanisationsi.springdataH2.dao.GarantieRepository;
import com.urbanisationsi.springdataH2.dao.ProduitRepository;
import com.urbanisationsi.springdataH2.modele.Garantie;
import com.urbanisationsi.springdataH2.modele.Produit;

import java.util.Set;


@Configuration
public class InitialisationH2 {

     private Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDatabase(ProduitRepository produitRepository, GarantieRepository garantieRepository) {
        return args -> {
            Garantie g1 = new Garantie(1200L, "Garantie 1 an");
            Garantie g2 = new Garantie(800L, "Garantie 2 ans");
            garantieRepository.save(g1);
            garantieRepository.save(g2);

            Produit p1 = new Produit("Ordinateur", 2000L, 1200.0);
            Produit p2 = new Produit("Téléphone", 3000L, 800.0);

            p1.setGaranties(Set.of(g1, g2)); // L'ordinateur a 1 an et 2 ans de garantie
            p2.setGaranties(Set.of(g1)); // Le téléphone a seulement 1 an de garantie

            produitRepository.save(p1);
            produitRepository.save(p2);

            // Affichage des garanties
            log.info("Garanties enregistrées :");
            for (Garantie garantie : garantieRepository.findAll()) {
                log.info(garantie.toString());
            }

            // Affichage des produits
            log.info("Produits enregistrés :");
            for (Produit produit : produitRepository.findAll()) {
                log.info(produit.toString());
            }
        };
    }
}

