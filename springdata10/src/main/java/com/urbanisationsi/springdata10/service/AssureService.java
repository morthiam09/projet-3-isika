package com.urbanisationsi.springdata10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.urbanisationsi.springdata10.dao.AssureRepository;
import com.urbanisationsi.springdata10.modele.Assure;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger; // SLF4J : Simple Logging Facade for Java. C'est une interface de logging qui permet de choisir un framework de logging à l'exécution (par exemple log4j, logback, java.util.logging, etc.). il permet de faire du logging de manière simple et de changer de framework de logging sans changer le code.
import org.slf4j.LoggerFactory;

@Service // cette classe est un bean Spring, c'est-à-dire un objet géré par Spring
public class AssureService implements ApplicationRunner{

    @Autowired // injection de dépendance : Spring va automatiquement instancier un objet de type AssureRepository et l'injecter dans cette propriété
    private AssureRepository assureRepository;

    private Logger log = LoggerFactory.getLogger(AssureService.class); // SLF4J : LoggerFactory est une classe qui permet de créer des instances de Logger. getLogger est une méthode statique de LoggerFactory qui permet de créer une instance de Logger pour une classe donnée. Cette instance de Logger est utilisée pour faire du logging.

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Assure a1 = new Assure();
        a1.setNumeroPersonne(1000L);
        a1.setNom("Martin");
        a1.setPrenom("Marie");
        a1.setDateNaissance(LocalDate.of(2000, Month.MARCH, 29));

        Assure a2 = new Assure();
        a2.setNumeroPersonne(1001L);
        a2.setNom("Durand");
        a2.setPrenom("Paul");
        a2.setDateNaissance(LocalDate.of(1995, Month.JULY, 15));

        Assure a3 = new Assure();
        a3.setNumeroPersonne(1002L);
        a3.setNom("Leroy");
        a3.setPrenom("Sophie");
        a3.setDateNaissance(LocalDate.of(1988, Month.DECEMBER, 5));

        assureRepository.save(a1);
        assureRepository.save(a2);  
        //assureRepository.save(a3);

        log.info("Liste des assurés :", assureRepository.findAll());

    }

}
