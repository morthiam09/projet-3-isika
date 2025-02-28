package com.urbanisationsi.mongoDB.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.urbanisationsi.mongoDB.dao.GestionnairePrevoyanceRepository;
import com.urbanisationsi.mongoDB.dao.RoleRepository;
import com.urbanisationsi.mongoDB.modele.GestionnairePrevoyance;
import com.urbanisationsi.mongoDB.modele.Role;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration // permet de dire à Spring que cette classe est une classe de configuration, c'est-à-dire qu'elle contient des beans
public class GestionnairePrevoyanceService {

    private Logger log = LoggerFactory.getLogger(this.getClass()); 
 
    @Bean 
    CommandLineRunner initialiser(GestionnairePrevoyanceRepository gpr, RoleRepository rp) { 
 
        return args -> {  
            log.info("Initialisation des données"); 
            // Création des rôles  
            if (rp.findByRole("ADMIN") == null) {
                Role role1 = new Role();
                role1.setRole("ADMIN"); 
                rp.save(role1);
            }
            if (rp.findByRole("USER") == null) {
                Role role2 = new Role(); 
                role2.setRole("USER"); 
                rp.save(role2);
            }
            if (rp.findByRole("GEST") == null) {
                Role role3 = new Role();
                role3.setRole("GEST"); 
                rp.save(role3);
            }

            // Création des gestionnaires de prévoyance
            if (gpr.findByMail("mor@gmail.com").size() == 0) {
                Role adminRole = rp.findByRole("ADMIN");
                Set<Role> roles = Set.of(adminRole);
                GestionnairePrevoyance gp1 = creerGestionnairePrevoyance("mor@gmail.com", "mor", "Mor Diop", true, roles);
                gpr.save(gp1);
            }
            if (gpr.findByMail("raoul@gmail.com").size() == 0) {
                Role userRole = rp.findByRole("USER");
                Set<Role> roles = Set.of(userRole);
                GestionnairePrevoyance gp2 = creerGestionnairePrevoyance("raoul@gmail.com", "raoul", "Raoul Diop", true, roles);
                gpr.save(gp2);
            }
            if (gpr.findByMail("alexia@gmail.com").size() == 0) {
                Role gestRole = rp.findByRole("GEST");
                Role userRole = rp.findByRole("USER");
                Set<Role> roles = Set.of(gestRole, userRole);
                GestionnairePrevoyance gp3 = creerGestionnairePrevoyance("alexia@gmail.com", "alexia", "Alexia Diop", true, roles);
                gpr.save(gp3);
            }
            log.info("Liste des rôles");
            rp.findAll().forEach(role -> log.info(role.toString()));

            log.info("Liste des gestionnaires de prévoyance");
            gpr.findAll().forEach(gp -> log.info(gp.toString()));
        }; 
    } 

    private GestionnairePrevoyance creerGestionnairePrevoyance(String mail, String motdepasse, String nomcomplet, boolean active, Set<Role> roles) {
        GestionnairePrevoyance gp = new GestionnairePrevoyance();
        gp.setMail(mail);
        gp.setMotdepasse(motdepasse);
        gp.setNomcomplet(nomcomplet);
        gp.setActive(active);
        gp.setRoles(roles);
        return gp;
    }
}
