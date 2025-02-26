package com.urbanisationsi.springdata04.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanisationsi.springdata04.dao.AssureRepository;
import com.urbanisationsi.springdata04.modele.Assure;

@Service
public class AssureService {

    @Autowired
    private AssureRepository assureRepository;

    public List<Assure> findAll(){
        return (List<Assure>) assureRepository.findAll();
    }

    public List<Assure>  findByNumeroPersonne(Long numeroPersonne){
        return assureRepository.findByNumeroPersonne(numeroPersonne);
    }

    public List<Assure> findByNomAndPrenom(String nom, String prenom){
        return assureRepository.findByNomAndPrenom(nom, prenom);
    }

    public List<Assure> findByNomOrPrenom(String nom, String prenom){
        return assureRepository.findByNomOrPrenom(nom, prenom);
    }

    public List<Assure> findByDateNaissance(LocalDate dateNaissance){
        return assureRepository.findByDateNaissance(dateNaissance);
    }

    public List<Assure> findByDossierMedical(String dossierMedical){
        return assureRepository.findByDossierMedical(dossierMedical);
    }

    public List<Assure> findByNomContaining(String nom){
        return assureRepository.findByNomContaining(nom);
    }

    public List<Assure> findByDateNaissanceBefore(LocalDate date){
        return assureRepository.findByDateNaissanceBefore(date);
    }

    public Assure saveAssure(Assure assure) {
            return assureRepository.save(assure);
    }
}