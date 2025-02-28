package com.jrm.reviz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.jrm.reviz.dao.StagiaireRepository;
import com.jrm.reviz.modele.Stagiaire;

@Configuration
public class Initalisation {

    @Bean
	CommandLineRunner init(StagiaireRepository stagiaireRepository) {
        return args -> {
            Stagiaire s1 = new Stagiaire();
            s1.setNom("TAMO");
            s1.setPrenom("Raoul");
            s1.setEmail("raoul@gmail.com");
            s1.setTelephone("12334");
            stagiaireRepository.save(s1);

            Stagiaire s2 = new Stagiaire();
            s2.setNom("Quarshi");
            s2.setPrenom("Jalal");
            s2.setEmail("jalal@gmail.com");
            s2.setTelephone("23112");
            stagiaireRepository.save(s2);
        };
    }
}
