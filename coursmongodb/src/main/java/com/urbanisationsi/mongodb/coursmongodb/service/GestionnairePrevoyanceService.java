package com.urbanisationsi.mongodb.coursmongodb.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.urbanisationsi.mongodb.coursmongodb.dao.GestionnairePrevoyanceRepository;
import com.urbanisationsi.mongodb.coursmongodb.dao.RoleRepository;
import com.urbanisationsi.mongodb.coursmongodb.modele.GestionnairePrevoyance;
import com.urbanisationsi.mongodb.coursmongodb.modele.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Configuration
public class GestionnairePrevoyanceService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner initialiser(GestionnairePrevoyanceRepository gpr, RoleRepository rp) {

        return args -> {

            Role adminRole = rp.findByRole("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                rp.save(newAdminRole);
            }

            Role userRole = rp.findByRole("USER");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                rp.save(newUserRole);
            }

            Role gestRole = rp.findByRole("GEST");
            if (gestRole == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("GEST");
                rp.save(newUserRole);
            }

            List<GestionnairePrevoyance> gpadmin = gpr.findByMail("aya@a.ma");
            log.info("******************* gpadmin :" + gpadmin);
            if (gpadmin.size() == 0) {
                GestionnairePrevoyance newGp = new GestionnairePrevoyance();
                newGp.setNomcomplet("AYA");
                newGp.setMail("aya@a.ma");
                newGp.setMotdepasse("motdepasse");
                newGp.setActive(true);
                Set<Role> roles = new HashSet<>();
                roles.add(rp.findByRole("ADMIN"));
                newGp.setRoles(roles);
                gpr.save(newGp);
            }

            List<GestionnairePrevoyance> gpuser = gpr.findByMail("kinda@a.ma");
            log.info("================= gpuser :" + gpuser);
            if (gpuser.size() == 0) {
                GestionnairePrevoyance newGp = new GestionnairePrevoyance();
                newGp.setNomcomplet("KINDA");
                newGp.setMail("kinda@a.ma");
                newGp.setMotdepasse("motdepasse");
                newGp.setActive(true);
                Set<Role> roles = new HashSet<>();
                roles.add(rp.findByRole("USER"));
                newGp.setRoles(roles);
                gpr.save(newGp);
            }

            List<GestionnairePrevoyance> gpgest = gpr.findByMail("pierre@a.fr");
            log.info("================= gpgest :" + gpgest);
            if (gpgest.size() == 0) {
                GestionnairePrevoyance newGp = new GestionnairePrevoyance();
                newGp.setNomcomplet("PIERRE");
                newGp.setMail("pierre@a.fr");
                newGp.setMotdepasse("motdepasse");
                newGp.setActive(true);
                Set<Role> roles = new HashSet<>();
                roles.add(rp.findByRole("USER"));
                roles.add(rp.findByRole("GEST"));
                newGp.setRoles(roles);
                gpr.save(newGp);
            }
        };
    }
}
