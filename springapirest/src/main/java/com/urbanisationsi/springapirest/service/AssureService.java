package com.urbanisationsi.springapirest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanisationsi.springapirest.dao.AssureRepository;
import com.urbanisationsi.springapirest.exceptionsmetier.AssureIntrouvableException;
import com.urbanisationsi.springapirest.modele.Assure;

@Service
public class AssureService {

    @Autowired
    private AssureRepository assureRepository;

    public List<Assure> findAll(){
        return (List<Assure>) assureRepository.findAll();
    }

    public Optional<Assure> findById(Integer id){ // optional pour gérer les cas où l'objet n'existe pas
        return assureRepository.findById(id);
    }

    public List<Assure>  findByNumeroPersonne(Long numeroPersonne){
        return assureRepository.findByNumeroPersonne(numeroPersonne);
    }

    public List<Assure> findByNumeroAssure(Long numAssures){
        return assureRepository.findByNumeroAssure(numAssures);
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
    // Ajoutd'un assure
    public Assure saveAssure(Assure assure) {
            return assureRepository.save(assure);
    }

    // Suppression d'un assure
    public void deleteAssure(Long numeroPersonne) {
        Assure assure = findByNumeroPersonne(numeroPersonne).get(0);
        if (assure != null) {
             assureRepository.deleteByNumeroPersonne(numeroPersonne);
        }
        else {
            throw new AssureIntrouvableException("Assure non trouvé");
        }
    }

    // Mise à jour d'un assure
    public Assure updateAssure(Assure assure) {
        return assureRepository.save(assure);
    }
}