package com.urbanisationsi.springdata04.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.springdata04.modele.ConseillerBancaire;

public interface ConseillerBancaireRepository extends CrudRepository<ConseillerBancaire, Integer> {

    ConseillerBancaire findByNomOrPrenom(String nom, String prenom);
    ConseillerBancaire findByNumeroBureau(Long numeroBureau);
    List<ConseillerBancaire> findByNumeroPersonne(Long numeroPersonne);
}
