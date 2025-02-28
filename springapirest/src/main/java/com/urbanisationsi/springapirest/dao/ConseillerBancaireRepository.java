package com.urbanisationsi.springapirest.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.urbanisationsi.springapirest.modele.ConseillerBancaire;

public interface ConseillerBancaireRepository extends CrudRepository<ConseillerBancaire, Integer> {

    ConseillerBancaire findByNomOrPrenom(String nom, String prenom);
    ConseillerBancaire findByNumeroBureau(Long numeroBureau);
    List<ConseillerBancaire> findByNumeroPersonne(Long numeroPersonne);
}
